package com.cb.common.annotation;

import java.lang.annotation.*;

/**
 * 系统操作日志注解，@SysOperationLog
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysOperationLog {
    /**
     * 操作模块
     */
    String module() default "";

    /**
     * 操作类型
     */
    String operationType() default "";

    /**
     * 操作描述
     */
    String description() default "";
    /**
     * 是否记录请求参数
     *
     * @return 是否记录请求参数
     */
    boolean paramsFlag() default true;

    /**
     * 是否记录响应结果
     * <br/>
     * 响应结果默认不记录，避免日志过大
     * @return 是否记录响应结果
     */
    boolean resultFlag() default false;
}
