package com.example.autobase.controllers;



import com.example.autobase.controllers.response.Response;
import com.example.autobase.models.CargoType;
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
@RequestMapping("/CargoTypes")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CargoTypeController {
    private final CargoTypeServiceImpl cargoTypeService;

    @Autowired
    public CargoTypeController(CargoTypeServiceImpl cargoTypeService){
        this.cargoTypeService = cargoTypeService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        List<CargoType> cargoTypes = cargoTypeService.findAll();
        if (cargoTypes != null && !cargoTypes.isEmpty()) {
            return ResponseEntity.ok().body(new Response<>(cargoTypes, HttpStatus.OK.value(), "Cargo Types found"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null, HttpStatus.NOT_FOUND.value(), "No Cargo Types found"));
        }
    }

}
