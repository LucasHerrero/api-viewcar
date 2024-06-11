package com.concesionario.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EngineDto {
    private String name;
    private String fuel;
    private String power;
    private String emission;
    private String consumption;
    private String transmission;
    private Float price;
    private String description;
    }