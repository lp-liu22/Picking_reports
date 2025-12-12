package com.cb.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 主要解决跨域问题
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //设置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 对所有请求路径都生效
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }
    /**
     * 配置静态资源映射
     * @param registry ResourceHandlerRegistry对象
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 自定义前端资源路径：将 / 映射到 classpath:/frontend/
        registry.addResourceHandler("/**")  // 匹配所有请求路径
                .addResourceLocations("file:./frontend/");  // 资源实际存放目录
    }
}
