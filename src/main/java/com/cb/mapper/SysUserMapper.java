package com.cb.mapper;

import com.cb.common.commonEntity.PageQuery;
import com.cb.entity.SysUserQueryParam;
import com.cb.entity.UserDeptAddParam;
import com.cb.entity.dataBaseEntity_jpa.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    //条件查询部门已关联用户的数据
    List<SysUserQueryParam> searchUserInfoByConditions(PageQuery<SysUserQueryParam> paramPageQuery);
    Integer searchUserInfoByConditionsCount(PageQuery<SysUserQueryParam> paramPageQuery);
    //查询未绑定部门的用户
    List<UserEntity> getUsersOfAllocatableDept();
    //添加用户部门的绑定关系，支持用户批量绑定
    Integer addUserInDept(UserDeptAddParam param);
    //取消用户-部门联系
    Integer deleteUserInDept(List<Long> ids);
    //修改权限
    Integer updateAuthorityOfUser(Long id);

}
