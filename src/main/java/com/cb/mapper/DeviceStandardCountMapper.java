package com.cb.mapper;

import com.cb.entity.DeviceStandardCountAddParam;
import com.cb.entity.DeviceStandardCountVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeviceStandardCountMapper {

    // 插入标准设备
    Integer insertDeviceOfStandard(@Param("list") List<DeviceStandardCountAddParam> param, @Param("standardId") Long standardId);

    // 查询标准设备
    List<DeviceStandardCountVo> selectDeviceOfStandard(Long standardId);

    // 删除标准设备
    Integer deleteDeviceOfStandard(Long standardId);

}
