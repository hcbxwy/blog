package com.hcbxwy.blog.common.handler;

import com.hcbxwy.blog.common.annotation.IgnoreResponseHandle;
import com.hcbxwy.blog.common.response.Result;
import com.hcbxwy.blog.common.utils.JsonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * 统一接口返回格式
 *
 * @author hcb
 * @since 2025/12/5 15:23
 */
@RestControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        // 带有注解 @IgnoreResponseHandle 的接口不做返回值格式处理
        Annotation[] annotations = returnType.getMethodAnnotations();
        return Arrays.stream(annotations).noneMatch(a -> a instanceof IgnoreResponseHandle);
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            @NonNull MethodParameter returnType,
            @NonNull MediaType selectedContentType,
            @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
            @NonNull ServerHttpRequest request,
            @NonNull ServerHttpResponse response) {
        if (body instanceof Result<?>) {
            return body;
        }
        if (body instanceof String) {
            return JsonUtil.toJsonStr(Result.ok(body));
        }
        return Result.ok(body);
    }
}
