package com.cb.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.cb.entity.dataBaseEntity_jpa.DeptEntity;
import com.cb.mapper.DeptMapper;
import com.cb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    /**
     * 查询所有部门树
     * @return
     */
    @Override
    public List<JSONObject> getAllDeptTree() {
        List<JSONObject> result = new ArrayList<>();
        List<DeptEntity> data = deptMapper.getAllDept();
        if(data !=null){
            Map<Long,List<DeptEntity>> childrenDept = data.stream().filter(item->item.getDeptParentId()!=null && item.getDeptParentId() !=0).collect(Collectors.groupingBy(DeptEntity::getDeptParentId));
            for(DeptEntity e :data){
                if(e.getDeptParentId() == null || e.getDeptParentId() ==0){
                    JSONObject temp = new JSONObject();
                    temp.put("id",e.getId());
                    temp.put("deptName",e.getDeptName());
                    temp.put("child",childrenDept.get(e.getId()));
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
