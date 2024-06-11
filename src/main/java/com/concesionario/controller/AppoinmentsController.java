package com.concesionario.controller;

import com.concesionario.entity.Appoinments;
import com.concesionario.entity.Car;
import com.concesionario.repository.AppoinmentsRepository;
import com.concesionario.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Permite solicitudes de cualquier origen
// Indica que esta clase es un controlador REST
@CrossOrigin
@RestController
// Define la ruta base para todos los endpoints en este controlador
@RequestMapping("/api/v1")

public class AppoinmentsController {

    @Autowired
    private AppoinmentsRepository appoinmentsRepository;
    @Autowired
    private CarRepository carRepository;

    // Obtiene todas las citas
    @GetMapping("/appoinments")
    public List<Appoinments> findAll() {
        // Devuelve todas las citas
        return appoinmentsRepository.findAll();
    }

    @PostMapping("/appoinments/new")
    public ResponseEntity<?> save(@RequestBody Appoinments appoinmentsObj) {
        // Carga el objeto Car correspondiente
        Car car = carRepository.findById(appoinmentsObj.getCar().getId())
                .orElseThrow();
    
        // Comprueba si ya existe una cita para la misma fecha y hora de la cita
        Appoinments existingAppoinment = appoinmentsRepository.findByDateAndTime(appoinmentsObj.getDate(), appoinmentsObj.getTime());
        if (existingAppoinment != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe una cita para esta fecha y hora");
        }    

        // Establece el objeto Car en Appoinments
        appoinmentsObj.setCar(car);

        // Establece la fecha y hora de creación a la hora actual
        appoinmentsObj.setCreationtime(LocalDateTime.now(ZoneId.of("Europe/Madrid")));

        // Guarda la nueva cita y la devuelve
        Appoinments savedAppoinment = appoinmentsRepository.save(appoinmentsObj);
        return new ResponseEntity<>(savedAppoinment, HttpStatus.CREATED);
    }

    @GetMapping("/appoinments/available")
    public ResponseEntity<List<String>> getAvailableAppointments(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        // Define el rango de tiempo de trabajo
        LocalTime startTime = LocalTime.of(12, 0);
        LocalTime endTime = LocalTime.of(16, 0);

        // Obtiene todas las citas para la fecha dada
        List<Appoinments> appointments = appoinmentsRepository.findByDate(date);

        // Convierte las horas de las citas a LocalTime
        List<LocalTime> appointmentTimes = appointments.stream()
                .map(a -> a.getTime().toLocalTime())
                .collect(Collectors.toList());

        // Calcula los intervalos de tiempo disponibles
        List<String> availableTimes = new ArrayList<>();
        for (LocalTime time = startTime; time.isBefore(endTime); time = time.plusHours(1)) {
            if (!appointmentTimes.contains(time)) {
                availableTimes.add(time + " - " + time.plusHours(1));
            }
        }

        // Devuelve los intervalos de tiempo disponibles
        return new ResponseEntity<>(availableTimes, HttpStatus.OK);
    }

    @GetMapping("/appoinments/full-days")
    public ResponseEntity<List<LocalDate>> getFullDays() {
        // Define los turnos de trabajo
        List<LocalTime> shifts = Arrays.asList(
                LocalTime.of(12, 0),
                LocalTime.of(13, 0),
                LocalTime.of(14, 0),
                LocalTime.of(15, 0));

        // Obtiene todas las citas
        List<Appoinments> appointments = appoinmentsRepository.findAll();

        // Agrupa las citas por fecha
        Map<LocalDate, List<Appoinments>> appointmentsByDate = appointments.stream()
                .collect(Collectors.groupingBy(a -> a.getDate().toLocalDate()));

        // Calcula los días completamente reservados
        List<LocalDate> fullDays = new ArrayList<>();
        for (Map.Entry<LocalDate, List<Appoinments>> entry : appointmentsByDate.entrySet()) {
            List<LocalTime> appointmentTimes = entry.getValue().stream()
                    .map(a -> a.getTime().toLocalTime())
                    .collect(Collectors.toList());

            if (shifts.stream().allMatch(appointmentTimes::contains)) {
                fullDays.add(entry.getKey());
            }
        }

        // Devuelve los días completamente reservados
        return new ResponseEntity<>(fullDays, HttpStatus.OK);
    }

}
