package com.concesionario.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_id")
    private int id;

    @Column(name = "car_price")
    private Float price;

    @Column(name = "creation_date")
    private LocalDateTime creationtime;

    @ManyToOne
    @JoinColumn(name = "Package_id")
    private Package pack;

    @ManyToOne
    @JoinColumn(name = "Brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "Model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "car_engine_id")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "Ext_Color_id")
    private ExtColor extColor;

    @ManyToOne
    @JoinColumn(name = "Int_Color_id")
    private IntColor intColor;

    @ManyToOne
    @JoinColumn(name = "Tire_id")
    private Tire tire;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

   
}
