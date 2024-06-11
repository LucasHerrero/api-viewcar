package com.concesionario.service;

import com.concesionario.entity.Brand;
import com.concesionario.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand findBrandById(int id) {
        return brandRepository.findById(id).orElse(null);
    }
}