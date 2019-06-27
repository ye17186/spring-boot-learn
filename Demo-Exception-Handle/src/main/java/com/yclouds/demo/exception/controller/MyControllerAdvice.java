package com.yclouds.demo.exception.controller;

import com.yclouds.demo.exception.exception.LogicException;
import com.yclouds.demo.exception.response.ApiResp;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.yclouds.demo.exception.controller.ControllerAdvice
 *
 * @author ye17186
 * @version 2019/6/27 10:39
 */
@Slf4j
@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 处理业务异常
     */
    @ExceptionHandler(LogicException.class)
    @ResponseBody
    protected ApiResp handleLogicException(HttpServletRequest request, LogicException ex) {

        log.info("[业务异常] url={}, code={}, msg={}", request.getRequestURL(), ex.getCode(),
            ex.getMsg());
        return ApiResp.retFail(ex.getCode(), ex.getMsg());
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected ApiResp handleException(HttpServletRequest request, Exception ex) {

        log.error("[系统异常] url={}", request.getRequestURL(), ex);
        return ApiResp.retFail(999, "系统异常");
    }


}
