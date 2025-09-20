package com.cb.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

public class DeviceTypeParam {
    private Long parentId;
    private String deviceTypeName;
    private String deviceDescription;//设备类型描述
    private char deviceStatus;//设备类型使用状态：0未启用，1启用，2删除
    private Date operationTime;//设备类型创建时间
    private String deviceCreateUser;//设备类型创建人
}
