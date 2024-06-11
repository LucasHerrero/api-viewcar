package com.concesionario.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "car_engine")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_engine_id")
    private int id;

    @Column(name = "Car_engine_name")
    private String name;

    @Column(name = "Car_engine_fuel")
    private String fuel;

    @Column(name = "Car_engine_power")
    private String power;

    @Column(name = "Car_engine_emission")
    private String emission;

    @Column(name = "Car_engine_consumption")
    private String consumption;

    @Column(name = "Car_engine_transmission")
    private String transmission;

    @Column(name = "Car_engine_price")
    private float price;

    @Column(name = "Car_engine_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_model")
    private Model model;
}
