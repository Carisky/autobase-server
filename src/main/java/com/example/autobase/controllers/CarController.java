package com.example.autobase.controllers;

import com.example.autobase.controllers.response.Response;
import com.example.autobase.models.Car;
import com.example.autobase.models.CargoType;
import com.example.autobase.services.impl.CarServiceImpl;
import com.example.autobase.services.impl.CargoTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Cars")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CarController {


    private final CarServiceImpl carService;
    @Autowired
    public CarController(CarServiceImpl carService){
        this.carService = carService;
    }

    @GetMapping("/ADMIN/")
    public ResponseEntity<Object> findAll() {
        List<Car> cars = carService.findAll();
        if (cars != null && !cars.isEmpty()) {
            return ResponseEntity.ok().body(new Response<>(cars, HttpStatus.OK.value(), "Cars Types found"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null, HttpStatus.NOT_FOUND.value(), "No Cars found"));
        }
    }

}
