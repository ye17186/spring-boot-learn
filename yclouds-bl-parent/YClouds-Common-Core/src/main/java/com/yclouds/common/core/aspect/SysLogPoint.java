package com.yclouds.common.core.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ye17186
 * @version 2019/3/26 16:18
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SysLogPoint {

    /**
     * 操作名
     */
    String actionName() default "unknown";

    /**
     * 是否忽略结果
     */
    boolean ignoreOutput() default false;

    /**
     * 敏感参数
     */
    String[] sensitiveParams() default {};

    /**
     * 目标类型：CONTROLLER：controller日志, SERVICE：service日志, DAO：dao日志, METHOD：普通方法日志
     */
    SysLogTarget target() default SysLogTarget.CONTROLLER;
}
