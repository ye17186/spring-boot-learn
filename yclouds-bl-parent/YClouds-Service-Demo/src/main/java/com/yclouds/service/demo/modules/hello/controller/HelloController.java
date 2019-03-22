package com.yclouds.service.demo.modules.hello.controller;

import com.yclouds.common.core.web.YRestController;
import com.yclouds.common.core.response.ApiResp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yemeng-lhq
 * @version 2019/3/22 13:50
 */
@YRestController("/hello")
public class HelloController {

    @Value("${hello}")
    private String hello;

    @GetMapping("/say")
    public ApiResp<String> sayHello() {
        return ApiResp.retOK(hello);
    }

}
