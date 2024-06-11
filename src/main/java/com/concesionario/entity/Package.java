package com.concesionario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Package_id")
    private int id;

    @Column(name = "Package_name")
    private String name;

    @Column(name = "Package_bumper")
    private String bumper;

    @Column(name = "Package_headlights")
    private String headlights;

    @Column(name = "Package_bodywork")
    private String bodywork;

    @Column(name = "Package_seats")
    private String seats;

    @Column(name = "Package_price")
    private float price;

    @Column(name = "Package_description")
    private String description;

    @JsonIgnore
    @Column(name = "Package_image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "fk_model")
    private Model model;

    @Transient
    public List<String> getImageList() {
        return this.image == null ? new ArrayList<>() : Arrays.asList(this.image.split(","));
    }
}
