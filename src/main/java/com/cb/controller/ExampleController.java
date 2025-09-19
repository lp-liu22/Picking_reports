package com.cb.controller;

import com.cb.common.SysOperationLog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TEST")
@Tag(name="示例模块",description = "接口文档示例")//此处为模块名以及对应描述
public class ExampleController {
    @Operation(summary = "无参测试接口", description = "返回固定的字符串")//接口名称和接口描述
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String Test(){
        return "This is a basic ExampleController!";
    }
    @Operation(summary = "有参测试接口", description = "返回固定的字符串")
    @SysOperationLog(module = "日志测试",operationType = "查询",description = "测试参数查询")
    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String Test1(@Parameter(name = "param",description = "参数") String param){
        return "The parameter is "+param;
    }
}
