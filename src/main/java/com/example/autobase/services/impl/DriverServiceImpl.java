package com.example.autobase.services.impl;

import com.example.autobase.models.Driver;
import com.example.autobase.repositories.DriverRepository;
import com.example.autobase.services.interfaces.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> findById(Long id) {
        return driverRepository.findById(id);
    }

    @Override
    public Driver create(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Driver> delete(Long id) {
        Optional<Driver> deleted = driverRepository.findById(id);
        deleted.ifPresent(driver -> driverRepository.delete(driver));
        return deleted;
    }

    @Override
    public Optional<Driver> findByName(String name) {
        return driverRepository.findByAppUser_Username(name);
    }
}
