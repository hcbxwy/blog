package com.hcbxwy.blog.common.response;

import com.hcbxwy.blog.common.enums.ResultEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 统一接口返回实体
 *
 * @author hcb
 * @since 2025/12/4 17:56
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 结果信息
     */
    private String msg;

    /**
     * 结果集
     */
    private T data;

    private Result(Integer code, boolean success, String msg, T data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    private Result(ResultEnum resultEnum, T data) {
        this(resultEnum.getCode(), ResultEnum.OK.equals(resultEnum), resultEnum.getMsg(), data);
    }

    /**
     * 成功方法，有数据返回
     */
    public static <E> Result<E> ok(E data) {
        return new Result<>(ResultEnum.OK, data);
    }

    /**
     * 成功方法，无数据返回
     */
    public static <E> Result<E> ok() {
        return ok(null);
    }


    /**
     * 失败方法，使用自定义错误码和错误描述
     *
     * @param code 错误码
     * @param msg  错误描述
     */
    public static <E> Result<E> fail(int code, String msg) {
        return new Result<>(code, false, msg, null);
    }

    /**
     * 失败方法
     *
     * @param resultEnum 错误码枚举类
     */
    public static <E> Result<E> fail(ResultEnum resultEnum) {
        return fail(resultEnum.getCode(), resultEnum.getMsg());
    }

    /**
     * 失败方法，支持自定义错误描述
     *
     * @param resultEnum 错误码枚举
     * @param otherMsg   自定义错误描述
     */
    public static <E> Result<E> fail(ResultEnum resultEnum, String otherMsg) {
        return fail(resultEnum.getCode(), otherMsg);
    }

}
