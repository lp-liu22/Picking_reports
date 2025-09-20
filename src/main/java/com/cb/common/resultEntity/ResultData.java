package com.cb.common.resultEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> implements Serializable {
    private int code;
    private  T data;
    private String msg;
    public static <T> ResultData<T> success(){
        return new ResultData<T>(200,null,"操作成功！");
    }
    public static <T> ResultData<T> success(T data){
        return new ResultData<T>(200,data,"操作成功！");
    }
    public static <T> ResultData<T> failed(){
        return new ResultData<T>(401,null,"操作失败！");
    }
    public static <T> ResultData<T> failed(T data){
        return new ResultData<T>(401,data,"操作失败！");
    }

    public static <T> ResultData<T> error(){
        return new ResultData<T>(500,null,"操作异常");
    }
    public static <T> ResultData<T> error(T data){
        return new ResultData<T>(500,data,"操作异常");
    }
}
