package com.cb.service;


import com.alibaba.fastjson.JSONObject;
import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.entity.DeviceQueryParam;
import com.cb.entity.DeviceTypeParam;
import com.cb.entity.dataBaseEntity.DeviceTypeEntity;

import java.util.List;

/**
 * 设备类型管理
 */
public interface DeviceTypeService {
    int insertNewDeviceType(DeviceTypeEntity typeEntity);
    PageResult<DeviceQueryParam> searchTypeByCondition(PageQuery<DeviceTypeParam> pageQuery);
    List<JSONObject> getAllParentType();
}
