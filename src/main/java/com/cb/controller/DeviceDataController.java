package com.cb.controller;

import com.cb.common.annotation.SysOperationLog;
import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.commonEntity.ResultData;
import com.cb.entity.DeviceDataParam;
import com.cb.entity.dataBaseEntity.DeviceDataEntity;
import com.cb.service.DeviceManageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "设备管理",description = "基本接口")
@RestController
@RequestMapping("deviceManage")
public class DeviceDataController {
    @Autowired
    private DeviceManageService manageService;
    @Operation(summary = "设备新增")
    @PostMapping("/add")
    @SysOperationLog(module="设备管理",operationType = "设备新增",description = "新增设备")
    public ResultData<?> addNewType(@RequestBody DeviceDataEntity deviceDataEntity){
        Integer result = manageService.insertDeviceData(deviceDataEntity);
        if(result < 1){
            return new ResultData(406,null,"设备新增失败！");
        }
        return ResultData.success();
    }
    @Operation(summary = "设备条件查询")
    @PostMapping("/searchByCondition")
    @SysOperationLog(module="设备管理",operationType = "设备查询",description = "设备查询")
    public ResultData<PageResult<DeviceDataEntity>> searchByCondition(@RequestBody PageQuery<DeviceDataParam> deviceTypeParamPageQuery){
        return  ResultData.success(manageService.searchByConditions(deviceTypeParamPageQuery));
    }
}
