package com.concesionario.repository;

import com.concesionario.entity.Brand;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
        Brand findByBrandName(String brandName);
        List<Brand> findByBrandNameStartingWith(String brandName);
}