package com.yclouds.demo.exception.controller;

import com.yclouds.demo.exception.exception.LogicException;
import com.yclouds.demo.exception.response.ApiResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.yclouds.demo.exception.controller.DemoController
 *
 * @author ye17186
 * @version 2019/6/27 10:37
 */
@RestController
public class DemoController {

    @RequestMapping("/demo")
    public ApiResp test(String flg) {

        if("Y".equals(flg)) {
            throw new LogicException(1001, "i am a exception.");
        } else {
            return ApiResp.retOK();
        }
    }

}
