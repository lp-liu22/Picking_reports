package com.cb.controller;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.commonEntity.ResultData;
import com.cb.entity.SysUserQueryParam;
import com.cb.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("deptUser")
public class DeptUserController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping("searchUserInfoByConditions")
    public ResultData<PageResult<SysUserQueryParam>> searchUserInfoByConditions(@RequestBody PageQuery<SysUserQueryParam> paramPageQuery){
        return ResultData.success(sysUserService.searchUserInfoByConditions(paramPageQuery));
    }
    @PostMapping("deleteUserInDept")
    public ResultData deleteUserInDept(@RequestBody List<Long> ids){
        return ResultData.success(sysUserService.deleteUserInDept(ids));
    }
}
