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
    /**
     * 分页查询部门已关联用户的数据
     * @param paramPageQuery 分页查询参数
     * @return 分页查询结果
     */
    @PostMapping("searchUserInfoByConditions")
    public ResultData<PageResult<SysUserQueryParam>> searchUserInfoByConditions(@RequestBody PageQuery<SysUserQueryParam> paramPageQuery){
        return ResultData.success(sysUserService.searchUserInfoByConditions(paramPageQuery));
    }
    /**
     * 取消用户-部门联系
     * @param ids 用户ID列表
     * @return 操作结果
     */
    @PostMapping("deleteUserInDept")
    public ResultData deleteUserInDept(@RequestBody List<Long> ids){
        return ResultData.success(sysUserService.deleteUserInDept(ids));
    }
}
