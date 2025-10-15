package com.cb.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DeviceStandardQueryParam {
    private String standardName;//设备标准ID
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;//设备标准创建时间范围起
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;//设备标准创建时间范围止
    private String createUser;//设备标准创建用户
}
