package com.pepetech.oven.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Double kp;
    private Double ki;
    private Double kd;
    private Double hysteresis;
    private Double temperature;
    private Double externalTemperature;
    private Double forecastTemperature;
    private Double output;
    private Double error;
    private int strategySelected;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date date = new Date();
}
