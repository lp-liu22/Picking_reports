package com.cb.service;

import com.cb.entity.dataBaseEntity.OperationLogEntity;
import com.cb.mapper.SysOperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysOperationLogService {
    @Autowired
    private SysOperationLogMapper sysOperationLogMapper;
    /**
     * 保存日志
     */
    public void saveOperationLog(OperationLogEntity operationLogEntity){
        sysOperationLogMapper.insert(operationLogEntity);
    }

}
