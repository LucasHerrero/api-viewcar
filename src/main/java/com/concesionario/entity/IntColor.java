package com.concesionario.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter

@Table(name = "interior_color")
public class IntColor {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Int_color_id")
    private int id;

    @Column(name= "Int_color_color")
    private String color;

    @Column(name = "Int_color_image")
    private String image;

    @Column(name = "Int_color_price")
    private Float price;

    @Column(name = "Int_color_color_image")
    private String circulo;

    @ManyToOne
    @JoinColumn(name = "fk_package")
    private Package pack;


}
