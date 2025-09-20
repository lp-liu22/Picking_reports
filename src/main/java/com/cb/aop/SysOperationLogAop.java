package com.cb.aop;

import com.cb.common.annotation.SysOperationLog;
import com.cb.entity.dataBaseEntity.OperationLogEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cb.service.SysOperationLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 日志AOP配置
 */
@Aspect
@Component
public class SysOperationLogAop {
    @Autowired
    private SysOperationLogService sysOperationLogService;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 拦截带@SysOperatinLog注解的方法
     */
    @Pointcut("@annotation(com.cb.common.annotation.SysOperationLog)")
    public void logPointCut(){}
    /**
     * 环绕通知
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws  Throwable{
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executeTime = System.currentTimeMillis() - startTime;
        saveSysOperationLog(joinPoint,executeTime,result,null);
        return result;
    }

    /**
     * 异常通知：记录方法执行异常信息
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        try {
            saveSysOperationLog(joinPoint, 0L, null, e); // 保存异常日志
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * 保存日志到数据库
     */
    private void saveSysOperationLog(JoinPoint joinPoint, long executeTime, Object result, Exception e) throws JsonProcessingException {
        //获取方法上@SysOperatinLog注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //获取注解中的操作模块、操作类型、描述
        SysOperationLog sysOperationLog = method.getAnnotation(SysOperationLog.class);
        OperationLogEntity log = new OperationLogEntity();
        if(sysOperationLog !=null){
            log.setModule(sysOperationLog.module());
            log.setOperationType(sysOperationLog.operationType());
            log.setDescription(sysOperationLog.description());
        }
        // 获取HTTP请求信息：URL、请求方式、IP
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            String userName = "匿名用户";
            HttpServletRequest request = attributes.getRequest();
            if(request.getHeader("user_name")!=null){
                userName = request.getHeader("user_name");
            }
            log.setUsername(userName);
            log.setRequestUrl(request.getRequestURI());
            log.setRequestMethod(request.getMethod());
            log.setIpAddress(getIpAddress(request)); // 获取IP地址
        }
        //获取被环绕的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取调用方法
        String methodName= signature.getName();
        log.setExecuteMethod(className+"."+methodName);
        //请求参数允许记录则将请求参数转序列化为json
        boolean recordParamsFlag =  sysOperationLog.paramsFlag();
        if(recordParamsFlag){
            Object[] args = joinPoint.getArgs();
            try {
                log.setRequestParams(objectMapper.writeValueAsString(args));
            }catch (Exception ex){
                log.setRequestParams("参数解析失败！");
            }
        }
        //记录响应结果,若结果允许记录标志为真则记录
        boolean recordResultFlag = sysOperationLog.resultFlag();
        if( recordResultFlag && result != null){
            try{
                log.setResponseResult(objectMapper.writeValueAsString(result));
            }catch (Exception ex){
                log.setResponseResult("相应结果解析失败！");
            }
        }
        log.setExecuteTime(executeTime);
        // 无异常则状态为true
        log.setStatus(e == null);
        if (e != null) {
            log.setExceptionMsg(e.getMessage()); // 记录异常信息
        }
        sysOperationLogService.saveOperationLog(log);
    }
    /**
     * 获取客户端真实IP地址（兼容代理）
     */
    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 处理多代理情况，取第一个IP
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }
}

