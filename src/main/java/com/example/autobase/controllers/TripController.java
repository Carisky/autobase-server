package com.example.autobase.controllers;

import com.example.autobase.controllers.response.Response;
import com.example.autobase.models.*;
import com.example.autobase.services.impl.CarServiceImpl;
import com.example.autobase.services.impl.DriverServiceImpl;
import com.example.autobase.services.impl.FinishedTripServiceImpl;
import com.example.autobase.services.impl.TripServiceImpl;
import com.example.autobase.services.interfaces.RequestService;
import com.example.autobase.utils.Payload;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.util.RequestPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Trips")
@CrossOrigin(origins = {"http://localhost:3000"})
public class TripController {

    private final TripServiceImpl tripService;
    private final FinishedTripServiceImpl finishedTripService;
    private final CarServiceImpl carService;
    private final DriverServiceImpl driverService;
    private final RequestService requestService;

    public TripController(TripServiceImpl tripService, FinishedTripServiceImpl finishedTripService, CarServiceImpl carService, DriverServiceImpl driverService, RequestService requestService) {
        this.tripService = tripService;
        this.finishedTripService = finishedTripService;
        this.carService = carService;
        this.driverService = driverService;
        this.requestService = requestService;
    }

    @PostMapping("/ADMIN/")
    public ResponseEntity<Object> create(@RequestBody Payload payload) {

        Driver driver = payload.getDriver();
        Request request = payload.getRequest();
        Car car = payload.getCar();

        BigDecimal distance = BigDecimal.valueOf(request.getDestination().getDistance());
        BigDecimal intermediateCost = distance.multiply(BigDecimal.valueOf(2.749));

        Trip created = tripService.create(new Trip(driver, request, car,  intermediateCost));

        if (created != null) {
            driver.setStatus(false);
            request.setStatus(false);
            car.setStatus(false);

            driverService.create(driver);
            requestService.create(request);
            carService.create(car);

            return ResponseEntity.ok().body(new Response<>(created, HttpStatus.OK.value(), "Trip created"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error during Trip creating"));
        }
    }

    @GetMapping("/DRIVER/{name}")
    public ResponseEntity<Object> getTripsByDriverName(@PathVariable String name) {
        Optional<Driver> driver = driverService.findByName(name);
        if (driver == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Response<>(null, HttpStatus.NOT_FOUND.value(), "Driver not found"));
        }

        List<Trip> trips = tripService.findByDriver(driver);
        return ResponseEntity.ok().body(new Response<>(trips, HttpStatus.OK.value(), "Trips found for driver: " + name));
    }

    @PostMapping("/DRIVER/{name}")
    public ResponseEntity<Object> finishTrip(@PathVariable String name, @RequestBody Payload payload) {
        Optional<Driver> driverOptional = driverService.findByName(name);
        if (!driverOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Response<>(null, HttpStatus.NOT_FOUND.value(), "Driver not found"));
        }

        Driver driver = driverOptional.get();

        Trip trip = payload.getTrip();

        trip.setStatus(false);
        tripService.create(trip);

        driver.setStatus(true);
        driver.setEarnings(driver.getEarnings().add(trip.getIntermediateCost()));
        driverService.create(driver);

        Request request = trip.getRequest();
        request.setStatus(false);
        requestService.create(request);

        tripService.delete(trip.getId());

        FinishedTrip finishedTrip = new FinishedTrip(trip.getDriver(), trip.getRequest(), trip.getCar(),trip.getIntermediateCost());
        finishedTripService.create(finishedTrip);

        return ResponseEntity.ok().body(new Response<>(trip, HttpStatus.OK.value(), "Trip finished successfully"));
    }



}
