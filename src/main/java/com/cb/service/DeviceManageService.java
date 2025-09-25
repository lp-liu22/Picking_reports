package com.cb.service;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.entity.DeviceDataParam;
import com.cb.entity.dataBaseEntity.DeviceDataEntity;

public interface DeviceManageService {
    Integer insertDeviceData(DeviceDataEntity entity);
    PageResult<DeviceDataEntity> searchByConditions(PageQuery<DeviceDataParam> pageQuery);
}
