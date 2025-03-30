
package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

/**
 * mybatis-plus配置
 * 主要用于配置 MyBatis-Plus 的分页插件。
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    /*
    *通过 @Bean 注解将 PaginationInterceptor 注入到 Spring 容器中，
    * 使得在使用 MyBatis-Plus 进行数据库操作时可以方便地实现分页功能。
    * 当执行查询操作时，MyBatis-Plus 会自动根据分页参数生成分页 SQL，
    * 从而实现对查询结果的分页展示。
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    
}
