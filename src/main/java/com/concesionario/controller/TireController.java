package com.concesionario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.concesionario.repository.PackageRepository;
import com.concesionario.repository.TireRepository;
import com.concesionario.entity.Tire;
import com.concesionario.entity.TiresDto;
import com.concesionario.repository.TireRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




// Permite solicitudes de cualquier origen
// Indica que esta clase es un controlador REST
@CrossOrigin
@RestController

@RequestMapping("/api/v1")
public class TireController {


    // Inyecta el repositorio de paquetes

    @Autowired
    private PackageRepository packageRepository;


    // Inyecta el repositorio de llantas
    @Autowired
    private TireRepository tireRepository;

    // Obtiene todas las llantas
    @GetMapping("/tires")
    public List<Tire> findAll() {
        return tireRepository.findAll();

    }

    // Obtiene todas las llantas de un paquete
    @GetMapping("/tires/pack/{packId}")
    public List<Tire> findByPack(@PathVariable int packId) {
        // Devuelve todas las llantas de un modelo
        return tireRepository.findByPackId(packId);
    }

  
    @GetMapping("/tires/model/{modelId}")
    public List<Tire> findByModel(@PathVariable int modelId) {
        List<com.concesionario.entity.Package> packages = packageRepository.findByModelId(modelId);
        List<Tire> tires = new ArrayList<>();
        for (com.concesionario.entity.Package pack : packages) {
            tires.addAll(tireRepository.findByPackId(pack.getId()));
        }
        return tires;
    }

    @PostMapping("/tires/new")
    public Tire save(@RequestBody Tire TireObj) {
        // Guarda el nuevo modelo y lo devuelve
        return tireRepository.save(TireObj);
    }

    
    @PutMapping("/tires/{id}")
    public Tire update(@RequestBody TiresDto newTireDto, @PathVariable int id) {
        return tireRepository.findById(id).map(existingTire -> {
            if (newTireDto.getName() != null) {
                existingTire.setName(newTireDto.getName());
            }
            if (newTireDto.getInches() != null) {
                existingTire.setInches(newTireDto.getInches());
            }
            if (newTireDto.getMaterial() != null) {
                existingTire.setMaterial(newTireDto.getMaterial());
            }
            if (newTireDto.getColor() != null) {
                existingTire.setColor(newTireDto.getColor());
            }
            if (newTireDto.getImage() != null) {
                existingTire.setImage(newTireDto.getImage());
            }
            if (newTireDto.getCirculo() != null) {
                existingTire.setCirculo(newTireDto.getCirculo());
            }
            if (newTireDto.getPrice() != null) {
                existingTire.setPrice(newTireDto.getPrice());
            }
            if (newTireDto.getDescription() != null) {
                existingTire.setDescription(newTireDto.getDescription());
            }
            
            return tireRepository.save(existingTire);
        }).orElseThrow(() -> new RuntimeException("Tire not found with id " + id));
    }


}
