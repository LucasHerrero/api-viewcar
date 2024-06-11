package com.concesionario.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "exterior_color")
public class ExtColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ext_color_id")
    private int id;

    @Column(name= "Ext_color_color")
    private String color;

    @Column(name = "Ext_color_image")
    private String image;

    @Column(name = "Ext_color_price")
    private Float price;

    @Column(name = "Ext_color_color_img")
    private String circulo;

    @ManyToOne
    @JoinColumn(name = "Fk_package")
    private Package pack;

 @Transient
public List<String> getImageList() {
    return this.image == null ? new ArrayList<>() : Arrays.asList(this.image.split(","));
}
}
