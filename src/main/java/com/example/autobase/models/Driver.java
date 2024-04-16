package com.example.autobase.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "Driver")

public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "experience")
    private int experience;

    @Column(name = "status")
    private boolean status;

    @Column(name = "earnings")
    private BigDecimal earnings;

}

