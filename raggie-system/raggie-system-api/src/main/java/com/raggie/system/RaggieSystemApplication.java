package com.raggie.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RaggieSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(RaggieSystemApplication.class,args);
    }
}