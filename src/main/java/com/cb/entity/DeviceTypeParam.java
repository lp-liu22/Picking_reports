package com.cb.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

/**
 * 用于设备分类的查询、删除、修改
 */
@Data
public class DeviceTypeParam {
    private Long id;
    private Long parentId;
    private Long oldParentId;
    private String oldDeviceTypeName;
    private String deviceTypeName;
    private String deviceDescription;//设备类型描述
    private char deviceStatus;//设备类型使用状态：0未启用，1启用，2删除
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;//设备类型创建开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;//设备类型创建结束时间
    private String deviceCreateUser;//设备类型创建人

}
