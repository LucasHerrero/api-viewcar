package com.concesionario.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageDto {
    private String name;
    private String bodywork;
    private String seats;
    private float price;
    // Array de rutas de imágenes
    private List<String> image;
}
