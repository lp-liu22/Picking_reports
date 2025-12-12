package com.cb.entity.dataEntyty_mybatis;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName sys_dept
 */
@TableName(value ="sys_dept")
@Data
public class SysDept {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    @TableField(value = "dept_name")
    private String deptName;

    /**
     * 部门子类id
     */
    @TableField(value = "dept_parent_id")
    private Long deptParentId;

    /**
     * 用于判断该部门是否需要每日进行填报：0不需要，1需要
     */
    @TableField(value = "report_flag")
    private String reportFlag;

    /**
     * 部门状态：0未启用，1启用，2废弃
     */
    @TableField(value = "status")
    private String status;

    /**
     * 
     */
    @TableField(value = "type_create_time")
    private Date typeCreateTime;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysDept other = (SysDept) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getDeptParentId() == null ? other.getDeptParentId() == null : this.getDeptParentId().equals(other.getDeptParentId()))
            && (this.getReportFlag() == null ? other.getReportFlag() == null : this.getReportFlag().equals(other.getReportFlag()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTypeCreateTime() == null ? other.getTypeCreateTime() == null : this.getTypeCreateTime().equals(other.getTypeCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getDeptParentId() == null) ? 0 : getDeptParentId().hashCode());
        result = prime * result + ((getReportFlag() == null) ? 0 : getReportFlag().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTypeCreateTime() == null) ? 0 : getTypeCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deptName=").append(deptName);
        sb.append(", deptParentId=").append(deptParentId);
        sb.append(", reportFlag=").append(reportFlag);
        sb.append(", status=").append(status);
        sb.append(", typeCreateTime=").append(typeCreateTime);
        sb.append("]");
        return sb.toString();
    }
}