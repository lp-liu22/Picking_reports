package com.cb.entity.dataBaseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * 设备数据
 */
@Data
@Entity // JPA标记为实体类
@Table(name="device_data") // 指定表名
public class DeviceDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;//设备id
    @Column(columnDefinition = "CHAR(36)", nullable = false, unique = true)
    private String deviceCode;//设备编码
    @Column(nullable = false)
    private Long childId;//对应二级分类id
    @Column(nullable = false)
    private Long parentId;//对应父级分类id
    @Column(length = 50)
    private String deviceName;//设备名称
    @Column(length = 300)
    private String deviceDescription;//设备描述
    @Column
    private String deviceManufacturer;//设备生产厂商
    @Column
    private String deviceModel;//设备型号
    @Column(length = 1,columnDefinition = "CHAR(1)")
    private char deviceStatus;//设备使用状态：0未启用，1启用，2删除
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date typeCreateTime;//设备录入时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date typeUpdateTime;//设备修改时间
    @Column(length = 50)
    private String deviceCreateUser;//设备创建人
}
