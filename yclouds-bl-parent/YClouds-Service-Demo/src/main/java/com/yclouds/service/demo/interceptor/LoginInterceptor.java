package com.yclouds.service.demo.interceptor;

import com.yclouds.common.core.error.code.BaseError;
import com.yclouds.common.core.interceptor.BaseInterceptor;
import com.yclouds.common.core.response.ApiResp;
import com.yclouds.common.core.utils.DateUtils;
import com.yclouds.common.core.utils.JsonUtils;
import com.yclouds.common.core.utils.StringUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.cors.CorsUtils;

/**
 * 登录拦截器
 *
 * @author ye17186
 * @version 2019/3/26 14:49
 */
@Slf4j
public class LoginInterceptor extends BaseInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws IOException {

        // PreFlight请求，忽略本拦截器
        if (CorsUtils.isPreFlightRequest(request)) {
            return true;
        }

        boolean flg = false; // 是否通过
        String token = request.getHeader("token");

        // 有token表示用户已登录（生产环境应该校验token合法性）
        if (StringUtils.isNotEmpty(token)) {
            flg = true;
        } else {
            // 根据系统需要，返回特定的消息格式
            ApiResp resp = ApiResp.retFail(BaseError.SYSTEM_NO_LOGIN);
            write(request, response, JsonUtils.toJson(resp));
        }

        log.info("[LoginInterceptor] result: {}, uri: {}, time: {}, token: {}", flg,
            request.getRequestURI(), DateUtils.now(), token);
        return flg;
    }
}
