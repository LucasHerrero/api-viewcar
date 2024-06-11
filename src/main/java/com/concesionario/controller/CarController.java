package com.concesionario.controller;

import com.concesionario.entity.Car;
import com.concesionario.entity.Model;
import com.concesionario.repository.CarRepository;
import com.concesionario.repository.ModelRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Permite solicitudes de cualquier origen
@CrossOrigin

// Indica que esta clase es un controlador REST
@RestController
// Define la ruta base para todos los endpoints en este controlador
@RequestMapping("/api/v1")
public class CarController {

  private static final Logger logger = LoggerFactory.getLogger(CarController.class);

  @Autowired
  private CarRepository carRepository;

  // Inyectar el repositorio de modelos para buscar modelos por id de marca.
  @Autowired
  private ModelRepository modelRepository;

  // Crea un nuevo coche.
  @PostMapping("/car/new")
  public ResponseEntity<Car> save(@RequestBody Car car) {

  logger.info("Iniciando el guardado de un nuevo coche");
  logger.info("ID del modelo: " + car.getModel().getId());

  // Busca el modelo por id en la base de datos.
  Model model = modelRepository.findById(car.getModel().getId()).orElse(null);

  // Comprueba si el model existe y si su estado es "active".
  if ( model == null || !model.getStatus().equals("Active")) {

  logger.warn("El estado no es 'Active'");

  // Si el modelo no existe o su estado no es "active", devuelve un error
  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  // Establece la fecha de creación a la hora actual
  car.setCreationtime(LocalDateTime.now(ZoneId.of("Europe/Madrid")));

  // Guarda el nuevo coche y lo devuelve
  Car savedCar = carRepository.save(car);

  logger.info("Coche guardado con éxito");

  return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
  }

  
  // Obtiene el coche por id.
  @GetMapping("/car/{id}")
  public ResponseEntity<Car> findById(@PathVariable int id) {
    // Busca el coche por id
    Car car = carRepository.findById(id).orElse(null);
    if (car == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(car, HttpStatus.OK);
  }

  // Obtiene el coche por id del usuario.
  @GetMapping("/car/user/{id}")
  public ResponseEntity<List<Car>> findByUserId(@PathVariable int id) {
    // Busca los coches por id del usuario
    List<Car> cars = carRepository.findByUserId(id);
    if (cars.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(cars, HttpStatus.OK);
  }

  // Lista todos los coches.
  @GetMapping("/car")
  public ResponseEntity<List<Car>> findAll() {
    // Obtiene todos los coches
    List<Car> cars = carRepository.findAll();

    // Devuelve la lista de coches
    return new ResponseEntity<>(cars, HttpStatus.OK);
  }
}