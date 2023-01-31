package com.example.myfinder.util;

import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

import java.util.Collections;

@Component
public class MyFinderInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("details",
                Collections.singletonMap("description", "This is the School service, which is discovery server aware, and this service will Call Student Microservice, fro student details, which is again dicovery server aware!!! "));
    }
}