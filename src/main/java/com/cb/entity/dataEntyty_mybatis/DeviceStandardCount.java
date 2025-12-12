package com.cb.entity.dataEntyty_mybatis;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName device_standard_count
 */
@TableName(value ="device_standard_count")
@Data
public class DeviceStandardCount {
    /**
     * 设备标准ID
     */
    @TableId(value = "STANDARD_ID")
    private Integer standardId;

    /**
     * 设备ID
     */
    @TableId(value = "ID")
    private Integer id;

    /**
     * 设备标准数量
     */
    @TableField(value = "STANDARD_COUNT")
    private Integer standardCount;

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
        DeviceStandardCount other = (DeviceStandardCount) that;
        return (this.getStandardId() == null ? other.getStandardId() == null : this.getStandardId().equals(other.getStandardId()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStandardCount() == null ? other.getStandardCount() == null : this.getStandardCount().equals(other.getStandardCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStandardId() == null) ? 0 : getStandardId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStandardCount() == null) ? 0 : getStandardCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", standardId=").append(standardId);
        sb.append(", id=").append(id);
        sb.append(", standardCount=").append(standardCount);
        sb.append("]");
        return sb.toString();
    }
}