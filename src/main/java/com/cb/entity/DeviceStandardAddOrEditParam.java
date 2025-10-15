package com.cb.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class DeviceStandardAddOrEditParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;//设备标准id
    private String standardName;//设备标准名称
    private String standardDescription;//设备标准描述
    private String createUser;//设备标准创建人
    private List<DeviceStandardCountAddParam> standardDeviceData;//设备标准中添加的设备
}
