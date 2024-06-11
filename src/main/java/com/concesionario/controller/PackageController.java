package com.concesionario.controller;

import com.concesionario.entity.Package;
import com.concesionario.entity.PackageDto;
import com.concesionario.repository.PackageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.Arrays;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Permite solicitudes de cualquier origen
// Indica que esta clase es un controlador REST
@CrossOrigin
@RestController
// Define la ruta base para todos los endpoints en este controlador
@RequestMapping("/api/v1")
public class PackageController {
    private static final Logger logger = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    private PackageRepository packageRepository;

    // Obtiene todos los paquetes
    @GetMapping("/packages")
    public List<Package> findAll() {
        // Devuelve todos los paquetes
        return packageRepository.findAll();
    }

    // Put
    @PutMapping("/packages/{packageId}")
    public Package update(@PathVariable int packageId, @RequestBody PackageDto packageObj) {
        // Convierte el array de rutas de imágenes en un string separado por comas
        String imageString = String.join(",", packageObj.getImage());

        logger.info("Image string: " + imageString);

        // Carga el paquete correspondiente
        Package packageToUpdate = packageRepository.findById(packageId)
                .orElseThrow();

        // Establece los nuevos valores
        packageToUpdate.setName(packageObj.getName());
        packageToUpdate.setBodywork(packageObj.getBodywork());
        packageToUpdate.setSeats(packageObj.getSeats());
        packageToUpdate.setPrice(packageObj.getPrice());
        packageToUpdate.setImage(imageString);

        // Guarda el paquete actualizado y lo devuelve
        return packageRepository.save(packageToUpdate);
    }

    // Obtiene los paquetes de un modelo
    @GetMapping("/packages/model/{modelId}")
    public List<Package> findByModelId(@PathVariable int modelId) {
        // Devuelve los paquetes de un modelo
        return packageRepository.findByModelId(modelId);
    }

    @PostMapping("/packages/new")
    public Package save(@RequestBody Package packageObj) {
        // Guarda el nuevo modelo y lo devuelve
        return packageRepository.save(packageObj);
    }

}
