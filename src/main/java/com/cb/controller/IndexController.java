package com.cb.controller;
import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 注意用 @Controller 而非 @RestController
public class IndexController {

    // 处理根路径请求，转发到前端首页 index.html
    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }
}