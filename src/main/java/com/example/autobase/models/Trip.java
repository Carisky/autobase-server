package com.example.autobase.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @Column(name = "status")
    private boolean status;

    @Column(name = "intermediate_cost")
    private BigDecimal intermediateCost;

    public Trip(Driver driver, Request request, Car car, BigDecimal intermediateCost) {
        this.driver = driver;
        this.car = car;
        this.request = request;
        this.status = true;
        this.intermediateCost = intermediateCost;
    }
}
