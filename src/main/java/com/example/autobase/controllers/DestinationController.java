package com.example.autobase.controllers;

import com.example.autobase.controllers.response.Response;
import com.example.autobase.models.Destination;
import com.example.autobase.services.impl.DestinationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Destinations")
@CrossOrigin(origins = {"http://localhost:3000"})
public class DestinationController {
    private final DestinationServiceImpl destinationService;

    @Autowired
    DestinationController(DestinationServiceImpl destinationService){this.destinationService = destinationService;}

    @GetMapping("/USER/")
    public ResponseEntity<Object> findAll() {
        List<Destination> destinations = destinationService.findAll();
        if (destinations != null && !destinations.isEmpty()) {
            return ResponseEntity.ok().body(new Response<>(destinations, HttpStatus.OK.value(), "Destinations found"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null, HttpStatus.NOT_FOUND.value(), "No Destinations found"));
        }
    }
}
