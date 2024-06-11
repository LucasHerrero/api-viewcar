package com.concesionario.repository;

import com.concesionario.entity.Appoinments;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoinmentsRepository extends JpaRepository<Appoinments, Integer> {
    List<Appoinments> findByDate(LocalDate date);
    Appoinments findByDateAndTime(Date date, Time time);
}