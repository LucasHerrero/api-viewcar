package com.concesionario.controller;

import com.concesionario.entity.Brand;
import com.concesionario.repository.BrandRepository;
import com.concesionario.entity.Model;
import com.concesionario.repository.ModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Permite solicitudes de cualquier origen
// Indica que esta clase es un controlador REST
@CrossOrigin
@RestController
// Define la ruta base para todos los endpoints en este controlador
@RequestMapping("/api/v1")
public class BrandsController {
    // Inyecta el repositorio de marcas
    @Autowired
    private BrandRepository brandRepository;

    // Inyecta el repositorio de modelos
    @Autowired
    private ModelRepository modelRepository;

    // Obtiene todas las marcas
    @GetMapping("/brands")
    public List<Brand> findAll() {
        // Devuelve todas las marcas
        return brandRepository.findAll();
    }

    // Obtiene una marca por ID
    @GetMapping("/brands/{id}")
    public ResponseEntity<Brand> findById(@PathVariable int id) {
        // Busca la marca con el ID especificado
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isPresent()) {
            // Si la marca existe, devuelve la marca con un código de estado 200
            return new ResponseEntity<>(optionalBrand.get(), HttpStatus.OK);
        } else {
            // Si la marca no existe, devuelve un código de estado 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtiene una marca por nombre
    @GetMapping("/brands/name/{name}")
    public ResponseEntity<Brand> findByName(@PathVariable String name) {
        // Busca la marca con el nombre especificado
        Optional<Brand> optionalBrand = Optional.ofNullable(brandRepository.findByBrandName(name));
        if (optionalBrand.isPresent()) {
            // Si la marca existe, devuelve la marca con un código de estado 200
            return new ResponseEntity<>(optionalBrand.get(), HttpStatus.OK);
        } else {
            // Si la marca no existe, devuelve un código de estado 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crea una nueva marca
    @PostMapping("/brands/new")
    public Brand save(@RequestBody Brand marca) {
        // Guarda la nueva marca y la devuelve
        return brandRepository.save(marca);
    }

    // Actualiza una marca
    @PutMapping("/brands/{id}")
    public Brand update(@RequestBody Brand marca, @PathVariable int id) {
        // Actualiza la marca con el ID especificado si existe, o guarda la marca como una nueva entidad si no existe
        return brandRepository.findById(id).map(m -> {
            m.setBrandName(marca.getBrandName());
            m.setImage(marca.getImage());
            return brandRepository.save(m);
        }).orElseGet(() -> {
            marca.setId(id);
            return brandRepository.save(marca);
        });
    }

    // Elimina una marca
    @DeleteMapping("/brands/{id}")
    public void delete(@PathVariable int id) {
        // Elimina la marca con el ID especificado
        brandRepository.deleteById(id);
    }

    // Obtiene todos los modelos de una marca
    @GetMapping("/brands/{id}/models")
    public List<Model> findModelsByBrandId(@PathVariable int id) {
        // Devuelve los modelos que pertenecen a la marca con el ID especificado
        return modelRepository.findByBrandId(id);
    }
}