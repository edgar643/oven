package com.pepetech.oven.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Parameters {
    @Id
    @GeneratedValue
    private Long id;
    private Double setPoint;
    private Double kp;
    private Double ki;
    private Double kd;
    private Double hysteresis;
    private int strategySelected;
}
