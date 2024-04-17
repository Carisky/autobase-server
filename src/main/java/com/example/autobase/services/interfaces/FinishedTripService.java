package com.example.autobase.services.interfaces;


import com.example.autobase.models.Driver;
import com.example.autobase.models.FinishedTrip;

import java.util.List;
import java.util.Optional;

public interface FinishedTripService {
    List<FinishedTrip> findAll();
    Optional<FinishedTrip> delete(long id);

    Optional<FinishedTrip> findById(long id);

    FinishedTrip create(FinishedTrip trip);
    List<FinishedTrip> findByDriver(Optional<Driver> driver);
}
