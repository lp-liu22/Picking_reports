package com.cb.mapper;

import com.cb.common.commonEntity.PageQuery;
import com.cb.entity.DeviceTypeParam;
import com.cb.entity.dataBaseEntity.DeviceTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceTypeMapper {
    Integer insertNewDeviceType(DeviceTypeEntity deviceTypeEntity);
    List<DeviceTypeEntity> searchTypeByCondition(PageQuery<DeviceTypeParam> pageQuery);
    Integer searchTypeByConditionCount(PageQuery<DeviceTypeParam> pageQuery);
    //查询类名是否已存在或查找一级分类下是否有子分类
    Integer selectTypeNameCount(String deviceTypeName);
    //批量删除分类
    Integer batchDeleteTypeByIdList(List<Long> ids);
    Integer updateTypeById(DeviceTypeParam entity);
    //查询所有一级分类
    List<DeviceTypeEntity> selectAllParentType();
    //查询所有二级分类
    List<DeviceTypeEntity> selectAllChildType();
}
