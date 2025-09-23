package com.cb.controller;

import com.alibaba.fastjson.JSONObject;
import com.cb.common.annotation.SysOperationLog;
import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.commonEntity.ResultData;
import com.cb.entity.DeviceQueryParam;
import com.cb.entity.DeviceTypeParam;
import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import com.cb.service.DeviceTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "设备类型管理",description = "基本接口")
@RestController
@RequestMapping("device")
public class DeviceTypeController {
    @Autowired
    private DeviceTypeService deviceTypeService;
    @Operation(summary = "类型新增")
    @PostMapping("/add")
    @SysOperationLog(module="设备类型管理",operationType = "设备类型新增",description = "新增设备分类")
    public ResultData<?> addNewType(@RequestBody DeviceTypeEntity deviceTypeEntity){
        return deviceTypeService.insertNewDeviceType(deviceTypeEntity) > 0 ?ResultData.success():ResultData.error();
    }
    @Operation(summary = "类型条件查询")
    @PostMapping("/searchByCondition")
    @SysOperationLog(module="设备类型管理",operationType = "设备类型查询",description = "设备类型查询")
    public ResultData<PageResult<DeviceQueryParam>> searchByCondition(@RequestBody PageQuery<DeviceTypeParam> deviceTypeParamPageQuery){
        return  ResultData.success(deviceTypeService.searchTypeByCondition(deviceTypeParamPageQuery));
    }
    @Operation(summary = "查询所有一级分类")
    @SysOperationLog(module="设备类型管理",operationType = "设备一级分类",description = "查询所有可用一级分类")
    @GetMapping("/getAllParentType")
    public ResultData<List<JSONObject>> getAllParentType(){
        return ResultData.success(deviceTypeService.getAllParentType());
    }

}
