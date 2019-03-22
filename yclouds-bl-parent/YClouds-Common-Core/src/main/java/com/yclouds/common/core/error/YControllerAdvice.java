package com.yclouds.common.core.error;

import com.yclouds.common.core.error.code.BaseError;
import com.yclouds.common.core.response.ApiResp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller增强类，用于处理各种异常
 *
 * @author ye17186
 * @version 2019/3/21 16:58
 */
@SuppressWarnings("unused")
@Slf4j
@ControllerAdvice
public class YControllerAdvice {


    /**
     * 参数校验不通过异常
     *
     * @param request Http请求
     * @param ex 异常对象
     * @see javax.validation.Valid
     * @see org.springframework.validation.annotation.Validated
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    protected ApiResp handleException(HttpServletRequest request,
        MethodArgumentNotValidException ex) {

        log.warn("[Method Arg Not Valid] url: {}", request.getRequestURL().toString());

        List<ObjectError> list = ex.getBindingResult().getAllErrors();
        StringBuffer detail = new StringBuffer();
        if (!ObjectUtils.isEmpty(list)) {
            list.forEach(item -> detail.append(item.getDefaultMessage()).append(";"));
        }

        return ApiResp.retFail(BaseError.SYSTEM_ARGUMENT_NOT_VALID, detail.toString());
    }

    /**
     * 请求方法（GET、POST等）不支持异常处理
     *
     * @param request Http请求
     * @param ex 异常对象
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    protected ApiResp handleException(HttpServletRequest request,
        HttpRequestMethodNotSupportedException ex) {

        String method = request.getMethod();
        log.warn("[Method Not Supported] url: {}，method: {}", request.getRequestURL(), method);

        return ApiResp.retFail(BaseError.SYSTEM_REQUEST_METHOD_NOT_SUPPORTED, method);
    }

    /**
     * 最后兜底的异常处理
     * <br>
     * 由请求接口不存在产生的404异常，不会走到这里，所有另外定义了YErrorHandler来处理这类异常
     *
     * @param request Http请求
     * @param ex 异常对象
     * @see YErrorHandler
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    protected ApiResp handleException(HttpServletRequest request, Exception ex) {

        log.error("[System Exception] url: {}", request.getRequestURL(), ex);
        return ApiResp.retFail(BaseError.SYSTEM_EXCEPTION);
    }

}
