// SearchService.java
package com.concesionario.service;

import com.concesionario.entity.Brand;
import com.concesionario.entity.Model;
import com.concesionario.repository.BrandRepository;
import com.concesionario.repository.ModelRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    @Autowired
    public SearchService(BrandRepository brandRepository, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    public Object searchByName(String name) {
        List<Brand> brands = brandRepository.findByBrandNameStartingWith(name);
        if (!brands.isEmpty()) {
            Brand brand = brands.get(0);
            return modelRepository.findByBrandId(brand.getId());
        }
        List<Model> models = modelRepository.findByModelStartingWith(name);
        if (!models.isEmpty()) {
            return models;
        }

        return null;
    }
}
    // public Object searchByName(String name) {
    //     Brand brand = brandRepository.findByBrandName(name);
    //     if (brand != null) {
    //         return modelRepository.findByBrandId(brand.getId());
    //     }

    //     Model model = modelRepository.findByModel(name);
    //             if (model != null) {
    //         return model;
    //     }

    //     return null;
    // }
