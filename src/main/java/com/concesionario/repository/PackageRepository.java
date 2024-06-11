package com.concesionario.repository;

import com.concesionario.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package, Integer> {
    // Obtiene los paquetes de un modelo
    List<Package> findByModelId(int modelId);
}
