package com.hcbxwy.blog.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.hcbxwy.blog.common.enums.ResultEnum;
import com.hcbxwy.blog.common.exception.BizException;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 异常工具类
 *
 * @author hcb
 * @since 2025/12/4 17:54
 */
@NoArgsConstructor
public class ExceptionUtil {

    /**
     * 报400错误，一般是参数有问题时使用
     *
     * @param message 错误信息
     */
    public static void badRequest(String message) {
        throw new BizException(ResultEnum.BAD_REQUEST, message);
    }

    /**
     * 报404错误，一般是资源不存在时使用
     *
     * @param message 错误信息
     */
    public static void notFound(String message) {
        throw new BizException(ResultEnum.NOT_FOUND, message);
    }

    /**
     * 报401错误，一般是权限不足时使用
     *
     * @param message 错误信息
     */
    public static void unauthorized(String message) {
        throw new BizException(ResultEnum.UNAUTHORIZED, message);
    }

    /**
     * 报403错误，一般是权限不足时使用
     *
     * @param message 错误信息
     */
    public static void forbidden(String message) {
        throw new BizException(ResultEnum.FORBIDDEN, message);
    }

    /**
     * 报409错误，一般是资源冲突时使用
     *
     * @param message 错误信息
     */
    public static void conflict(String message) {
        throw new BizException(ResultEnum.CONFLICT, message);
    }

    /**
     * 报500错误，一般是服务器内部错误时使用
     *
     * @param message 错误信息
     */
    public static void error(String message) {
        throw new BizException(ResultEnum.INTERNAL_SERVER_ERROR, message);
    }

    /**
     * 判断一个对象是否为null，若是则抛出异常，否则不处理
     *
     * @param obj     对象
     * @param message 异常信息
     */
    public static void throwIfNull(Object obj, String message) {
        if (Objects.isNull(obj)) {
            notFound(message);
        }
    }

    /**
     * 判断一个迭代器（容器）是否为空，若是则抛出异常，否则不处理
     *
     * @param iterable 迭代器（容器）
     * @param message  异常信息
     */
    public static void throwIfEmpty(Iterable<?> iterable, String message) {
        if (CollUtil.isEmpty(iterable)) {
            notFound(message);
        }
    }

    /**
     * 判断一个字符串是否为空字符串（""或null)，若是则抛出异常，否则不处理
     *
     * @param str     字符串
     * @param message 异常信息
     */
    public static void throwIfBlank(String str, String message) {
        if (StrUtil.isBlank(str)) {
            notFound(message);
        }
    }

}
