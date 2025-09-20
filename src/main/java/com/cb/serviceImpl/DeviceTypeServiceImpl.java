package com.cb.serviceImpl;

import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import com.cb.mapper.DeviceTypeMapper;
import com.cb.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;
    @Override
    public int insertNewDeviceType(DeviceTypeEntity typeEntity) {
        return deviceTypeMapper.insertNewDeviceType(typeEntity);
    }
}
