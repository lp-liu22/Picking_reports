package com.cb.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserDeptAddParam {
    private Long deptId;
    private List<Long> userIds;
    private char authority;
}
