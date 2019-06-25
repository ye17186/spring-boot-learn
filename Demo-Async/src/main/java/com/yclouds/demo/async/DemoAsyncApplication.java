package com.yclouds.demo.async;

import com.yclouds.demo.async.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAsync
@RestController
public class DemoAsyncApplication {

    @Autowired
    DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DemoAsyncApplication.class, args);
    }

    @RequestMapping("/demo")
    public String demo() {
        demoService.sayHello();
        demoService.sayHelloAsync1();
        demoService.sayHelloAsync2();
        return "ok";
    }
}
