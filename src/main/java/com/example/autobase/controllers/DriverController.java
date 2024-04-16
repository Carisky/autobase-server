package com.example.autobase.controllers;

import com.example.autobase.controllers.response.Response;
import com.example.autobase.models.Driver;
import com.example.autobase.services.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Drivers")
@CrossOrigin(origins = {"http://localhost:3000"})
public class DriverController {

    private final DriverServiceImpl driverService;

    @Autowired
    public DriverController(DriverServiceImpl driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/ADMIN/{driverId}")
    public ResponseEntity<Object> findById(@PathVariable Long driverId) {
        Optional<Driver> driver = driverService.findById(driverId);
        if (driver != null) {
            return ResponseEntity.ok().body(new Response<>(driver, HttpStatus.OK.value(), "Driver found"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null, HttpStatus.NOT_FOUND.value(), "Driver not found"));
        }
    }

    @GetMapping("/ADMIN/")
    public ResponseEntity<Object> findAll() {
        List<Driver> drivers = driverService.findAll();
        if (drivers != null && !drivers.isEmpty()) {
            return ResponseEntity.ok().body(new Response<>(drivers, HttpStatus.OK.value(), "Drivers found"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null, HttpStatus.NOT_FOUND.value(), "No drivers found"));
        }
    }
}
