package com.concesionario.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.concesionario.entity.FrequentQuestion;

public interface FrequentQuestionRepository extends JpaRepository<FrequentQuestion, Integer> {
}