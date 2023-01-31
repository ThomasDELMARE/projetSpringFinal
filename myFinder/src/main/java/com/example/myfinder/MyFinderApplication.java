package com.example.myfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class MyFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFinderApplication.class, args);
    }

}
