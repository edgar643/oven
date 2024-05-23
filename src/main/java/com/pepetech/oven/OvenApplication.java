package com.pepetech.oven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OvenApplication {

    public static void main(String[] args) {
        SpringApplication.run(OvenApplication.class, args);
    }

}
