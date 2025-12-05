package com.hcbxwy.blog.common.exception;

import com.hcbxwy.blog.common.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常类
 *
 * @author Billson
 * @date 2021/3/31 14:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {
    private ResultEnum result;
    private String msg;

    public BizException(ResultEnum result, String msg) {
        super(msg);
        this.result = result;
        this.msg = msg;
    }
}
