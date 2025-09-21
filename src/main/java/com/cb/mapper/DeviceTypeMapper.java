package com.cb.mapper;

import com.cb.common.commonEntity.PageQuery;
import com.cb.entity.DeviceTypeParam;
import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceTypeMapper {
    public Integer insertNewDeviceType(DeviceTypeEntity deviceTypeEntity);
    public List<DeviceTypeEntity> searchTypeByCondition(PageQuery<DeviceTypeParam> pageQuery);
    public Integer searchTypeByConditionCount(PageQuery<DeviceTypeParam> pageQuery);
}
