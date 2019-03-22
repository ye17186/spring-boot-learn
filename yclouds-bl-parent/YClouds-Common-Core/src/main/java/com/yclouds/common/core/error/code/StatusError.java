package com.yclouds.common.core.error.code;

import com.yclouds.common.core.response.ApiRespData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ye17186
 * @version 2019/3/21 16:48
 */
@Setter
@Getter
@AllArgsConstructor
public class StatusError extends ApiRespData {

    private static final long serialVersionUID = 795000378131425885L;

    /**
     * 原始状态码
     */
    private int status;

    /**
     * 请求路径
     */
    private String path;

    /**
     * 错误信息
     */
    private String msg;
}
