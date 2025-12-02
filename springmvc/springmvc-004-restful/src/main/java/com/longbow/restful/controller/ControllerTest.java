package com.longbow.restful.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class ControllerTest {
    @GetMapping("/employee/{id}")
    public String test(@PathVariable("id") Long id) {

        SpringApplication app = new SpringApplication(ControllerTest.class);
        return "Hello World";
    }
}

