package com.yclouds.service.demo.filter;

import com.yclouds.common.core.constant.RequestAttrConst;
import com.yclouds.common.core.utils.IdGenUtils;
import com.yclouds.common.core.utils.RequestUtils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * 访问过滤器，用于记录每次请求的日志
 *
 * @author ye17186
 * @version 2019/3/21 19:37
 */
@Slf4j
@WebFilter(filterName = "ApiAccessFilter", urlPatterns = "/*")
public class ApiAccessFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Long requestId = IdGenUtils.nextIdByMem(); // 请求ID
        long start = System.currentTimeMillis(); // 请求进入时间

        request.setAttribute(RequestAttrConst.REQUEST_ID, requestId);
        request.setAttribute(RequestAttrConst.REQUEST_START_TIME, start);

        log.info("[Api Access] start. id: {}, uri: {}, method: {}, client: {}", requestId,
            request.getRequestURI(), request.getMethod(), RequestUtils.getIP(request));
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("[Api Access]   end. id: {}, duration: {}ms", requestId,
            System.currentTimeMillis() - start);

    }

    @Override
    public void destroy() {

    }
}
