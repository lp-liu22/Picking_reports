package com.cb.entity.dataEntyty_mybatis;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName sys_operation_log
 */
@TableName(value ="sys_operation_log")
@Data
public class SysOperationLog {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @TableField(value = "description")
    private String description;

    /**
     * 
     */
    @TableField(value = "exception_msg")
    private String exceptionMsg;

    /**
     * 
     */
    @TableField(value = "execute_method")
    private String executeMethod;

    /**
     * 
     */
    @TableField(value = "execute_time")
    private Long executeTime;

    /**
     * 
     */
    @TableField(value = "ip_address")
    private String ipAddress;

    /**
     * 
     */
    @TableField(value = "module")
    private String module;

    /**
     * 
     */
    @TableField(value = "operation_time")
    private Date operationTime;

    /**
     * 
     */
    @TableField(value = "operation_type")
    private String operationType;

    /**
     * 
     */
    @TableField(value = "request_method")
    private String requestMethod;

    /**
     * 
     */
    @TableField(value = "request_params")
    private String requestParams;

    /**
     * 
     */
    @TableField(value = "request_url")
    private String requestUrl;

    /**
     * 
     */
    @TableField(value = "response_result")
    private String responseResult;

    /**
     * 
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 
     */
    @TableField(value = "username")
    private String username;

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
        SysOperationLog other = (SysOperationLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getExceptionMsg() == null ? other.getExceptionMsg() == null : this.getExceptionMsg().equals(other.getExceptionMsg()))
            && (this.getExecuteMethod() == null ? other.getExecuteMethod() == null : this.getExecuteMethod().equals(other.getExecuteMethod()))
            && (this.getExecuteTime() == null ? other.getExecuteTime() == null : this.getExecuteTime().equals(other.getExecuteTime()))
            && (this.getIpAddress() == null ? other.getIpAddress() == null : this.getIpAddress().equals(other.getIpAddress()))
            && (this.getModule() == null ? other.getModule() == null : this.getModule().equals(other.getModule()))
            && (this.getOperationTime() == null ? other.getOperationTime() == null : this.getOperationTime().equals(other.getOperationTime()))
            && (this.getOperationType() == null ? other.getOperationType() == null : this.getOperationType().equals(other.getOperationType()))
            && (this.getRequestMethod() == null ? other.getRequestMethod() == null : this.getRequestMethod().equals(other.getRequestMethod()))
            && (this.getRequestParams() == null ? other.getRequestParams() == null : this.getRequestParams().equals(other.getRequestParams()))
            && (this.getRequestUrl() == null ? other.getRequestUrl() == null : this.getRequestUrl().equals(other.getRequestUrl()))
            && (this.getResponseResult() == null ? other.getResponseResult() == null : this.getResponseResult().equals(other.getResponseResult()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getExceptionMsg() == null) ? 0 : getExceptionMsg().hashCode());
        result = prime * result + ((getExecuteMethod() == null) ? 0 : getExecuteMethod().hashCode());
        result = prime * result + ((getExecuteTime() == null) ? 0 : getExecuteTime().hashCode());
        result = prime * result + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());
        result = prime * result + ((getModule() == null) ? 0 : getModule().hashCode());
        result = prime * result + ((getOperationTime() == null) ? 0 : getOperationTime().hashCode());
        result = prime * result + ((getOperationType() == null) ? 0 : getOperationType().hashCode());
        result = prime * result + ((getRequestMethod() == null) ? 0 : getRequestMethod().hashCode());
        result = prime * result + ((getRequestParams() == null) ? 0 : getRequestParams().hashCode());
        result = prime * result + ((getRequestUrl() == null) ? 0 : getRequestUrl().hashCode());
        result = prime * result + ((getResponseResult() == null) ? 0 : getResponseResult().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", description=").append(description);
        sb.append(", exceptionMsg=").append(exceptionMsg);
        sb.append(", executeMethod=").append(executeMethod);
        sb.append(", executeTime=").append(executeTime);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", module=").append(module);
        sb.append(", operationTime=").append(operationTime);
        sb.append(", operationType=").append(operationType);
        sb.append(", requestMethod=").append(requestMethod);
        sb.append(", requestParams=").append(requestParams);
        sb.append(", requestUrl=").append(requestUrl);
        sb.append(", responseResult=").append(responseResult);
        sb.append(", status=").append(status);
        sb.append(", username=").append(username);
        sb.append("]");
        return sb.toString();
    }
}