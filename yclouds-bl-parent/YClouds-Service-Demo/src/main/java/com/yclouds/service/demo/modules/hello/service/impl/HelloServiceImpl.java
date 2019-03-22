package com.yclouds.service.demo.modules.hello.service.impl;

import com.yclouds.service.demo.modules.hello.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author ye17186
 * @version 2019/3/22 16:20
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {

        // 模拟耗时操作
        try {
            Thread.sleep(1000);
            log.info("execute...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Async
    public void sayHelloAsync() {
        sayHello();
    }
}
