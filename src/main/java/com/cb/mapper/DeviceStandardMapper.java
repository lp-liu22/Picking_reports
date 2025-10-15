package com.cb.mapper;

import com.cb.common.commonEntity.PageQuery;
import com.cb.entity.DeviceStandardAddOrEditParam;
import com.cb.entity.DeviceStandardQueryParam;
import com.cb.entity.dataBaseEntity.DeviceStandardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface DeviceStandardMapper {

    // 插入设备标准
//    @Options(useGeneratedKeys = true, keyProperty = "DeviceStandardAddOrEditParam.id")
    Integer insertDeviceStandard(DeviceStandardAddOrEditParam param);

    // 修改设备标准
    Integer updateDeviceStandard(DeviceStandardAddOrEditParam param);

    // 分页查询设备标准
    List<DeviceStandardEntity> searchByConditions(PageQuery<DeviceStandardQueryParam> queryParam);

    // 查询设备标准数量
    Integer searchByConditionsCount(PageQuery<DeviceStandardQueryParam> queryParam);

    // 删除设备标准
    Integer deleteDeviceStandard(Long id);

}
