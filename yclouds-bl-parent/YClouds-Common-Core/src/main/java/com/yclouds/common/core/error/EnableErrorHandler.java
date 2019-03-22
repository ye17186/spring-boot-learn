package com.yclouds.common.core.error;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * 启用自定义的错误处理类
 *
 * @author ye17186
 * @version 2019/3/21 16:10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({YControllerAdvice.class, YErrorHandler.class})
public @interface EnableErrorHandler {
}
