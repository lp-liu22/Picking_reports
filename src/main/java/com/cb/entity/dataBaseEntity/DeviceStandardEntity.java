package com.cb.entity.dataBaseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 设备标准
 */
@Data
@Entity // JPA标记为实体类
@Table(name="device_standard") // 指定表名
public class DeviceStandardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;//设备标准id
    @Column(length = 100)
    private String standardName;//设备标准名称
    @Column(length = 500)
    private String standardDescription;//设备标准描述
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//设备标准创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//设备标准修改时间
    @Column(length = 100)
    private String createUser;//设备标准创建人
}
