package com.cb.controller;

import com.alibaba.fastjson.JSONObject;
import com.cb.common.commonEntity.ResultData;
import com.cb.service.DeptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dept")
@Tag(name = "部门接口")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("getDeptTree")
    public ResultData<List<JSONObject>> getDeptTree(){
        List<JSONObject> res = deptService.getAllDeptTree();
        if(res.size() > 0){
            return ResultData.success(res);
        }
        else{
            return ResultData.failed();
        }
    }
}
