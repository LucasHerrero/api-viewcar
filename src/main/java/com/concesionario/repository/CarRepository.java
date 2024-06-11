package com.concesionario.repository;

import com.concesionario.entity.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    java.util.List<Car> findByUserId(int id);
    
@Query("SELECT c FROM Car c WHERE c.user.id = :userId AND c.brand.id = :brandId AND c.model.id = :modelId AND c.engine.id = :engineId AND c.extColor.id = :extColorId AND c.intColor.id = :intColorId AND c.tire.id = :tireId AND c.price = :price")
Car findExistingCar(@Param("userId") int userId, @Param("brandId") int brandId, @Param("modelId") int modelId, @Param("engineId") int engineId, @Param("extColorId") int extColorId, @Param("intColorId") int intColorId, @Param("tireId") int tireId, @Param("price") Float price);


}