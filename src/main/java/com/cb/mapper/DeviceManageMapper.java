package com.cb.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cb.common.commonEntity.PageQuery;
import com.cb.entity.DeviceDataParam;
import com.cb.entity.DeviceTypeParam;
import com.cb.entity.dataBaseEntity.DeviceDataEntity;
import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceManageMapper {
    Integer insertDeviceData(DeviceDataEntity entity);
    List<DeviceDataEntity> searchByConditions(PageQuery<DeviceDataParam> pageQuery);
    Integer searchByConditionsCount(PageQuery<DeviceDataParam> pageQuery);
}
