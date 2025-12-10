package com.hcbxwy.blog.web.handler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.hcbxwy.blog.common.utils.ValidationUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 全局请求参数校验处理
 *
 * @author hcb
 * @since 2025/12/4 17:26
 */
@RestControllerAdvice
public class RequestBodyValidationHandler extends RequestBodyAdviceAdapter {
    @Override
    public boolean supports(@NonNull MethodParameter methodParameter, @NonNull Type targetType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        // 只处理带有@RequestBody注解的方法
        return methodParameter.hasParameterAnnotation(RequestBody.class);
    }

    @Override
    @NonNull
    public Object afterBodyRead(@NonNull Object body, @NonNull HttpInputMessage inputMessage, @NonNull MethodParameter parameter,
                                @NonNull Type targetType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        if (body instanceof List<?> list) {
            if (CollUtil.isNotEmpty(list)) {
                // 过滤掉空值
                List<?> tempList = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
                // 只对实体校验
                if (CollUtil.isNotEmpty(tempList) && BeanUtil.isBean(tempList.getFirst().getClass())) {
                    list.forEach(ValidationUtil::validateOrThrow);
                }
            }
        } else {
            ValidationUtil.validateOrThrow(body);
        }
        return body;
    }
}
