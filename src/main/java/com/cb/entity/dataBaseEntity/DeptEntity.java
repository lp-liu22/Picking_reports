package com.cb.entity.dataBaseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "sys_dept")
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;//部门id
    @Column
    @Comment("部门名称")
    private String deptName;//部门名称
    @Column
    @Comment("部门子类id")
    private Long deptParentId;//部门子类id
    @Column(length = 1,columnDefinition = "CHAR(1)")
    @Comment("部门状态：0未启用，1启用，2废弃")
    private char status;//部门状态：0未启用，1启用，2废弃
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(columnDefinition = "datetime")
    private Date typeCreateTime;//部门创建时间
    @Column(length = 1,columnDefinition = "CHAR(1)")
    @Comment("用于判断该部门是否需要每日进行填报：0不需要，1需要")
    private char reportFlag;//用于判断该部门是否需要每日进行填报：0不需要，1需要
}
