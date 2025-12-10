package com.hcbxwy.blog.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis-plus 配置类
 *
 * @author hcb
 * @since 2025/11/28 17:25
 */
@Configuration
@MapperScan("com.hcbxwy.blog.core.mapper")
public class MyBatisPlusConfig {
}