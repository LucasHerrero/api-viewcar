package com.concesionario.repository;
import com.concesionario.entity.IntColor;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IntColorRepository extends JpaRepository<IntColor, Integer>{
    List<IntColor> findByPackId(int packid);    
}
