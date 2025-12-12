package com.cb.entity.dataEntyty_mybatis;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName device_data
 */
@TableName(value ="device_data")
@Data
public class DeviceData {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField(value = "child_id")
    private Long childId;

    /**
     * 
     */
    @TableField(value = "device_code")
    private String deviceCode;

    /**
     * 
     */
    @TableField(value = "device_create_user")
    private String deviceCreateUser;

    /**
     * 
     */
    @TableField(value = "device_description")
    private String deviceDescription;

    /**
     * 
     */
    @TableField(value = "device_manufacturer")
    private String deviceManufacturer;

    /**
     * 
     */
    @TableField(value = "device_model")
    private String deviceModel;

    /**
     * 
     */
    @TableField(value = "device_name")
    private String deviceName;

    /**
     * 
     */
    @TableField(value = "device_status")
    private String deviceStatus;

    /**
     * 
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 
     */
    @TableField(value = "type_create_time")
    private Date typeCreateTime;

    /**
     * 
     */
    @TableField(value = "type_update_time")
    private Date typeUpdateTime;

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
        DeviceData other = (DeviceData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChildId() == null ? other.getChildId() == null : this.getChildId().equals(other.getChildId()))
            && (this.getDeviceCode() == null ? other.getDeviceCode() == null : this.getDeviceCode().equals(other.getDeviceCode()))
            && (this.getDeviceCreateUser() == null ? other.getDeviceCreateUser() == null : this.getDeviceCreateUser().equals(other.getDeviceCreateUser()))
            && (this.getDeviceDescription() == null ? other.getDeviceDescription() == null : this.getDeviceDescription().equals(other.getDeviceDescription()))
            && (this.getDeviceManufacturer() == null ? other.getDeviceManufacturer() == null : this.getDeviceManufacturer().equals(other.getDeviceManufacturer()))
            && (this.getDeviceModel() == null ? other.getDeviceModel() == null : this.getDeviceModel().equals(other.getDeviceModel()))
            && (this.getDeviceName() == null ? other.getDeviceName() == null : this.getDeviceName().equals(other.getDeviceName()))
            && (this.getDeviceStatus() == null ? other.getDeviceStatus() == null : this.getDeviceStatus().equals(other.getDeviceStatus()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getTypeCreateTime() == null ? other.getTypeCreateTime() == null : this.getTypeCreateTime().equals(other.getTypeCreateTime()))
            && (this.getTypeUpdateTime() == null ? other.getTypeUpdateTime() == null : this.getTypeUpdateTime().equals(other.getTypeUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChildId() == null) ? 0 : getChildId().hashCode());
        result = prime * result + ((getDeviceCode() == null) ? 0 : getDeviceCode().hashCode());
        result = prime * result + ((getDeviceCreateUser() == null) ? 0 : getDeviceCreateUser().hashCode());
        result = prime * result + ((getDeviceDescription() == null) ? 0 : getDeviceDescription().hashCode());
        result = prime * result + ((getDeviceManufacturer() == null) ? 0 : getDeviceManufacturer().hashCode());
        result = prime * result + ((getDeviceModel() == null) ? 0 : getDeviceModel().hashCode());
        result = prime * result + ((getDeviceName() == null) ? 0 : getDeviceName().hashCode());
        result = prime * result + ((getDeviceStatus() == null) ? 0 : getDeviceStatus().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getTypeCreateTime() == null) ? 0 : getTypeCreateTime().hashCode());
        result = prime * result + ((getTypeUpdateTime() == null) ? 0 : getTypeUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", childId=").append(childId);
        sb.append(", deviceCode=").append(deviceCode);
        sb.append(", deviceCreateUser=").append(deviceCreateUser);
        sb.append(", deviceDescription=").append(deviceDescription);
        sb.append(", deviceManufacturer=").append(deviceManufacturer);
        sb.append(", deviceModel=").append(deviceModel);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", deviceStatus=").append(deviceStatus);
        sb.append(", parentId=").append(parentId);
        sb.append(", typeCreateTime=").append(typeCreateTime);
        sb.append(", typeUpdateTime=").append(typeUpdateTime);
        sb.append("]");
        return sb.toString();
    }
}