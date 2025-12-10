package com.hcbxwy.blog.web.handler;

import com.hcbxwy.blog.common.enums.ResultEnum;
import com.hcbxwy.blog.common.exception.BizException;
import com.hcbxwy.blog.common.response.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author hcb
 * @since 2025/12/5 15:04
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 业务异常处理
     *
     * @param e
     * @return com.hcbxwy.blog.common.response.Result<java.lang.Object>
     * @author hcb
     * @since 2025/12/5 15:06
     */
    @ExceptionHandler(BizException.class)
    public Result<Object> handleBizException(BizException e) {
        return Result.fail(e.getResult(), e.getMsg());
    }

    /**
     * 默认异常处理
     *
     * @param e
     * @return com.hcbxwy.blog.common.response.Result<java.lang.Object>
     * @author hcb
     * @since 2025/12/5 15:12
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e, HttpServletRequest request) {
        logErrorWithRequestContext(e, request);
        return Result.fail(ResultEnum.INTERNAL_SERVER_ERROR);
    }

    private void logErrorWithRequestContext(Exception e, HttpServletRequest request) {
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String msg = String.format("%s %s | 系统异常：%s", method, uri, e.getMessage());
        log.error(msg, e);
    }

}
