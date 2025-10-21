package com.cb.entity.dataBaseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户-部门-权限表
 * 主要记录部门下的用户以及部门下每个用户的权限
 */
@Entity
@Data
@Table(name = "sys_user_dept",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"deptId", "userId"}, // 需要联合唯一的字段名（数据库列名）,若爆红不用管，只是建表用
                        name = "uniqueFieldOfId" // 约束名称（可选，便于识别）
                )
        }
)
public class DeptUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;
    private Long deptId;//部门id
    private Long userId;//用户id
    @Column(length = 1,columnDefinition = "CHAR(1)")
    @Comment("1:超级管理员（所有权限）,2:审核员（审核、查看权限）,3:填报员（填报、查看权限）,4：普通人员（只有查看权限）")
    private char authority;//1:超级管理员（所有权限）,2:审核员（审核、查看权限）,3:填报员（填报、查看权限）,4：普通人员（只有查看权限）
    @Column(columnDefinition = "datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date joinTime;//入部时间
}
