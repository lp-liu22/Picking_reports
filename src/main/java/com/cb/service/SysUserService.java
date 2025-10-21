package com.cb.service;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.entity.SysUserQueryParam;
import com.cb.entity.UserDeptAddParam;
import com.cb.entity.dataBaseEntity.UserEntity;

import java.util.List;

public interface SysUserService {
    //条件查询部门已关联用户的数据
    PageResult<SysUserQueryParam> searchUserInfoByConditions(PageQuery<SysUserQueryParam> paramPageQuery);
    //查询未绑定部门的用户
    List<UserEntity> getUsersOfAllocatableDept();
    //添加用户部门的绑定关系，支持用户批量绑定
    Integer addUserInDept(UserDeptAddParam param);
    //取消用户-部门联系
    Integer deleteUserInDept(List<Long> ids);
    //修改权限
    Integer updateAuthorityOfUser(Long id);
}
