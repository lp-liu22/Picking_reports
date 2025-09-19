package com.cb.entity.dataBaseEntity;

import lombok.Data;

import java.util.Date;

/**
 * 日志表
 */
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Data
@Entity // JPA标记为实体类
@Table(name = "sys_operation_log") // 指定表名
public class OperationLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private Long id;
    //操作用户
    @Column(length = 75) // 字段长度：50
    private String username;
    //IP地址
    @Column(length = 64) // 支持IPv6
    private String ipAddress;
    //操作模块
    @Column(length = 50)
    private String module;
    //操作类型
    @Column(length = 40)
    private String operationType;
    //操作描述
    @Column(length = 200)
    private String description;
    //请求地址
    @Column(length = 255)
    private String requestUrl;
    //请求方式
    @Column(length = 10)
    private String requestMethod;
    //执行方法
    @Column(length = 255)
    private String executeMethod;
    //请求参数
    @Column(columnDefinition = "text") // 大文本类型
    private String requestParams;
    //请求结果
    @Column(columnDefinition = "text")
    private String responseResult;
    //执行时间
    private Long executeTime;

    @CreationTimestamp // 自动填充当前时间
    private Date operationTime;
    //执行结果
    @Column(columnDefinition = "tinyint(1)") // 布尔值用tinyint存储
    private Boolean status;
    //异常信息
    @Column(columnDefinition = "text")
    private String exceptionMsg;

}
