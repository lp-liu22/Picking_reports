package com.cb.common;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
/**
 * swagger接口文档
 * 访问路径：
 * OpenAPI 文档：http://localhost:8080/v3/api-docs
 * Swagger UI 页面：http://localhost:8080/swagger-ui.html
 */
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Picking Reports 接口文档") // 文档标题
                        .version("1.0") // 文档版本
                        .description("项目接口文档说明，包含所有业务接口")); // 文档描述
    }
}
