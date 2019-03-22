package com.yclouds.service.demo.modules.hello.service;

/**
 * @author yemeng-lhq
 * @version 2019/3/22 16:20
 */
public interface HelloService {

    /**
     * 同步say hello
     */
    void sayHello();

    /**
     * 异步say hello
     */
    void sayHelloAsync();
}
