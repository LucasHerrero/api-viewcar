package com.concesionario.service;

import com.concesionario.entity.Model;
import com.concesionario.repository.ModelRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

 
}