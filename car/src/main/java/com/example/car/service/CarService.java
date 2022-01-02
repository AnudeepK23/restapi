package com.example.car.service;


import com.example.car.model.Car;
import com.example.car.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {


    @Autowired
    CarRepo repo;

    public void store(Car CaM) {
        repo.save(CaM);
    }

    public List<Car> getCars() {

        List<Car> list=repo.findAll();

        return list;
    }

    public Car getCar(int id) {

        Car CaM=repo.findById(id).orElse(new Car());

        return CaM;
    }

    public void deleteCaM(int id) {
        repo.deleteById(id);
    }

}
