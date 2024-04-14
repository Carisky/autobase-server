package com.example.autobase.services.interfaces;

import com.example.autobase.models.CargoType;

import java.util.List;
import java.util.Optional;

public interface CargoTypeService {
    List<CargoType> findAll();
    Optional<CargoType> findById(Long id);
    CargoType create(CargoType cargoType);
    Optional<CargoType> delete(Long id);
}
