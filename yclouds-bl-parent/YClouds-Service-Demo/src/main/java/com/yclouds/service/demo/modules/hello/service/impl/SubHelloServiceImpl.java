package com.yclouds.service.demo.modules.hello.service.impl;

import com.yclouds.service.demo.modules.hello.service.SubHelloService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 * @author ye17186
 * @version 2019/4/9 15:12
 */
@Slf4j
@Service
public class SubHelloServiceImpl implements SubHelloService {

    @Override
    @Async
    public Future<String> doSub1Async(CountDownLatch cdLatch) {
        log.info("执行异步自任务1：start");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        log.info("执行异步自任务1：end");
        cdLatch.countDown();
        return new AsyncResult<>("1 OK");
    }

    @Override
    @Async
    public Future<String> doSub2Async(CountDownLatch cdLatch) {
        log.info("执行异步自任务2：start");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        log.info("执行异步自任务2：end");
        cdLatch.countDown();
        return new AsyncResult<>("2 OK");
    }

    @Override
    @Async
    public void doSub3Async(CountDownLatch cdLatch) {
        log.info("执行异步自任务3：start");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        log.info("执行异步自任务3：end");
        cdLatch.countDown();
    }
}
