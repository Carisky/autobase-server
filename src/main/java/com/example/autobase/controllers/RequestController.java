package com.example.autobase.controllers;


import com.example.autobase.controllers.response.Response;
import com.example.autobase.models.CargoType;
import com.example.autobase.models.Destination;
import com.example.autobase.models.Request;
import com.example.autobase.services.impl.CargoTypeServiceImpl;
import com.example.autobase.services.impl.DestinationServiceImpl;
import com.example.autobase.services.impl.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Requests")
@CrossOrigin(origins = {"http://localhost:3000"})
public class RequestController {
    private final RequestServiceImpl requestService;
    private final DestinationServiceImpl destinationService;
    private final CargoTypeServiceImpl cargoTypeService;



    @Autowired
    public RequestController(RequestServiceImpl requestService, DestinationServiceImpl destinationService, CargoTypeServiceImpl cargoTypeService) {
        this.requestService = requestService;
        this.destinationService = destinationService;
        this.cargoTypeService = cargoTypeService;
    }

    @GetMapping("/ADMIN/")
    public ResponseEntity<Object> findAll() {
        List<Request> requests = requestService.findAll();
        if (requests != null && !requests.isEmpty()) {
            return ResponseEntity.ok().body(new Response<>(requests, HttpStatus.OK.value(), "Requests found"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null, HttpStatus.NOT_FOUND.value(), "No Requests found"));
        }
    }

    @PostMapping("/USER/")
    public ResponseEntity<Object> create(@RequestBody Map<String, String> payload) {
        long destinationId = Long.parseLong(payload.get("destination_id"));
        long cargoTypeId = Long.parseLong(payload.get("cargo_type"));
        int cargoQuantity = Integer.parseInt(payload.get("cargo_quantity"));

        Destination destination = destinationService.findById(destinationId).orElse(null);
        CargoType cargoType = cargoTypeService.findById(cargoTypeId).orElse(null);

        Request request = new Request();
        request.setDestination(destination);
        request.setCargoType(cargoType);
        request.setCargoQuantity(cargoQuantity);

        Request created = requestService.create(request);

        if (created != null) {
            return ResponseEntity.ok().body(new Response<>(created, HttpStatus.OK.value(), "Request created"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error during Request creating"));
        }
    }
}
