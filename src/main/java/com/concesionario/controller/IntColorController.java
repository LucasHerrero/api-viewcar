package com.concesionario.controller;

import com.concesionario.entity.IntColor;
import com.concesionario.entity.IntColorDto;
import com.concesionario.repository.IntColorRepository;
import com.concesionario.repository.PackageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")

public class IntColorController {

    @Autowired
    private PackageRepository packageRepository;


    @Autowired
    private IntColorRepository intColorRepository;

    @GetMapping("/intcolors")
    public List<IntColor> findAll() {
        return intColorRepository.findAll();
    }

    @GetMapping("/intcolors/pack/{packId}")
    public List<IntColor> findByPack(@PathVariable int packId) {
        return intColorRepository.findByPackId(packId);
    }

    @PostMapping("/intcolors/new")
    public IntColor save(@RequestBody IntColor IntColorObj) {
        // Guarda el nuevo modelo y lo devuelve
        return intColorRepository.save(IntColorObj);
    }


    @GetMapping("/intcolor/model/{modelId}")
    public List<IntColor> findByModel(@PathVariable int modelId) {
        List<com.concesionario.entity.Package> packages = packageRepository.findByModelId(modelId);
        List<IntColor> intcolors = new ArrayList<>();
        for (com.concesionario.entity.Package pack : packages) {
            intcolors.addAll(intColorRepository.findByPackId(pack.getId()));
        }
        return intcolors;
    }

    // Actualiza la tapiceria (intcolor)
    @PutMapping("/intcolors/{id}")
    public IntColor update(@RequestBody IntColorDto newIntColor, @PathVariable int id) {
        return intColorRepository.findById(id).map((IntColor existingIntColor) -> {
            if (newIntColor.getColor() != null) {
                existingIntColor.setColor(newIntColor.getColor());
            }
            if (newIntColor.getCirculo() != null) {
                existingIntColor.setCirculo(newIntColor.getCirculo());
            }
            if (newIntColor.getImage() != null) {
                existingIntColor.setImage(newIntColor.getImage());
            }
            if (newIntColor.getPrice() != null) {
                existingIntColor.setPrice(newIntColor.getPrice());
            }
            
            return intColorRepository.save(existingIntColor);// Add the return statement

        }).orElseThrow(() -> new RuntimeException("IntColor not found with id " + id));
    }
}
