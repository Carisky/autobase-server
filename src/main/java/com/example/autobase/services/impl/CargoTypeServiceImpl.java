package com.example.autobase.services.impl;

import com.example.autobase.models.CargoType;
import com.example.autobase.repositories.CargoTypeRepository;
import com.example.autobase.services.interfaces.CargoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoTypeServiceImpl implements CargoTypeService {

    private final CargoTypeRepository cargoTypeRepository;

    @Autowired
    public CargoTypeServiceImpl(CargoTypeRepository cargoTypeRepository) {
        this.cargoTypeRepository = cargoTypeRepository;
    }

    @Override
    public List<CargoType> findAll() {
        return cargoTypeRepository.findAll();
    }

    @Override
    public Optional<CargoType> findById(Long id) {
        return cargoTypeRepository.findById(id);
    }

    @Override
    public CargoType create(CargoType cargoType) {
        return cargoTypeRepository.save(cargoType);
    }

    @Override
    public Optional<CargoType> delete(Long id) {
        Optional<CargoType> deleted = cargoTypeRepository.findById(id);
        deleted.ifPresent(cargoType -> cargoTypeRepository.delete(cargoType));
        return deleted;
    }
}
