package com.cb.common.commonEntity;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页查询结果类
 * 用于封装分页查询后的结果（数据列表、总条数、总页数等）
 *
 */
@Data
public class PageResult<T> implements Serializable {
    //分页查询结果
    private List<T> data;
    //总条数
    private int total;
    //页码
    private int  pageNum;
    //每页条数
    private int  pageSize;
    //总页数
    private int totalPageNum;
    //是否有下一页
    private boolean isHaveNextPage;
    //是否有上一页
    private boolean isHavePreviousPage;

    public static <T>  PageResult<T> handleSearchData(List<T> data,int total,int pageNum,int pageSize){
        PageResult<T> result = new PageResult<>();
        result.setData(data!=null?data: Collections.emptyList());
        result.setTotal(total>0 ?total:0);
        result.setPageNum(pageNum >0?pageNum:0);
        result.setPageSize(pageSize>0?pageSize:0);
        // 计算总页数
        if (total > 0 && pageSize > 0) {
            result.setTotalPageNum((int) (total + pageSize - 1) / pageSize);
        } else {
            result.setTotalPageNum(0);
        }
        result.setHaveNextPage(pageNum < result.getTotalPageNum());
        result.setHavePreviousPage(pageNum>1);
        return  result;
    }
}
