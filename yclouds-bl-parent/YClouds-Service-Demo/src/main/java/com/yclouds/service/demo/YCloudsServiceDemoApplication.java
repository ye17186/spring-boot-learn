package com.yclouds.service.demo;

import com.yclouds.common.core.error.EnableErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableErrorHandler
public class YCloudsServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YCloudsServiceDemoApplication.class, args);
    }

}
