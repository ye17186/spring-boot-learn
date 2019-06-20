package com.yclouds.demo.log4j2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
public class DemoLog4j2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoLog4j2Application.class, args);
    }

    ExecutorService pool = Executors.newCachedThreadPool();

    @GetMapping("/log")
    public String ok(@RequestParam("t") int thead, @RequestParam("c") int count) {

        long start = System.currentTimeMillis();
        CountDownLatch cd = new CountDownLatch(thead);
        for (int i = 0; i < thead; i++) {
            final int threadNo = i;
            pool.submit(() -> {

                for (int j = 0; j < count; j++) {
                    log.info("i am a log. t={}, i={}", threadNo, j);
                }

                cd.countDown();
            });
        }

        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("duration: {}ms", System.currentTimeMillis() - start);
        return "OK";
    }

}
