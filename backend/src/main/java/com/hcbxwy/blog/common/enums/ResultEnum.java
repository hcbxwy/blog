package com.hcbxwy.blog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应结果枚举
 *
 * @author hcb
 * @since 2025/12/4 14:09
 */
@AllArgsConstructor
@Getter
public enum ResultEnum {

    OK(200, "success"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    CONFLICT(409, "Conflict"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String msg;
}
