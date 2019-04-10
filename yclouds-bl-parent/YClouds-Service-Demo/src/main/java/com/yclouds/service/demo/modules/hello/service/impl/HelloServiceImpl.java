package com.yclouds.service.demo.modules.hello.service.impl;

import com.yclouds.common.core.aspect.SysLogPoint;
import com.yclouds.common.core.aspect.SysLogTarget;
import com.yclouds.service.demo.modules.hello.service.HelloService;
import com.yclouds.service.demo.modules.hello.service.SubHelloService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author ye17186
 * @version 2019/3/22 16:20
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    SubHelloService subHelloService;

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

    @Override
    @SysLogPoint(actionName = "sayHello6", target = SysLogTarget.SERVICE)
    public void sayHello6() {
        log.info("业务处理6: sayHello6");
    }

    @Override
    public void sayHello7() {

        CountDownLatch cdLatch = new CountDownLatch(3);
        Future<String> f1 = subHelloService.doSub1Async(cdLatch);
        Future<String> f2 = subHelloService.doSub2Async(cdLatch);
        subHelloService.doSub3Async(cdLatch);
        try {
            cdLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        log.info("全部子任务执行结束后，取出子任务结果并输出。");
        try {
            log.info(f1.get());
            log.info(f2.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
