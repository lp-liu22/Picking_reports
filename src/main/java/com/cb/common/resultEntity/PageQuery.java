package com.cb.common.resultEntity;

import lombok.Data;

import java.io.Serializable;

/**
 * 主要用于分页查询条件，不方便不用这个也行
 * @param <T>
 */
@Data
public class PageQuery<T> implements Serializable {
    //默认页码
    public static final int DEFAULT_PAGE_NUM = 1;

    //默认条数
    public static final int DEFAULT_PAGE_SIZE = 10;
    //最大限制查询条数
    public static final int MAX_PAGE_SIZE = 100;
    //页码
    private Integer pageNum = DEFAULT_PAGE_NUM;

    //每页条数
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    //查询条件
    private T queryParam;

    //计算分页偏移量 offset = (pageNum - 1) * pageSize
    public Integer getOffset() {
        // 校验页码和每页条数，避免负数或0
        int validPageNum = Math.max(pageNum, DEFAULT_PAGE_NUM);
        int validPageSize = Math.min(Math.max(pageSize, 1), MAX_PAGE_SIZE);
        return (validPageNum - 1) * validPageSize;
    }
    //获取有效条数
    public Integer getValidPageSize() {
        return Math.min(Math.max(pageSize, 1), MAX_PAGE_SIZE);
    }
}
