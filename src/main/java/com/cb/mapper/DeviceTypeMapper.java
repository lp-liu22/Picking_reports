package com.cb.mapper;

import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceTypeMapper {
    public Integer insertNewDeviceType(DeviceTypeEntity deviceTypeEntity);
}
