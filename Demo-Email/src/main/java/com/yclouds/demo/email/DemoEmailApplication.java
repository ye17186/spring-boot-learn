package com.yclouds.demo.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/email")
public class DemoEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEmailApplication.class, args);
    }
}
