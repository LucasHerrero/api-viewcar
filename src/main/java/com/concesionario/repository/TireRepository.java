package com.concesionario.repository;

import com.concesionario.entity.Tire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TireRepository extends JpaRepository<Tire, Integer> {

    List<Tire> findByPackId(int packId);
}