package com.concesionario.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Model_id")
    private int id;

    @Column(name = "Model_name")
    private String model;

    @Column(name = "Model_image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "Brand_Model_Fk")
    private Brand brand;

    @Column(name = "Model_price")
    private String price;
    
    @Column(name = "Date_Of_Discharge")
    private Date Date_Of_Discharge;

    @Column(name = "Date_Modified")
    private Date Date_Modified;

    @Column(name = "Date_of_Termination")
    private Date Date_of_Termination;

    @Column(name = "User_Changes")
    private String User_Changes;

    @Column(name = "Model_description")
    private String description;

    @Column(name = "Model_fuelConsumption")
    private String fuel;

    @Column(name = "Model_emissions")
    private String emissions;

    @Column(name  = "Model_Status")
    private String status = "Inactive";

 
}
