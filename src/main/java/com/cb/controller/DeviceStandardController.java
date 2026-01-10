package com.cb.controller;

import com.cb.common.annotation.SysOperationLog;
import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.commonEntity.ResultData;
import com.cb.entity.DeviceStandardAddOrEditParam;
import com.cb.entity.DeviceStandardCountVo;
import com.cb.entity.DeviceStandardQueryParam;
import com.cb.entity.dataBaseEntity_jpa.DeviceStandardEntity;
import com.cb.service.DeviceStandardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "设备标准",description = "基本接口")
@RestController
@RequestMapping("deviceStandard")
public class DeviceStandardController {

    @Autowired
    private DeviceStandardService standardService;

    /**
     * 设备标准新增
     * @param param
     * @return
     */
    @Operation(summary = "设备标准新增")
    @PostMapping("/addStandard")
    @SysOperationLog(module="设备标准",operationType = "标准新增",description = "新增标准")
    public ResultData<?> addDeviceStandard(@RequestBody DeviceStandardAddOrEditParam param){
        Integer result = standardService.insertDeviceStandard(param);
        if(result < 1){
            return new ResultData(406,null,"标准新增失败！");
        }
        return ResultData.success();
    }
    /**
     * 设备标准修改
     * @param param
     * @return
     */
    @Operation(summary = "设备标准修改")
    @PostMapping("/editStandard")
    @SysOperationLog(module="设备标准",operationType = "标准修改",description = "修改标准")
    public ResultData<?> editDeviceStandard(@RequestBody DeviceStandardAddOrEditParam param){
        Integer result = standardService.updateDeviceStandard(param);
        if(result < 1){
            return new ResultData(406,null,"标准编辑失败！");
        }
        return ResultData.success();
    }
    /**
     * 设备标准条件查询
     * @param queryParam
     * @return
     */
    @Operation(summary = "设备标准条件查询")
    @PostMapping("/searchByCondition")
    @SysOperationLog(module="设备标准",operationType = "标准查询",description = "标准查询")
    public ResultData<PageResult<DeviceStandardEntity>> searchByCondition(@RequestBody PageQuery<DeviceStandardQueryParam> queryParam){
        return  ResultData.success(standardService.searchByConditions(queryParam));
    }
    /**
     * 设备标准删除
     * @param id
     * @return
     */
    @Operation(summary = "设备标准删除")
    @PostMapping("/deleteStandard")
    @SysOperationLog(module="设备标准",operationType = "标准删除",description = "标准删除")
    public ResultData deleteDeviceStandard(@RequestBody Long id){
        Integer result = standardService.deleteDeviceStandard(id);
        if(result < 1){
            return new ResultData(406,null,"标准删除失败！");
        }
        return ResultData.success();
    }
    /**
     * 获取设备标准中的设备
     * @param id
     * @return
     */
    @Operation(summary = "获取设备标准中的设备")
    @PostMapping("/getStandardDevice")
    @SysOperationLog(module="设备标准",operationType = "标准设备查询",description = "标准设备查询")
    public ResultData<List<DeviceStandardCountVo>> getStandardDevice(@RequestBody Long id){
        return ResultData.success(standardService.searchDeviceOfStandard(id));
    }

}
