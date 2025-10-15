package com.cb.entity;

import lombok.Data;

@Data
public class DeviceStandardCountVo {
    private Long id;//设备ID
    private Long standardCount;//设备标准数量
    private String deviceDescription;//设备描述
    private String deviceCode;//设备编码
    private Long childId;//对应二级分类id
    private Long parentId;//对应父级分类id
    private String deviceName;//设备名称
}
