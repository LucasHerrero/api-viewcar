package com.concesionario.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtColorDto {
    private String color;
    private List<String> image;
    private Float price;
    private String circulo;
    
}
