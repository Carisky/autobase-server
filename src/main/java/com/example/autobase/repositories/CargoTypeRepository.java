package com.example.autobase.repositories;

import com.example.autobase.models.CargoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoTypeRepository extends JpaRepository<CargoType,Long> {
}
