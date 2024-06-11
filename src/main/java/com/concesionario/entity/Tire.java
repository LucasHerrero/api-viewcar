package com.concesionario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tire")
public class Tire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tire_id")
    private int id;

    @Column(name = "Tire_name")
    private String name;

    @Column(name = "Tire_inches")
    private int inches;

    @Column(name = "Tire_material")
    private String material;

    @Column(name = "Tire_color")
    private String color;

    @Column(name = "Tire_image")
    private String image;

    @Column(name = "Tire_circulo")
    private String circulo;

    @Column(name = "Tire_price")
    private float price;

    @Column(name = "Tire_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_package")
    private Package pack;
}
