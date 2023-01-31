package com.example.myfinder.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyFinderServiceDelegate {

    @Autowired
    RestTemplate restTemplate;

    // Call our student service with details : make sure to do http exchange method : call fallback method if my service is down
    @HystrixCommand(fallbackMethod = "defaultStudentsCall")
    public String getStudents(String schoolname) {
        return this.restTemplate.exchange("http://localhost:8098/students/" + schoolname
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();
    }

    // Make a hystrix fallback method
    private String defaultStudentsCall(String schoolname) {
        return "Problème avec le microservice, le fallback a été call";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
