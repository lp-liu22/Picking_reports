package com.cb.controller;

import com.cb.common.annotation.SysOperationLog;
import com.cb.common.resultEntity.ResultData;
import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import com.cb.service.DeviceTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "设备类型管理",description = "基本接口")
@RestController
@RequestMapping("device")
public class DeviceTypeController {
    @Autowired
    private DeviceTypeService deviceTypeService;
    @PostMapping("/add")
    @SysOperationLog(module="设备类型管理",operationType = "设备类型新增",description = "新增设备分类")
    public ResultData<?> addNewType(@RequestBody DeviceTypeEntity deviceTypeEntity){
        return deviceTypeService.insertNewDeviceType(deviceTypeEntity) > 0 ?ResultData.success():ResultData.error();
    }

}
