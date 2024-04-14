package com.example.autobase.services.interfaces;

import com.example.autobase.models.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> findAll();
    Optional<Driver> findById(Long id);
    Driver create(Driver driver);
    Optional<Driver> delete(Long id);
}
