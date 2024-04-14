package com.example.autobase.services.impl;

import com.example.autobase.models.Trip;
import com.example.autobase.repositories.TripRepository;
import com.example.autobase.services.interfaces.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }
    @Override
    public Optional<Trip> findById(long id) {
        return tripRepository.findById(id);
    }
    @Override
    public Trip create(Trip trip) {
        return tripRepository.save(trip);
    }
    @Override
    public Optional<Trip> delete(long id) {
        Optional<Trip> deleted = tripRepository.findById(id);
        deleted.ifPresent(trip -> tripRepository.delete(trip));
        return deleted;
    }
}
