package com.concesionario.repository;

import java.util.List;

import com.concesionario.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    List<Model> findByBrandId(int brandId);
    Model findByModel(String model);
    List<Model> findByModelStartingWith(String model);
}

