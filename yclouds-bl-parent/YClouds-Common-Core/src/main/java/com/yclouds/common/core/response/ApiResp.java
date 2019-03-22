package com.yclouds.common.core.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.Page;
import com.yclouds.common.core.error.code.BaseError;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 所有服务统一响应数据格式
 *
 * @author ye17186
 * @version 2019/2/15 14:40
 */
@Data
public class ApiResp<T> implements Serializable {

    private static final long serialVersionUID = 9211889136173018364L;

    /**
     * 正常响应码
     */
    private static final int SUCCESS_CODE = 0;

    /**
     * 正常响应消息
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
    /**
     * 响应内容，默认为null
     */
    private T data = null;

    /**
     * 是否的正常响应
     *
     * @return true=正常；false=异常
     */
    @JsonIgnore
    public boolean isOK() {
        return code == SUCCESS_CODE;
    }

    /**
     * 无data的正常返回
     */
    public static ApiResp<String> retOK() {
        return retOK("");
    }

    /**
     * 简单String内里data的正常返回
     */
    public static ApiResp<String> retOK(String data) {

        ApiResp<String> response = new ApiResp<>();
        response.setData(data);
        return response;
    }

    /**
     * 有data的正常返回
     *
     * @param data data内容
     * @param <T> data类型
     */
    public static <T extends ApiRespData> ApiResp<T> retOK(T data) {
        ApiResp<T> response = new ApiResp<>();
        response.setData(data);
        return response;
    }

    public static <T extends ApiRespData> ApiResp<List<T>> retOK(List<T> data) {
        ApiResp<List<T>> response = new ApiResp<>();
        response.setData(data);
        return response;
    }

    /**
     * 正常返回ApiPage类型数据
     * <br> 适用于分页获取数据的场景
     *
     * @param page page内容
     * @param <T> Page泛型
     * @return 正常响应体
     */
    public static <T extends ApiRespData> ApiResp<ApiPage<T>> retOK(Page<T> page) {

        ApiPage<T> apiPage = new ApiPage<>();
        apiPage.setItems(page.getResult());
        apiPage.setPageNo(page.getPageNum());
        apiPage.setPageSize(page.getPageSize());
        apiPage.setPages(page.getPages());
        apiPage.setTotal(page.getTotal());

        ApiResp<ApiPage<T>> response = new ApiResp<>();
        response.setData(apiPage);

        return response;
    }

    /**
     * 无data的失败返回
     *
     * @param error 错误类型
     */
    public static ApiResp retFail(BaseError error) {
        return retFail(error.getCode(), error.getMsg());
    }

    /**
     * 有data的失败返回
     *
     * @param error 错误类型
     */
    public static <T> ApiResp<T> retFail(BaseError error, T data) {
        return retFail(error.getCode(), error.getMsg(), data);
    }

    /**
     * 无data的失败返回
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> ApiResp<T> retFail(int code, String msg) {
        ApiResp<T> response = new ApiResp<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    /**
     * 有data的失败返回
     * <br>
     * 失败返回的场景不多，所以没有严格要求T泛型
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> ApiResp<T> retFail(int code, String msg, T data) {
        ApiResp<T> response = new ApiResp<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }


}
