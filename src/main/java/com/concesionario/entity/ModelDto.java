package com.concesionario.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelDto {
    private int brandId;
    private String modelName;
    private String image;
    private String price;
    private String description;
    private String fuel;
    private String emissions;
    private String status;
    
}