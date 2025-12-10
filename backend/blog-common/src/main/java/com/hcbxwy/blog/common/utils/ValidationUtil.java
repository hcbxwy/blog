/*
 * <ul>
 * <li>项目名称：panyu-cloud</li>
 * <li>文件名称：ValidationUtil.java</li>
 * <li>日期：2023/12/22 12:04</li>
 * <li>Copyright ©2016-2023 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.blog.common.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.validation.BeanValidationResult;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 校验工具类
 *
 * @author hcb
 * @since 2025/12/4 17:55
 */
public class ValidationUtil extends cn.hutool.extra.validation.ValidationUtil {

    /**
     * 校验实体必填字段，校验不通过则返回错误信息
     *
     * @param bean   实体
     * @param groups -
     * @return java.lang.String
     */
    public static <T> String validateBean(T bean, Class<?>... groups) {
        BeanValidationResult result = warpValidate(bean, groups);
        if (!result.isSuccess()) {
            return result.getErrorMessages().stream().map(BeanValidationResult.ErrorMessage::getMessage)
                    .collect(Collectors.joining(","));
        }
        return null;
    }

    /**
     * 校验实体必填字段，校验不通过则抛异常
     *
     * @param bean   实体
     * @param groups -
     */
    public static <T> void validateOrThrow(T bean, Class<?>... groups) {
        String errorMsg = validateBean(bean, groups);
        if (StrUtil.isNotBlank(errorMsg)) {
            ExceptionUtil.badRequest(errorMsg);
        }
    }

    /**
     * 实体是否通过校验
     *
     * @param bean   实体
     * @param groups -
     * @return byte 0=不通过校验，1=通过校验
     */
    public static <T> boolean isValid(T bean, Class<?>... groups) {
        if (Objects.isNull(bean)) {
            return false;
        }
        return StrUtil.isBlank(validateBean(bean, groups));
    }
}
