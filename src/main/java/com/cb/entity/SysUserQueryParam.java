package com.cb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import java.util.Date;
@Data
public class SysUserQueryParam {
    private Long id;//用户id
    private String userName;//用户名，唯一
    private String personName;//中文名
    private Long deptId;//部门id
    private char authority;//1:超级管理员（所有权限）,2:审核员（审核、查看权限）,3:填报员（填报、查看权限）,4：普通人员（只有查看权限）
    private String deptName;//部门名称
    private Long deptParentId;//部门子类id
    private Long dept_userOfId;//用户部门表id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date joinTime;//入部时间
}
