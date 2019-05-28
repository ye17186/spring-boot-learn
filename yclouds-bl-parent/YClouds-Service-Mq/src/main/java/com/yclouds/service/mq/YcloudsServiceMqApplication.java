package com.yclouds.service.mq;

import com.yclouds.myhelper.web.annotation.EnableErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableErrorHandler
@RestController
@RequestMapping("/t")
public class YcloudsServiceMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(YcloudsServiceMqApplication.class, args);
    }
}
