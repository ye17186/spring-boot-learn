package com.yclouds.service.demo.modules.hello.controller;

import com.yclouds.common.core.aspect.SysLogPoint;
import com.yclouds.common.core.response.ApiResp;
import com.yclouds.common.core.utils.JsonUtils;
import com.yclouds.common.core.web.YRestController;
import com.yclouds.service.demo.modules.hello.dto.HelloInDTO;
import com.yclouds.service.demo.modules.hello.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ye17186
 * @version 2019/3/22 13:50
 */
@Slf4j
@YRestController("/hello")
public class HelloController {

    @Value("${hello}")
    private String hello;

    @Autowired
    HelloService helloService;

    /**
     * 同步say hello
     *
     * @return 内容
     */
    @GetMapping("/say1")
    public ApiResp<String> sayHello1() {

        long start = System.currentTimeMillis();
        log.info("start...");
        helloService.sayHello();
        log.info("end... duration: {}", System.currentTimeMillis() - start);

        return ApiResp.retOK(hello);
    }

    /**
     * 异步say hello
     *
     * @return 内容
     */
    @GetMapping("/say2")
    public ApiResp<String> sayHello2() {

        long start = System.currentTimeMillis();
        log.info("start...");
        helloService.sayHelloAsync();
        log.info("end... duration: {}", System.currentTimeMillis() - start);

        return ApiResp.retOK(hello);
    }

    /**
     * 正常返回的日志记录
     *
     * @param inDTO 入参
     */
    @SysLogPoint(actionName = "Say4", sensitiveParams = "password")
    @PostMapping("/say4")
    public ApiResp sayHello4(@RequestBody HelloInDTO inDTO) {
        log.info("业务处理, args: {}", JsonUtils.toJson(inDTO));
        return ApiResp.retOK();
    }

    /**
     * 异常返回的日志记录
     *
     * @param inDTO 入参
     */
    @SysLogPoint(actionName = "Say5", sensitiveParams = "password")
    @PostMapping("/say5")
    public ApiResp sayHello5(@RequestBody(required = false) HelloInDTO inDTO) {
        log.info("业务处理, args: {}", JsonUtils.toJson(inDTO));
        if (inDTO == null) {
            throw new RuntimeException("异常测试");
        }
        return ApiResp.retOK();
    }

    /**
     * Service层的日志记录
     */
    @SysLogPoint(actionName = "Say6")
    @PostMapping("/say6")
    public ApiResp sayHello6() {
        helloService.sayHello6();
        return ApiResp.retOK();
    }
}
