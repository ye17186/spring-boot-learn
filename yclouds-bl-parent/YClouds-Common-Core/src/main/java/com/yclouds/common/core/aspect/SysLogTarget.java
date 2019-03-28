package com.yclouds.common.core.aspect;

/**
 * 系统日志目标类型
 *
 * @author ye17186
 * @version 2019/3/26 16:26
 */
public enum SysLogTarget {
    /**
     * controller层日志
     */
    CONTROLLER,
    /**
     * service层日志
     */
    SERVICE,
    /**
     * dao层日志
     */
    DAO,
    /**
     * 其他日志
     */
    OTHER
}
