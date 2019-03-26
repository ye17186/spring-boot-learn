package com.yclouds.common.core.interceptor;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器父类
 *
 * @author ye17186
 * @version 2019/3/26 15:25
 */
public class BaseInterceptor implements HandlerInterceptor {

    /**
     * 重写响应体
     *
     * @param request 请求
     * @param response 响应
     * @param content 响应内容
     */
    protected void write(HttpServletRequest request, HttpServletResponse response, String content)
        throws IOException {

        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(content);
    }
}
