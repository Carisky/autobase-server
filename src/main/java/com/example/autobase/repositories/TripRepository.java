package com.example.autobase.repositories;

import com.example.autobase.models.Driver;
import com.example.autobase.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findByDriver(Optional<Driver> driver);
}
