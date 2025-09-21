package com.cb.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

/**
 * 用于设备分类查询
 */
@Data
public class DeviceTypeParam {
    private Long parentId;
    private String deviceTypeName;
    private String deviceDescription;//设备类型描述
    private char deviceStatus;//设备类型使用状态：0未启用，1启用，2删除
    private Date beginTime;//设备类型创建开始时间
    private Date endTime;//设备类型创建结束时间
    private String deviceCreateUser;//设备类型创建人
}
