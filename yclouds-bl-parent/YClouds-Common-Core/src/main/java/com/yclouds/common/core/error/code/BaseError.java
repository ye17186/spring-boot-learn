package com.yclouds.common.core.error.code;

import lombok.Getter;

/**
 * 基础公用错误码(错误代码统一规划，以10开头)
 *
 * @author ye17186
 * @version 2019/2/18 15:49
 */
@Getter
public enum BaseError {

    SYSTEM_EXCEPTION(10001, "系统异常，请联系管理员"),
    SYSTEM_REQUEST_METHOD_NOT_SUPPORTED(10002, "请求方法不支持"),
    SYSTEM_ARGUMENT_NOT_VALID(10003, "参数校验失败"),
    SERVICE_ERROR(10101, "服务暂不可用，请稍后重试"),
    SERVICE_DOWN(10102, "服务[${serviceId}]暂不可用，请稍后重试");

    /**
     * 错误码
     */
    private final int code;

    /**
     * 错误信息
     */
    private final String msg;

    BaseError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
