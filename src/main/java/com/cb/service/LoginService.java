package com.cb.service;

import com.cb.common.commonEntity.ResultData;
import com.cb.entity.dataBaseEntity_jpa.UserEntity;

/**
 * 一个简单的登录接口，只校验密码和返回简单地权限
 */

public interface LoginService {
    ResultData<UserEntity> login(String userName, String userPassword);
}
