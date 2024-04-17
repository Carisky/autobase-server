package com.example.autobase.services.interfaces;


import com.example.autobase.models.Driver;
import com.example.autobase.models.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {
    List<Trip> findAll();
    Optional<Trip> delete(long id);

    Optional<Trip> findById(long id);

    Trip create(Trip trip);
    List<Trip> findByDriver(Optional<Driver> driver);
}
