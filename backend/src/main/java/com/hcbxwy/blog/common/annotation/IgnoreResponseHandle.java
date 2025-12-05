/*
 * <ul>
 * <li>项目名称：panyu-cloud</li>
 * <li>文件名称：IgnoreResponseFormat.java</li>
 * <li>日期：2023/12/22 14:05</li>
 * <li>Copyright ©2016-2023 广州职赢未来信息科技有限公司 All Rights Reserved.</li>
 * </ul>
 */
package com.hcbxwy.blog.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 忽略接口统一格式化处理
 *
 * @author hcb
 * @since 2025/12/5 15:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IgnoreResponseHandle {
}
