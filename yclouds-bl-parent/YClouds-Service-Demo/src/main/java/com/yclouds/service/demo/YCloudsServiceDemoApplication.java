package com.yclouds.service.demo;

import com.yclouds.common.core.error.EnableErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableErrorHandler
@ServletComponentScan("com.yclouds.service.demo")
public class YCloudsServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YCloudsServiceDemoApplication.class, args);
    }

}
