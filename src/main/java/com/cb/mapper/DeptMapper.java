package com.cb.mapper;

import com.cb.entity.dataBaseEntity.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    //获取所有部门
    public List<DeptEntity> getAllDept();
}
