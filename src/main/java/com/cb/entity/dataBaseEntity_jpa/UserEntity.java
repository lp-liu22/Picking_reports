package com.cb.entity.dataBaseEntity_jpa;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户表
 */
@Data
@Entity
@Table(name = "sys_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;//用户id
    @Column(unique = true,nullable = false)
    private String userName;//用户名，唯一
    @Column
    private String personName;//中文名
    @JsonIgnore
    @Column(length = 50,nullable = false)
    private String userPassword;//用户密码
    @Column(length = 13)
    private String phoneNumber;//联系电话
    @Column(length = 1,columnDefinition = "CHAR(1)")
    private char status;//用户账号状态：0未启用，1启用，2删除
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(columnDefinition = "datetime")
    private Date createTime;//用户创建时间
//    @Column(length = 1,columnDefinition = "CHAR(1)")
//    @Comment("1:超级管理员（所有权限）,2:审核员（审核、查看权限）,3:填报员（填报、查看权限）,4：普通人员（只有查看权限）")
//    private char authority;//1:超级管理员（所有权限）,2:审核员（审核、查看权限）,3:填报员（填报、查看权限）,4：普通人员（只有查看权限）
}
