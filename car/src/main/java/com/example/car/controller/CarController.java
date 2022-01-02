package com.example.car.controller;

import com.example.car.model.Car;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    CarService service;

    @PostMapping( value = "/saveCaM" ,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_XML_VALUE )
    public ResponseEntity<Car> print(@RequestBody Car CaM)
    {
        service.store(CaM);
        return new ResponseEntity<Car>(CaM, HttpStatus.CREATED);
    }

    @GetMapping( value = "/Cars" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Car>> getCaMs()
    {
        List<Car> list=service.getCars();
        return new ResponseEntity<List<Car>>(list,HttpStatus.CREATED);
    }

    @GetMapping( value = "/Car/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Car> getCaM(@PathVariable("id") int id)
    {
        Car CaM=service.getCar(id);
        return new ResponseEntity<Car>(CaM,HttpStatus.CREATED);
    }

    @PutMapping( value = "/Car" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> updateStd(@RequestBody Car CaM)
    {
        service.store(CaM);
        return new ResponseEntity<Car>(CaM,HttpStatus.CREATED);
    }

    @DeleteMapping( value = "/delete/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> deleteCaM(@PathVariable("id") int id)
    {
        service.deleteCaM(id);
        return new ResponseEntity<String>("recored deleted",HttpStatus.CREATED);
    }
}
