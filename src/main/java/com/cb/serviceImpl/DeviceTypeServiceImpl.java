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
import com.alibaba.fastjson.JSONObject;
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
        int nameCount = deviceTypeMapper.selectTypeNameCount(typeEntity.getDeviceTypeName());
        if(nameCount >0){
            return -1;
        }
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
        }
        Integer total = deviceTypeMapper.searchTypeByConditionCount(pageQuery);//满足查询条件数量和最终查询数据条数存在较小差异
        return PageResult.handleSearchData(deviceQueryParams,total, pageQuery.getPageNum(), pageQuery.getValidPageSize());
    }

    @Override
    public List<JSONObject> getAllParentType() {
        List<DeviceTypeEntity> data = deviceTypeMapper.selectAllParentType();
        List<JSONObject> result = new ArrayList<>();
        for (DeviceTypeEntity datum : data) {
            JSONObject item = new JSONObject();
            item.put("id",datum.getId());
            item.put("label",datum.getDeviceTypeName());
            result.add(item);
        }
        return result;
    }

    @Override
    public List<JSONObject> getAllType() {
        List<DeviceTypeEntity> childData = deviceTypeMapper.selectAllChildType();
        List<DeviceTypeEntity> parentData = deviceTypeMapper.selectAllParentType();
        List<JSONObject> result = new ArrayList<>();
        Map<Long,List<DeviceTypeEntity>> tempMap = childData.stream().collect(Collectors.groupingBy(DeviceTypeEntity::getParentId));
        for (DeviceTypeEntity parentDatum : parentData) {
            JSONObject temp = new JSONObject();
            temp.put("value",parentDatum.getId());
            temp.put("label",parentDatum.getDeviceTypeName());
            List<JSONObject> tempJsonObject = new ArrayList<>();
            if(tempMap.get(parentDatum.getId())!=null){
                for (DeviceTypeEntity childDatum : tempMap.get(parentDatum.getId())) {
                    JSONObject temp1 = new JSONObject();
                        temp1.put("value",childDatum.getId());
                        temp1.put("label",childDatum.getDeviceTypeName());
                        tempJsonObject.add(temp1);
                }
                temp.put("children",tempJsonObject);
            }
            if(tempJsonObject.size() >0){
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public Integer deleteDeviceType(DeviceTypeParam param) {
        //删除前需检查分类是否在使用
        /**
         * 逻辑待完善
         */
        List<Long> ids = new ArrayList<>();
        //判断是否是一级分类，若是一级分类删除其下所有子类
        if(param.getParentId()== null || param.getParentId() == 0){
            //查询所有子类并获取子类id列表
            DeviceTypeParam deviceTypeParam = new DeviceTypeParam();
            deviceTypeParam.setParentId(param.getId());
            PageQuery<DeviceTypeParam> pageQuery = new PageQuery<>();
            pageQuery.setPageNum(1);
            pageQuery.setPageSize(pageQuery.MAX_PAGE_SIZE);
            pageQuery.setQueryParam(deviceTypeParam);
            List<DeviceTypeEntity> data =  deviceTypeMapper.searchTypeByCondition(pageQuery);
            if(!data.isEmpty()){
                ids.addAll(data.stream().map(DeviceTypeEntity::getId).collect(Collectors.toList()));
            }
        }
        ids.add(param.getId());
        return deviceTypeMapper.batchDeleteTypeByIdList(ids);
    }

    @Override
    public Integer updateDeviceType(DeviceTypeParam param) {
        int nameCount = deviceTypeMapper.selectTypeNameCount(param.getDeviceTypeName());
        //分类名称不能重复
        if(nameCount >0 && !param.getDeviceTypeName().equals(param.getOldDeviceTypeName())){
            return -2;
        }
        //一级分类不能关联其它一级分类
        if((param.getOldParentId()==null || param.getOldParentId() == 0) && param.getParentId() != param.getOldParentId()){
            return -1;
        }
        return deviceTypeMapper.updateTypeById(param);
    }
}
