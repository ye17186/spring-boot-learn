package com.yclouds.common.core.context;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * 启用Spring Context自动初始化程序
 *
 * @author yemeng-lhq
 * @version 2019/3/22 16:49
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SpringContextHandler.class)
public @interface EnableSpringContext {

}
