package com.yclouds.demo.exception.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * com.yclouds.demo.exception.exception.LogicException 业务异常
 *
 * @author yemeng-lhq
 * @version 2019/6/27 10:42
 */
@Setter
@Getter
public class LogicException extends RuntimeException {

    private static final long serialVersionUID = 9046247481337252549L;
    /**
     * 异常码
     */
    private int code;

    /**
     * 异常信息
     */
    private String msg;

    public LogicException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public LogicException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }
}
