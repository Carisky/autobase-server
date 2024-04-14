package com.example.autobase.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "carrying_capacity")
    private int carryingCapacity;

    @Column(name = "condition")
    private boolean condition;

}
