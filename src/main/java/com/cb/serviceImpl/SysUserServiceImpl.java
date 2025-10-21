package com.cb.serviceImpl;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.util.CustomizeStringUtils;
import com.cb.entity.SysUserQueryParam;
import com.cb.entity.UserDeptAddParam;
import com.cb.entity.dataBaseEntity.UserEntity;
import com.cb.mapper.SysUserMapper;
import com.cb.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public PageResult<SysUserQueryParam> searchUserInfoByConditions(PageQuery<SysUserQueryParam> paramPageQuery) {
        paramPageQuery.getQueryParam().setUserName(CustomizeStringUtils.escapeMysqlLikeChar(paramPageQuery.getQueryParam().getUserName(), '#'));
        List<SysUserQueryParam> data= sysUserMapper.searchUserInfoByConditions(paramPageQuery);
        Integer total = sysUserMapper.searchUserInfoByConditionsCount(paramPageQuery);
        return PageResult.handleSearchData(data,total, paramPageQuery.getPageNum(), paramPageQuery.getValidPageSize());
    }

    @Override
    public List<UserEntity> getUsersOfAllocatableDept() {

        return sysUserMapper.getUsersOfAllocatableDept();
    }

    @Override
    public Integer addUserInDept(UserDeptAddParam param) {
        return sysUserMapper.addUserInDept(param);
    }

    @Override
    public Integer deleteUserInDept(List<Long> ids) {
        return sysUserMapper.deleteUserInDept(ids);
    }

    @Override
    public Integer updateAuthorityOfUser(Long id) {
        return sysUserMapper.updateAuthorityOfUser(id);
    }
}
