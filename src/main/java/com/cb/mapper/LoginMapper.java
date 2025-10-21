package com.cb.mapper;

import com.cb.entity.dataBaseEntity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    UserEntity login(String userName,String password);
}
