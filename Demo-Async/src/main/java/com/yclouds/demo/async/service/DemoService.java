package com.yclouds.demo.async.service;

import org.springframework.scheduling.annotation.Async;

/**
 * com.yclouds.demo.async.service.DemoService
 *
 * @author ye17186
 * @version 2019/6/25 10:42
 */
public interface DemoService {

    /**
     * 同步say hello
     */
    void sayHello();

    /**
     * 异步say hello
     */
    @Async
    void sayHelloAsync1();

    /**
     * 异步say hello
     */
    void sayHelloAsync2();
}
