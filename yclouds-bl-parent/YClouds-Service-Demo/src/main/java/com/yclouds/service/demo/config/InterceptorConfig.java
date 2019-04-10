package com.yclouds.service.demo.config;

import com.yclouds.service.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author ye17186
 * @version 2019/3/26 15:00
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册登录拦截器，拦截除/login以外的所有请求
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
            .excludePathPatterns("/login", "/hello/**");
    }
}
