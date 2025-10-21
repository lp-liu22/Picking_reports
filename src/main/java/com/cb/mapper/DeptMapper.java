package com.cb.mapper;

import com.cb.entity.dataBaseEntity.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    public List<DeptEntity> getAllDept();
}
