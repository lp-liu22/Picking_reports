package com.cb.serviceImpl;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.util.CustomizeStringUtils;
import com.cb.entity.SysUserQueryParam;
import com.cb.entity.UserDeptAddParam;
import com.cb.entity.dataBaseEntity_jpa.UserEntity;
import com.cb.mapper.SysUserMapper;
import com.cb.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 根据条件查询用户信息
     * @param paramPageQuery
     * @return
     */
    @Override
    public PageResult<SysUserQueryParam> searchUserInfoByConditions(PageQuery<SysUserQueryParam> paramPageQuery) {
        paramPageQuery.getQueryParam().setUserName(CustomizeStringUtils.escapeMysqlLikeChar(paramPageQuery.getQueryParam().getUserName(), '#'));
        List<SysUserQueryParam> data= sysUserMapper.searchUserInfoByConditions(paramPageQuery);
        Integer total = sysUserMapper.searchUserInfoByConditionsCount(paramPageQuery);
        return PageResult.handleSearchData(data,total, paramPageQuery.getPageNum(), paramPageQuery.getValidPageSize());
    }
    /**
     * 查询未绑定部门的用户
     * @return
     */
    @Override
    public List<UserEntity> getUsersOfAllocatableDept() {

        return sysUserMapper.getUsersOfAllocatableDept();
    }
    /**
     * 添加用户部门的绑定关系，支持用户批量绑定
     * @param param
     * @return
     */
    @Override
    public Integer addUserInDept(UserDeptAddParam param) {
        return sysUserMapper.addUserInDept(param);
    }
    /**
     * 取消用户-部门联系
     * @param ids
     * @return
     */
    @Override
    public Integer deleteUserInDept(List<Long> ids) {
        return sysUserMapper.deleteUserInDept(ids);
    }
    /**
     * 修改权限
     * @param id
     * @return
     */
    @Override
    public Integer updateAuthorityOfUser(Long id) {
        return sysUserMapper.updateAuthorityOfUser(id);
    }
}
