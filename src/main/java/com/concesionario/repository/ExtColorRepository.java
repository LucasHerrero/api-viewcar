package com.concesionario.repository;
import com.concesionario.entity.ExtColor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExtColorRepository extends JpaRepository<ExtColor, Integer>{
    // Obtiene todos los colores exteriores
    List<ExtColor> findByPackId(int packId);
}



