package com.concesionario.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullModelDto {
    // Campos para la marca
    private String brandName;
    private String brandImage;

    // Campos para el modelo
    private String modelName;
    private String modelImage;
    private String modelPrice;
    private String modelEmission;
    private String modelFuel;

    // Campos para el paquete
    private String packageName;
    private String packageImage;
    private float packagePrice;
    private String packageHeadlights;
    private String packageBumper;
    private String packageBodywork;
    private String packageSeats;
    private String packageDescription;

    // Campos para el motor
    private String engineName;
    private String engineImage;
    private float enginePrice;
    private String enginePower;
    private String engineFuel;
    private String engineEmission;
    private String engineConsumption;
    private String engineTransmission;
    private String engineDescription;

    // Campos para el color exterior
    private String exteriorColorName;
    private float exteriorColorPrice;
    private String exteriorColorCirculo;
    private String exteriorColorImage;

    // Campos para el color interior
    private String interiorColorName;
    private float interiorColorPrice;
    private String interiorColorCirculo;
    private String interiorColorImage;

    // Campos para las llantas
    private String tireName;
    private String tireCirculo;
    private String tireImage;
    private float tirePrice;
    private int tireInches;
    private String tireMaterial;
    private String tireColor;
    private String tireDescription;
}