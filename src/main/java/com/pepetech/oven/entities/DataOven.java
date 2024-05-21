package com.pepetech.oven.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class DataOven {
    @Id
    @GeneratedValue
    private Long id;
    private Double setPoint;
    private Double Kp;
    private Double Ki;
    private Double Kd;
    private Double hysteresis;
    private Double temperature;
    private Double externalTemperature;
    private Double error;
    private int strategySelected;
    private Date date;
}
