package com.cb.common.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主要解决ObjectMapper注入问题
 */
@Configuration
public class JacksonConfig {

    // 显式注册ObjectMapper Bean
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
