package com.example.autobase.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "FinishedTrips")
public class FinishedTrip {
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

    public FinishedTrip(Driver driver, Request request, Car car, BigDecimal intermediateCost) {
        this.driver = driver;
        this.car = car;
        this.request = request;
        this.status = false;
        this.intermediateCost = intermediateCost;
    }
}
