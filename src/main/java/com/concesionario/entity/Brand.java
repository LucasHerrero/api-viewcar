package com.concesionario.entity;

import java.sql.Date;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

/*
 *
 * Clase Brand
 *
 * Define la tabla "brand" en la base de datos
 * Define los atributos de la tabla y los getters y setters para acceder a ellos
 *
 */

@Entity
@Getter
@Setter
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Brand_id")
    private int id;

    @Column(name = "Brand_brand")
    private String brandName;

    @Column(name = "Brand_image")
    private String image;

    @Column(name = "Date_Of_Discharge")
    private Date Date_Of_Discharge;

    @Column(name = "Date_Modified")
    private Date Date_Modified;

    @Column(name = "Date_of_Termination")
    private Date Date_of_Termination;

    @Column(name = "User_Changes")
    private String User_Changes;
}