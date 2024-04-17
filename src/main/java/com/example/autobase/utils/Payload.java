package com.example.autobase.utils;

import com.example.autobase.models.Car;
import com.example.autobase.models.Driver;
import com.example.autobase.models.Request;
import com.example.autobase.models.Trip;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
    @JsonAlias({"driver", "drv"})
    private Driver driver;

    @JsonAlias({"request", "req"})
    private Request request;

    @JsonAlias({"car", "vehicle"})
    private Car car;

    @JsonAlias({"trip", "trp"})
    private Trip trip;
}