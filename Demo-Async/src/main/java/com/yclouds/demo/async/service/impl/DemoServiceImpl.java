package com.yclouds.demo.async.service.impl;

import com.yclouds.demo.async.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * com.yclouds.demo.async.service.impl.DemoServiceImpl
 *
 * @author ye17186
 * @version 2019/6/25 10:43
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public void sayHello() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("say hello. threadId = {}", Thread.currentThread().getId());
    }

    @Override
    public void sayHelloAsync1() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("say hello Async1. threadId = {}", Thread.currentThread().getId());
    }

    @Override
    @Async
    public void sayHelloAsync2() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("say hello Async2. threadId = {}", Thread.currentThread().getId());
    }
}
