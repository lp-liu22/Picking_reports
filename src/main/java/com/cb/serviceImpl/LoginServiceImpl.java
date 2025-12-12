package com.cb.serviceImpl;

import com.cb.common.commonEntity.ResultData;
import com.cb.entity.dataBaseEntity_jpa.UserEntity;
import com.cb.mapper.LoginMapper;
import com.cb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public ResultData<UserEntity> login(String userName, String userPassword) {
        UserEntity user = loginMapper.login(userName, userPassword);
        if (user !=null ){
            return  ResultData.success(user);
        }
        else{
            return  new ResultData(500,null,"账号不存在或者密码错误！");
        }
    }
}
