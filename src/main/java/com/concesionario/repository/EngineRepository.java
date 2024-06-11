package com.concesionario.repository;

import com.concesionario.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngineRepository extends JpaRepository<Engine, Integer> {
    // Obtiene los motores de un modelo
    List<Engine> findByModelId(int modelId);
}
