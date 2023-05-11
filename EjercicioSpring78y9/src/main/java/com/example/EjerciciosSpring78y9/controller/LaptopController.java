package com.example.EjerciciosSpring78y9.controller;

import com.example.EjerciciosSpring78y9.entities.LaptopEntity;
import com.example.EjerciciosSpring78y9.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);


    private LaptopRepository laptopRepository;


    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/laptops")
    @ApiOperation("Find all laptops")
    public List<LaptopEntity> findAll(){
        return laptopRepository.findAll();
    }

    @GetMapping("/laptops/{id}")
    @ApiOperation("find a laptop by it's ID")
    public ResponseEntity<LaptopEntity> findById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("Element does not exist");
            return ResponseEntity.notFound().build();
        }
        else{
            Optional<LaptopEntity> result = laptopRepository.findById(id);
            return ResponseEntity.ok(result.get());
        }
    }

    @PostMapping("/laptops")
    @ApiOperation("Create a new laptop")
    public LaptopEntity create(@RequestBody LaptopEntity laptop){
        return laptopRepository.save(laptop);
    }

    @PutMapping("/laptops")
    @ApiOperation("Update an existing laptop")
    public ResponseEntity<LaptopEntity> update(@RequestBody LaptopEntity laptop){
        if(laptop.getId() == null ){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Element does not exist");
            return ResponseEntity.notFound().build();

        }else{
            return ResponseEntity.ok(laptopRepository.save(laptop));
        }
    }

    @ApiIgnore
    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<LaptopEntity> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("Element does not exist");
            return ResponseEntity.notFound().build();
        }else{
            laptopRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
    @ApiIgnore
    @DeleteMapping("/laptops")
    public ResponseEntity<LaptopEntity> deleteAll(){
        log.info("REST Request fro delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
