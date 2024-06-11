package com.concesionario.controller;

import com.concesionario.entity.ExtColor;
import com.concesionario.entity.ExtColorDto;
import com.concesionario.repository.ExtColorRepository;
import com.concesionario.repository.PackageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Permite solicitudes de cualquier origen
// Indica que esta clase es un controlador REST
@CrossOrigin
@RestController
// Define la ruta base para todos los endpoints en este controlador
@RequestMapping("/api/v1")
public class ExtColorController {
@Autowired
private PackageRepository packageRepository;

    @Autowired
    private ExtColorRepository extColorRepository;

    // Obtiene todos los colores exteriores
    @GetMapping("/extcolors")
    public List<ExtColor> findAll() {
        // Devuelve todos los colores exteriores
        return extColorRepository.findAll();
    }

    //Obtiene todos los colores de un paquete
    @GetMapping("/extcolors/pack/{packId}")
    public List<ExtColor> findByPack(@PathVariable int packId) {
        //Devuelve todos los colores de un paquete
        return extColorRepository.findByPackId(packId);
    }

    @PostMapping("/extcolors/new")
    public ExtColor save(@RequestBody ExtColor ExtColorObj) {
        // Guarda el nuevo modelo y lo devuelve
        return extColorRepository.save(ExtColorObj);
    }

    // Put
    @PutMapping("/extcolors/{extColorId}")
    public ExtColor update(@PathVariable int extColorId, @RequestBody ExtColorDto extColorObj) {
        // Convierte el array de rutas de imágenes en un string separado por comas
        String imageString = String.join(",", extColorObj.getImage());

        // Carga el color exterior correspondiente
        ExtColor extColorToUpdate = extColorRepository.findById(extColorId)
                .orElseThrow();

        // Establece los nuevos valores
        extColorToUpdate.setColor(extColorObj.getColor());
        extColorToUpdate.setImage(imageString);
        extColorToUpdate.setPrice(extColorObj.getPrice());
        extColorToUpdate.setCirculo(extColorObj.getCirculo());

        // Guarda el color exterior actualizado y lo devuelve
        return extColorRepository.save(extColorToUpdate);
    }

    @GetMapping("/extcolor/model/{modelId}")
    public List<ExtColor> findByModel(@PathVariable int modelId) {
        List<com.concesionario.entity.Package> packages = packageRepository.findByModelId(modelId);
        List<ExtColor> extcolors = new ArrayList<>();
        for (com.concesionario.entity.Package pack : packages) {
            extcolors.addAll(extColorRepository.findByPackId(pack.getId()));
        }
        return extcolors;
    }
}
