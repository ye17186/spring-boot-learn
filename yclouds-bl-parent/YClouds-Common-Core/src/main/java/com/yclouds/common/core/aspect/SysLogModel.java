package com.yclouds.common.core.aspect;

import java.io.Serializable;
import lombok.Data;

/**
 * @author ye17186
 * @version 2019/3/26 16:53
 */
@Data
public class SysLogModel implements Serializable {

    /**
     * 操作名
     */
    private String actionName;

    /**
     * 目标类型：CONTROLLER、SERVICE、DAO、METHOD
     */
    private String target;

    /**
     * 日志类型：RETURN、THROWING
     */
    private String type;

    /**
     * 输入
     */
    private String input;

    /**
     * 输出
     */
    private String output;

    /**
     * 异常信息
     */
    private String exMsg;
}
