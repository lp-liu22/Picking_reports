package com.cb.serviceImpl;

import com.cb.common.commonEntity.PageQuery;
import com.cb.common.commonEntity.PageResult;
import com.cb.common.util.CustomizeStringUtils;
import com.cb.entity.DeviceQueryParam;
import com.cb.entity.DeviceTypeParam;
import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import com.cb.mapper.DeviceTypeMapper;
import com.cb.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;
    @Override
    public int insertNewDeviceType(DeviceTypeEntity typeEntity) {
        return deviceTypeMapper.insertNewDeviceType(typeEntity);
    }

    @Override
    public PageResult<DeviceQueryParam> searchTypeByCondition(PageQuery<DeviceTypeParam> pageQuery) {
        //转义特殊字符
        DeviceTypeParam param = pageQuery.getQueryParam();
        param.setDeviceTypeName(CustomizeStringUtils.escapeMysqlLikeChar(param.getDeviceTypeName(), '#'));
        param.setDeviceCreateUser(CustomizeStringUtils.escapeMysqlLikeChar(param.getDeviceCreateUser(), '#'));
        pageQuery.setQueryParam(param);
        pageQuery.setPageNum(1);
        pageQuery.setPageSize(pageQuery.MAX_PAGE_SIZE);//一次性查询所有分类，分页查询容易出问题
        //将结果转换成前端想要的形式
        List<DeviceTypeEntity> data =  deviceTypeMapper.searchTypeByCondition(pageQuery);
        List<DeviceQueryParam>  deviceQueryParams= new ArrayList<>();
        //将查询的数据按照parent_id分组
        if(data != null) {
            Map<Long, List<DeviceTypeEntity>> childrenByParentId = data.stream().filter(item -> item.getParentId() != null && item.getParentId() != 0).collect(Collectors.groupingBy(DeviceTypeEntity::getParentId));
            //
            deviceQueryParams = data.stream().
                    filter(item -> item.getParentId() == null || item.getParentId() == 0) //先筛选出所有父类
                    .map(item -> DeviceQueryParam.init(item, childrenByParentId.get(item.getId()) != null ? childrenByParentId.get(item.getId()) : Collections.emptyList()))//组合
                    .collect(Collectors.toList());
            for (int i = 0; i < deviceQueryParams.size(); i++) {
                //去除子类为空并且父类不满足查询条件的
                if((pageQuery.getQueryParam().getDeviceTypeName() !=null && !pageQuery.getQueryParam().getDeviceTypeName().equals("") && deviceQueryParams.get(i).getDeviceTypeName().contains(pageQuery.getQueryParam().getDeviceTypeName()) ) ||
                         pageQuery.getQueryParam().getDeviceCreateUser() !=null && !pageQuery.getQueryParam().getDeviceCreateUser().equals("")&&(deviceQueryParams.get(i).getDeviceCreateUser().contains(pageQuery.getQueryParam().getDeviceCreateUser()))
                ){
                    continue;
                }
                if(deviceQueryParams.get(i).getChildren().size() == 0
                ){
                    deviceQueryParams.remove(i);
                    i-=1;
                }
            }
        }
        Integer total = deviceTypeMapper.searchTypeByConditionCount(pageQuery);
        return PageResult.handleSearchData(deviceQueryParams,total, pageQuery.getPageNum(), pageQuery.getValidPageSize());
    }
}
