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
@RequestMapping("deviceType")
public class DeviceTypeController {
    @Autowired
    private DeviceTypeService deviceTypeService;
    @Operation(summary = "类型新增")
    @PostMapping("/add")
    @SysOperationLog(module="设备类型管理",operationType = "设备类型新增",description = "新增设备分类")
    public ResultData<?> addNewType(@RequestBody DeviceTypeEntity deviceTypeEntity){
        Integer result = deviceTypeService.insertNewDeviceType(deviceTypeEntity);
        if(result == -1){
            return new ResultData(406,null,"分类名称重复！");
        }
        return ResultData.success();
    }
    @Operation(summary = "类型条件查询")
    @PostMapping("/searchByCondition")
    @SysOperationLog(module="设备类型管理",operationType = "设备类型查询",description = "设备类型查询")
    public ResultData<PageResult<DeviceQueryParam>> searchByCondition(@RequestBody PageQuery<DeviceTypeParam> deviceTypeParamPageQuery){
        return  ResultData.success(deviceTypeService.searchTypeByCondition(deviceTypeParamPageQuery));
    }
    @Operation(summary = "查询所有一级分类")
    @SysOperationLog(module="设备类型管理",operationType = "查询设备一级分类",description = "查询所有可用一级分类")
    @GetMapping("/getAllParentType")
    public ResultData<List<JSONObject>> getAllParentType(){
        return ResultData.success(deviceTypeService.getAllParentType());
    }
    @Operation(summary = "查询所有分类")
    @SysOperationLog(module="设备类型管理",operationType = "查询设备所有分类",description = "查询所有可用分类")
    @GetMapping("/getAllType")
    public ResultData<List<JSONObject>> getAllType(){
        return ResultData.success(deviceTypeService.getAllType());
    }
    @Operation(summary = "删除设备分类")
    @SysOperationLog(module="设备类型管理",operationType = "删除设备分类",description = "删除设备分类（逻辑删除）")
    @PostMapping("/deleteDeviceType")
    public ResultData deleteDeviceType(@RequestBody DeviceTypeParam param){
        Integer count = deviceTypeService.deleteDeviceType(param);
        if (count > 0){
            return ResultData.success();
        }
        else{
            return  ResultData.failed();
        }
    }
    @Operation(summary = "修改设备分类")
    @SysOperationLog(module="设备类型管理",operationType = "修改设备分类",description = "修改设备分类")
    @PostMapping("/updateDeviceType")
    public ResultData updateDeviceType(@RequestBody DeviceTypeParam param){
        Integer result = deviceTypeService.updateDeviceType(param);
        if (result == -2){
            return new ResultData(406,null,"分类名称重复！");
        }
        else if(result ==-1){
            return new ResultData(406,null,"一级分类不能做为子分类！！");
        }
        return ResultData.success();
    }

}
