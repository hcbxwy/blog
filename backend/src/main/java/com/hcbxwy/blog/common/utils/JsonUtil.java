package com.hcbxwy.blog.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 *
 * @author hcb
 * @since 2025/12/5 15:59
 */
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 对象转json字符串
     *
     * @param obj
     * @return java.lang.String
     */
    public static String toJsonStr(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("对象转json字符串失败");
        }
    }

}
