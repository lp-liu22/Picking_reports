package com.cb.controller;

import com.cb.common.commonEntity.ResultData;
import com.cb.entity.LoginParam;
import com.cb.entity.dataBaseEntity.UserEntity;
import com.cb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("login")
    public ResultData<UserEntity> login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam.getUserName(), loginParam.getPassword());
    }
}
