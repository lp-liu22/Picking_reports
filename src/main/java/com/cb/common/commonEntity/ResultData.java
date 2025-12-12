package com.cb.common.commonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回结果类
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> implements Serializable {
    private int code;
    private  T data;
    private String message;
    public static <T> ResultData<T> success(){
        return new ResultData<T>(200,null,"请求成功！");
    }
    public static <T> ResultData<T> success(T data){
        return new ResultData<T>(200,data,"请求成功！");
    }
    public static <T> ResultData<T> failed(){
        return new ResultData<T>(403,null,"请求失败！");
    }
    public static <T> ResultData<T> failed(T data){
        return new ResultData<T>(403,data,"请求失败！");
    }

    public static <T> ResultData<T> error(){
        return new ResultData<T>(500,null,"请求异常");
    }
    public static <T> ResultData<T> error(T data){
        return new ResultData<T>(500,data,"请求异常");
    }
}
