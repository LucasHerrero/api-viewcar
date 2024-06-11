// ModelService.java
package com.concesionario.service;

import com.concesionario.entity.Brand;
import com.concesionario.entity.Model;
import com.concesionario.repository.BrandRepository;
import com.concesionario.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AddModelService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;

    public void addModel(Map<String, String> inputData) {
        Brand brand = new Brand();
        brand.setBrandName(inputData.get("inputValue1"));
        brandRepository.save(brand);

        Model model = new Model();
        model.setModel(inputData.get("inputValue2"));
        modelRepository.save(model);
    }
}