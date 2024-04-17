package com.example.autobase.services.impl;

import com.example.autobase.models.Driver;
import com.example.autobase.models.FinishedTrip;
import com.example.autobase.models.Trip;
import com.example.autobase.repositories.FinishedTripRepository;
import com.example.autobase.services.interfaces.FinishedTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinishedTripServiceImpl implements FinishedTripService {
    private final FinishedTripRepository tripRepository;

    @Autowired
    public FinishedTripServiceImpl(FinishedTripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<FinishedTrip> findAll() {
        return tripRepository.findAll();
    }
    @Override
    public Optional<FinishedTrip> findById(long id) {
        return tripRepository.findById(id);
    }
    @Override
    public FinishedTrip create(FinishedTrip trip) {
        return tripRepository.save(trip);
    }
    @Override
    public Optional<FinishedTrip> delete(long id) {
        Optional<FinishedTrip> deleted = tripRepository.findById(id);
        deleted.ifPresent(trip -> tripRepository.delete(trip));
        return deleted;
    }

    @Override
    public List<FinishedTrip> findByDriver(Optional<Driver> driver) {
        return tripRepository.findByDriver(driver);
    }
}
