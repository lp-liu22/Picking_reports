package com.cb.entity;

import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 用于设备分类查询结果展示
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceQueryParam {
    private Long id;//设备类型id
    private Long parentId;//若存在二级分类，使用该id表示父级
    private String deviceTypeName;//设备类型名称
    private String deviceDescription;//设备类型描述
    private char deviceStatus;//设备类型使用状态：0未启用，1启用，2删除
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date typeCreateTime;//设备类型创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date typeUpdateTime;//设备类型更新时间
    private String deviceCreateUser;//设备类型创建人
    private List<DeviceTypeEntity> children;
    public static DeviceQueryParam init(DeviceTypeEntity deviceTypeEntity,List<DeviceTypeEntity> children){
        DeviceQueryParam result = new DeviceQueryParam();
        result.setId(deviceTypeEntity.getId());
        result.setParentId(deviceTypeEntity.getParentId());
        result.setDeviceTypeName(deviceTypeEntity.getDeviceTypeName());
        result.setDeviceDescription(deviceTypeEntity.getDeviceDescription());
        result.setDeviceStatus(deviceTypeEntity.getDeviceStatus());
        result.setTypeCreateTime(deviceTypeEntity.getTypeCreateTime());
        result.setTypeUpdateTime(deviceTypeEntity.getTypeUpdateTime());
        result.setDeviceCreateUser(deviceTypeEntity.getDeviceCreateUser());
        result.setChildren(children);
        return result;
    }
}
