package com.cb.serviceImpl;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.util.CustomizeStringUtils;
import com.cb.entity.DeviceStandardAddOrEditParam;
import com.cb.entity.DeviceStandardCountVo;
import com.cb.entity.DeviceStandardQueryParam;
import com.cb.entity.dataBaseEntity_jpa.DeviceStandardEntity;
import com.cb.mapper.DeviceStandardCountMapper;
import com.cb.mapper.DeviceStandardMapper;
import com.cb.service.DeviceStandardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceStandardServiceImpl implements DeviceStandardService {

    @Resource
    private DeviceStandardMapper standardMapper;

    @Resource
    private DeviceStandardCountMapper countMapper;

    @Override
    public Integer insertDeviceStandard(DeviceStandardAddOrEditParam entity) {
        // 插入标准信息
        Integer result = standardMapper.insertDeviceStandard(entity);
        if (result < 1) {
            return result;
        }
        // 删除标准中的设备
        countMapper.deleteDeviceOfStandard(entity.getId());
        // 插入标准中的设备
        return countMapper.insertDeviceOfStandard(entity.getStandardDeviceData(), entity.getId());
    }

    @Override
    public Integer updateDeviceStandard(DeviceStandardAddOrEditParam entity) {
        // 修改标准信息
        Integer result = standardMapper.updateDeviceStandard(entity);
        if (result < 1) {
            return result;
        }
        // 删除标准中的设备
        countMapper.deleteDeviceOfStandard(entity.getId());
        // 插入标准中的设备
        return countMapper.insertDeviceOfStandard(entity.getStandardDeviceData(), entity.getId());
    }

    @Override
    public PageResult<DeviceStandardEntity> searchByConditions(PageQuery<DeviceStandardQueryParam> queryParam) {
        DeviceStandardQueryParam param = queryParam.getQueryParam();
        queryParam.getQueryParam().setCreateUser(CustomizeStringUtils.escapeMysqlLikeChar(param.getCreateUser(),'#'));
        queryParam.getQueryParam().setStandardName(CustomizeStringUtils.escapeMysqlLikeChar(param.getStandardName(),'#'));
        List<DeviceStandardEntity> data = standardMapper.searchByConditions(queryParam);
        Integer total = standardMapper.searchByConditionsCount(queryParam);
        return PageResult.handleSearchData(data, total, queryParam.getPageNum(), queryParam.getValidPageSize());
    }

    @Override
    public Integer deleteDeviceStandard(Long id) {
        return standardMapper.deleteDeviceStandard(id);
    }

    @Override
    public List<DeviceStandardCountVo> searchDeviceOfStandard(Long id) {
        return countMapper.selectDeviceOfStandard(id);
    }

}
