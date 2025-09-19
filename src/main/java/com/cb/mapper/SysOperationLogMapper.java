package com.cb.mapper;

import com.cb.entity.dataBaseEntity.OperationLogEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysOperationLogMapper {
    //日志插入
    int insert(OperationLogEntity operationLogEntity);
}
