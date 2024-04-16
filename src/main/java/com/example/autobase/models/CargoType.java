package com.example.autobase.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "cargotype")
public class CargoType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_type_id")
    private Long id;

    @Column(name = "require_xp")
    private int require_xp;

    @Column(name = "name")
    private String name;
}
