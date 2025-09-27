package com.cb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.UUID;
@Data
public class DeviceDataParam {
    private Long id;//设备id
    private String deviceDescription;//设备描述
    private String deviceCode;//设备编码
    private Long childId;//对应二级分类id
    private Long parentId;//对应父级分类id
    private String deviceName;//设备名称
    private String deviceManufacturer;//设备生产厂商
    private String deviceModel;//设备型号
    private char deviceStatus;//设备使用状态：0未启用，1启用，2删除
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date beginTime;//设备录入时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;//设备修改时间
    private String deviceCreateUser;//设备创建人
}
