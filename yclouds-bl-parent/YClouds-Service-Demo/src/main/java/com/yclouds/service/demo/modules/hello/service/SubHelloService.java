package com.yclouds.service.demo.modules.hello.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * @author yemeng-lhq
 * @version 2019/4/9 15:12
 */
public interface SubHelloService {

    /**
     * 异步子任务1
     *
     * @param cdLatch CountDownLatch
     */
    Future<String> doSub1Async(CountDownLatch cdLatch);

    /**
     * 异步子任务2
     *
     * @param cdLatch CountDownLatch
     */
    Future<String> doSub2Async(CountDownLatch cdLatch);

    /**
     * 异步子任务3
     *
     * @param cdLatch CountDownLatch
     */
    void doSub3Async(CountDownLatch cdLatch);
}
