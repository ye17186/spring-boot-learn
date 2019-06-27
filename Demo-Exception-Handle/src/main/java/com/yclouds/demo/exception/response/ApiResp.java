package com.yclouds.demo.exception.response;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * com.yclouds.demo.exception.response.ApiResp 接口统一响应格式
 *
 * @author ye17186
 * @version 2019/6/27 10:31
 */
@Setter
@Getter
public class ApiResp<T> implements Serializable {


    private static final long serialVersionUID = -8128674034949177418L;

    /**
     * 接口正常返回的状态码
     */
    private static final int SUCCESS_CODE = 0;
    /**
     * 接口正常返回的消息
     */
    private static final String SUCCESS_MSG = "SUCCESS";

    /**
     * 错误码
     */
    private int code = SUCCESS_CODE;

    /**
     * 错误信息
     */
    private String msg = SUCCESS_MSG;

    private T data;

    public static ApiResp retOK() {
        return new ApiResp();
    }

    public static <T> ApiResp<T> retOK(T data) {

        ApiResp<T> resp = new ApiResp<>();
        resp.setData(data);
        return resp;
    }

    public static ApiResp retFail(int code, String msg) {
        ApiResp resp = new ApiResp();
        resp.setCode(code);
        resp.setMsg(msg);
        return resp;
    }

}
