package com.concesionario.controller;

import com.concesionario.entity.Brand;
import com.concesionario.entity.Engine;
import com.concesionario.entity.ExtColor;
import com.concesionario.entity.FullModelDto;
import com.concesionario.entity.IntColor;
import com.concesionario.entity.Model;
import com.concesionario.entity.Package;
import com.concesionario.entity.Tire;
import com.concesionario.repository.BrandRepository;
import com.concesionario.repository.EngineRepository;
import com.concesionario.repository.ExtColorRepository;
import com.concesionario.repository.IntColorRepository;
import com.concesionario.repository.ModelRepository;
import com.concesionario.repository.PackageRepository;
import com.concesionario.repository.TireRepository;
import com.concesionario.service.BrandService;
import com.concesionario.service.ModelService;
import com.concesionario.entity.ModelDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// Permite solicitudes de cualquier origen
// Indica que esta clase es un controlador REST
@CrossOrigin
@RestController
// Define la ruta base para todos los endpoints en este controlador
@RequestMapping("/api/v1")
public class ModelsController {

    private static final Logger logger = LogManager.getLogger(ModelsController.class);
    // Inyecta el repositorio de modelos
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private ExtColorRepository extColorRepository;

    @Autowired
    private IntColorRepository intColorRepository;

    @Autowired
    private TireRepository tireRepository;

    // Inyecta el servicio de modelos
    @Autowired
    private ModelService modelService;

    @Autowired
    private BrandService brandService;

    // Obtiene todos los modelos
    @GetMapping("/models")
    public List<Model> findAll() {
        // Devuelve todos los modelos
        return modelRepository.findAll();
    }

    // Obtiene un modelo por ID
    @GetMapping("/models/{id}")
    public ResponseEntity<Model> findById(@PathVariable int id) {
        // Busca el modelo con el ID especificado
        Optional<Model> optionalModel = modelRepository.findById(id);
        if (optionalModel.isPresent()) {
            // Si el modelo existe, devuelve el modelo con un código de estado 200
            return new ResponseEntity<>(optionalModel.get(), HttpStatus.OK);
        } else {
            // Si el modelo no existe, devuelve un código de estado 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Crea un nuevo modelo
    @PostMapping("/models/new")
    public ResponseEntity<Model> createModel(@RequestBody ModelDto modelDto) {
        logger.info("Creating model with name: {}", modelDto.getModelName());

        Brand brand = brandService.findBrandById(modelDto.getBrandId());
        if (brand == null) {
            logger.error("Brand not found with id: {}", modelDto.getBrandId());
            return ResponseEntity.badRequest().build();
        }

        Model model = new Model();
        model.setBrand(brand);
        model.setModel(modelDto.getModelName());
        model.setImage(modelDto.getImage());
        model.setPrice(modelDto.getPrice());
        model.setEmissions(modelDto.getEmissions());
        model.setFuel(modelDto.getFuel());

        try {
            Model savedModel = modelService.saveModel(model);
            logger.info("Model created successfully with id: {}", savedModel.getId());
            return ResponseEntity.ok(savedModel);
        } catch (Exception e) {
            logger.error("Failed to create model", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/models/full")
    public ResponseEntity<Model> createFullModel(@RequestBody FullModelDto fullModelDto) {
        // Busca la marca por nombre
        Brand brand = brandRepository.findByBrandName(fullModelDto.getBrandName());

        // Si la marca no existe, crea una nueva
        if (brand == null) {
            brand = new Brand();
            brand.setBrandName(fullModelDto.getBrandName());
            brand.setImage(fullModelDto.getBrandImage());
            brand = brandRepository.save(brand);
        }

        // Crea el nuevo modelo y asócialo a la marca
        Model model = new Model();
        model.setBrand(brand);
        model.setModel(fullModelDto.getModelName());
        model.setImage(fullModelDto.getModelImage());
        model.setPrice(fullModelDto.getModelPrice());
        model.setEmissions(fullModelDto.getModelEmission());
        model.setFuel(fullModelDto.getModelFuel());

        // Guarda el modelo en la base de datos
        Model savedModel = modelRepository.save(model);

        Package pack = new Package();
        pack.setModel(savedModel);
        pack.setName(fullModelDto.getPackageName());
        pack.setImage(fullModelDto.getPackageImage());
        pack.setPrice(fullModelDto.getPackagePrice());
        pack.setHeadlights(fullModelDto.getPackageHeadlights());
        pack.setBumper(fullModelDto.getPackageBumper());
        pack.setBodywork(fullModelDto.getPackageBodywork());
        pack.setSeats(fullModelDto.getPackageSeats());
        pack.setDescription(fullModelDto.getPackageDescription());

        // Guarda el paquete en la base de datos
        Package savedPackage = packageRepository.save(pack);

        Engine engine = new Engine();
        engine.setModel(savedModel);
        engine.setName(fullModelDto.getEngineName());
        engine.setPrice(fullModelDto.getEnginePrice());
        engine.setPower(fullModelDto.getEnginePower());
        engine.setFuel(fullModelDto.getEngineFuel());
        engine.setEmission(fullModelDto.getEngineEmission());
        engine.setConsumption(fullModelDto.getEngineConsumption());
        engine.setTransmission(fullModelDto.getEngineTransmission());
        engine.setDescription(fullModelDto.getEngineDescription());

        // Guarda el motor en la base de datos
        Engine savedEngine = engineRepository.save(engine);

        ExtColor extColor = new ExtColor();
        extColor.setPack(savedPackage);
        extColor.setColor(fullModelDto.getExteriorColorName());
        extColor.setPrice(fullModelDto.getExteriorColorPrice());
        extColor.setCirculo(fullModelDto.getExteriorColorCirculo());
        extColor.setImage(fullModelDto.getExteriorColorImage());

        // Guarda el color exterior en la base de datos
        ExtColor savedExtColor = extColorRepository.save(extColor);

        IntColor intColor = new IntColor();
        intColor.setPack(savedPackage);
        intColor.setColor(fullModelDto.getInteriorColorName());
        intColor.setPrice(fullModelDto.getInteriorColorPrice());
        intColor.setCirculo(fullModelDto.getInteriorColorCirculo());
        intColor.setImage(fullModelDto.getInteriorColorImage());

        // Guarda el color interior en la base de datos
        IntColor savedIntColor = intColorRepository.save(intColor);

        Tire tire = new Tire();
        tire.setPack(savedPackage);
        tire.setName(fullModelDto.getTireName());
        tire.setCirculo(fullModelDto.getTireCirculo());
        tire.setImage(fullModelDto.getTireImage());
        tire.setPrice(fullModelDto.getTirePrice());
        tire.setInches(fullModelDto.getTireInches());
        tire.setMaterial(fullModelDto.getTireMaterial());
        tire.setColor(fullModelDto.getTireColor());
        tire.setDescription(fullModelDto.getTireDescription());

        // Guarda las llantas en la base de datos
        Tire savedTire = tireRepository.save(tire);

        // Devuelve el modelo guardado
        return ResponseEntity.ok(savedModel);
    }

    // Actualiza un modelo
    @PutMapping("/models/{id}")
    public Model update(@RequestBody ModelDto newModel, @PathVariable int id) {
        return modelRepository.findById(id).map(existingModel -> {
            if (newModel.getModelName() != null) {
                existingModel.setModel(newModel.getModelName());
            }
            if (newModel.getImage() != null) {
                existingModel.setImage(newModel.getImage());
            }
            if (newModel.getPrice() != null) {
                existingModel.setPrice(newModel.getPrice());
            }
            if (newModel.getDescription() != null) {
                existingModel.setDescription(newModel.getDescription());
            }
            if (newModel.getFuel() != null) {
                existingModel.setFuel(newModel.getFuel());
            }
            if (newModel.getEmissions() != null) {
                existingModel.setEmissions(newModel.getEmissions());
            }
            if (newModel.getStatus() != null) {
                existingModel.setStatus(newModel.getStatus());
            }
            return modelRepository.save(existingModel);
        }).orElseThrow(() -> new RuntimeException("Model not found with id " + id));
    }

    // Elimina un modelo
    @DeleteMapping("/models/{id}")
    public void delete(@PathVariable int id) {
        // Elimina el modelo con el ID especificado
        modelRepository.deleteById(id);
    }

    // Actualiza el estado de un modelo
    @PutMapping("/models/{id}/status")
    public Model updateStatus(@PathVariable int id, @RequestBody String newStatus) {
        // Actualiza el estado del modelo con el ID especificado si existe, o lanza una
        // excepción si no existe
        return modelRepository.findById(id).map(m -> {
            m.setStatus(newStatus);
            return modelRepository.save(m);
        }).orElseThrow(() -> new RuntimeException("Model not found with id " + id));
    }

}