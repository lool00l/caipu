package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.interceptor.AuthorizationInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport{
	
	@Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }
//	拦截器配置：通过 addInterceptors 方法将 AuthorizationInterceptor 拦截器注册到 Spring MVC 中，
//	并指定拦截所有请求（addPathPatterns("/**")），
//	同时排除对静态资源（excludePathPatterns("/static/**")）的拦截。
//	AuthorizationInterceptor 通常用于进行权限验证、登录状态检查等操作，确保用户请求的合法性。
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
        super.addInterceptors(registry);
	}
	
	/**
	 * springboot 2.0配置WebMvcConfigurationSupport之后，会导致默认配置被覆盖，要访问静态资源需要重写addResourceHandlers方法
	 * 静态资源配置：由于继承了 WebMvcConfigurationSupport，
	 * 默认的静态资源配置会被覆盖，因此需要重写 addResourceHandlers 方法来指定静态资源的位置。
	 * 这里配置了多个资源路径，包括 classpath:/resources/、classpath:/static/ 等，
	 * 以便 Spring Boot 能够正确加载这些静态资源。
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/resources/")
        .addResourceLocations("classpath:/static/")
        .addResourceLocations("classpath:/admin/")
        .addResourceLocations("classpath:/front/")
        .addResourceLocations("classpath:/public/");
		super.addResourceHandlers(registry);
    }
}
