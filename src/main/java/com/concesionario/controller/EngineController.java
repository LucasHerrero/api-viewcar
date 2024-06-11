package com.concesionario.controller;

import com.concesionario.entity.Engine;
import com.concesionario.repository.EngineRepository;
import com.concesionario.entity.EngineDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Permite solicitudes de cualquier origen
// Indica que esta clase es un controlador REST
@CrossOrigin
@RestController
// Define la ruta base para todos los endpoints en este controlador
@RequestMapping("/api/v1")
public class EngineController {
    @Autowired
    private EngineRepository engineRepository;
    
    // Obtiene todos los motores
    @GetMapping("/engines")
    public List<Engine> findAll() {
        //Devuelve todos los motores
        return engineRepository.findAll();
    }

    //Obtiene todos los motores de un modelo
    @GetMapping("/engines/model/{modelId}")
    public List<Engine> findByModelId(@PathVariable int modelId) {
        //Devuelve todos los motores de un modelo
        return engineRepository.findByModelId(modelId);
    }

    @PutMapping("/engines/{id}")
    public Engine updateEngine(@RequestBody EngineDto newEngine, @PathVariable int id) {
        return engineRepository.findById(id).map(existingEngine -> {
            if (newEngine.getPrice() != null) {
                existingEngine.setPrice(newEngine.getPrice());
            }
            if (newEngine.getPower() != null) {
                existingEngine.setPower(newEngine.getPower());
            }
            if (newEngine.getTransmission() != null) {
                existingEngine.setTransmission(newEngine.getTransmission());
            }
            if (newEngine.getConsumption() != null) {
                existingEngine.setConsumption(newEngine.getConsumption());
            }
            if (newEngine.getEmission() != null) {
                existingEngine.setEmission(newEngine.getEmission());
            }
            if (newEngine.getName() != null) {
                existingEngine.setName(newEngine.getName());
            }
            if (newEngine.getFuel() != null) {
                existingEngine.setFuel(newEngine.getFuel());
            }
            return engineRepository.save(existingEngine);
        }).orElseThrow(() -> new RuntimeException("Engine not found with id " + id));
    }

    @PostMapping("/engines/new")
    public Engine save(@RequestBody Engine engineObj) {
        // Guarda el nuevo modelo y lo devuelve
        return engineRepository.save(engineObj);
    }
}
