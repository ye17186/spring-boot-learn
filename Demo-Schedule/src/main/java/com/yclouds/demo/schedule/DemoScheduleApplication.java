package com.yclouds.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
// 启用定时任务
@EnableScheduling
@Slf4j
public class DemoScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoScheduleApplication.class, args);
    }

    /**
     * 任务一，从0秒开始，每5秒执行一次
     */
    @Scheduled(cron = "0/3 * * * * ? ")
    public void task1() {
        log.info("i am task one.");
    }

    /**
     * 任务二，固定延时，上一次执行完后，3秒后再执行下次
     */
    @Scheduled(fixedDelay = 5000)
    public void task2() {
        log.info("i am task two.");
    }

    /**
     * 任务三，固定频率，每7秒执行一次
     */
    @Scheduled(fixedRate = 7000)
    public void task3() {
        log.info("i am task three.");
    }

}
