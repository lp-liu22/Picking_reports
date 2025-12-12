package com.cb.service;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.entity.DeviceStandardAddOrEditParam;
import com.cb.entity.DeviceStandardCountVo;
import com.cb.entity.DeviceStandardQueryParam;
import com.cb.entity.dataBaseEntity_jpa.DeviceStandardEntity;

import java.util.List;

public interface DeviceStandardService {

    // 新增设备标准
    Integer insertDeviceStandard(DeviceStandardAddOrEditParam entity);

    // 编辑设备标准
    Integer updateDeviceStandard(DeviceStandardAddOrEditParam entity);

    // 查询设备标准
    PageResult<DeviceStandardEntity> searchByConditions(PageQuery<DeviceStandardQueryParam> queryParam);

    // 删除设备标准
    Integer deleteDeviceStandard(Long id);

    // 获取标准中的设备
    List<DeviceStandardCountVo> searchDeviceOfStandard(Long id);

}
