package com.example.autobase.repositories;

import com.example.autobase.models.Driver;
import com.example.autobase.models.FinishedTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FinishedTripRepository extends JpaRepository<FinishedTrip,Long> {
    List<FinishedTrip> findByDriver(Optional<Driver> driver);
}

