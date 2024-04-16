package com.example.autobase.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @Column(name = "cargo_quantity")
    private int cargoQuantity;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "cargo_type_id")
    private CargoType cargoType;
}
