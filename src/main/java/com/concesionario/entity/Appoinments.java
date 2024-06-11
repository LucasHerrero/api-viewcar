package com.concesionario.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "appoinments")
public class Appoinments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appoinment_id")
    private int id;

    @Column(name = "appoinment_date")
    private Date date;

    @Column(name = "appoinment_time")
    private Time time;

    @Column(name = "appoinment_creationtime")
    private LocalDateTime creationtime;

    @ManyToOne
    @JoinColumn(name = "appoinment_car")
    private Car car;
    

}
