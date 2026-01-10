package com.cb.serviceImpl;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.util.CustomizeStringUtils;
import com.cb.entity.DeviceDataParam;
import com.cb.entity.dataBaseEntity_jpa.DeviceDataEntity;
import com.cb.mapper.DeviceManageMapper;
import com.cb.service.DeviceManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceManageServiceImpl implements DeviceManageService {
    @Resource
    private DeviceManageMapper manageMapper;
    /**
     * 新增设备数据
     * @param entity
     * @return
     */
    @Override
    public Integer insertDeviceData(DeviceDataEntity entity) {
        return manageMapper.insertDeviceData(entity);
    }
    /**
     * 设备条件查询
     * @param pageQuery
     * @return
     */
    @Override
    public PageResult<DeviceDataEntity> searchByConditions(PageQuery<DeviceDataParam> pageQuery) {
        DeviceDataParam param = pageQuery.getQueryParam();
        pageQuery.getQueryParam().setDeviceCreateUser(CustomizeStringUtils.escapeMysqlLikeChar(param.getDeviceCreateUser(),'#'));
        pageQuery.getQueryParam().setDeviceModel(CustomizeStringUtils.escapeMysqlLikeChar(param.getDeviceModel(),'#'));
        pageQuery.getQueryParam().setDeviceManufacturer(CustomizeStringUtils.escapeMysqlLikeChar(param.getDeviceManufacturer(),'#'));
        pageQuery.getQueryParam().setDeviceName(CustomizeStringUtils.escapeMysqlLikeChar(param.getDeviceName(),'#'));
        List<DeviceDataEntity> data= manageMapper.searchByConditions(pageQuery);
        Integer total = manageMapper.searchByConditionsCount(pageQuery);
        return PageResult.handleSearchData(data,total, pageQuery.getPageNum(), pageQuery.getValidPageSize());
    }
    /**
     * 根据id删除设备
     * @param id
     * @return
     */
    @Override
    public Integer deleteDeviceData(Long id) {
        return manageMapper.deleteDeviceData(id);
    }
    /**
     * 更新设备数据
     * @param param
     * @return
     */
    @Override
    public Integer updateDeviceData(DeviceDataParam param) {
        return manageMapper.updateDeviceData(param);
    }
}
