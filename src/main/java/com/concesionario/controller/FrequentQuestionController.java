package com.concesionario.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.concesionario.entity.FrequentQuestion;
import com.concesionario.repository.FrequentQuestionRepository;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FrequentQuestionController {
    
    @Autowired
    private FrequentQuestionRepository frequentQuestionRepository;
    
    @GetMapping("/frequentQuestions")
    public List<FrequentQuestion> getAll(){
        // Devuelve todas las preguntas frecuentes
        return frequentQuestionRepository.findAll();
    }}
    