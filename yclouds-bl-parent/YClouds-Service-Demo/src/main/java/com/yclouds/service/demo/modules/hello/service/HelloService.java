package com.yclouds.service.demo.modules.hello.service;

/**
 * @author ye17186
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

    /**
     * 测试SysLogPoint在service层的作用
     */
    void sayHello6();
}
