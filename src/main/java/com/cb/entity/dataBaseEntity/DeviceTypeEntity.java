package com.cb.entity.dataBaseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity // JPA标记为实体类
@Table(name="device_type") // 指定表名
public class DeviceTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;//设备类型id
    @Column
    private Long parentId;//若存在二级分类，使用该id表示父级
    @Column(length = 50,nullable = false)
    private String deviceTypeName;//设备类型名称
    @Column(length = 300)
    private String deviceDescription;//设备类型描述
    @Column(length = 1,columnDefinition = "CHAR(1)")
    private char deviceStatus;//设备类型使用状态：0未启用，1启用，2删除
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date typeCreateTime;//设备类型创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date typeUpdateTime;//设备类型创建时间
    @Column(length = 50)
    private String deviceCreateUser;//设备类型创建人
}
