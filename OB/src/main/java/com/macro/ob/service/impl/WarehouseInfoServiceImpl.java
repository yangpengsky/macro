package com.macro.ob.service.impl;


import com.github.pagehelper.PageHelper;
import com.macro.ob.pojo.Page;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Service;

import java.util.Map;

import javax.annotation.Resource;
import java.util.List;

/**
* @author HP
* @description 针对表【warehouse_info(仓库信息表)】的数据库操作Service实现
* @createDate 2022-09-02 15:33:51
*/
@Service
public class WarehouseInfoServiceImpl implements WarehouseInfoService{
    /**
     * 创建warehouseInfo对象
l     */
    @Resource
    private WarehouseInfoMapper warehouse;
    /**
     * 按照条件查询仓库信息
     */
    public Map<String,Object> selectByCondition(WarehouseInfo wi, Page page){
        Map<String,Object> map = new ManagedMap<>();
        /** 分页查询*/
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<WarehouseInfo> warehouseInfos = warehouse.selectByCondition(wi);
        if(warehouseInfos != null ){
            map.put("message","查询成功");
        }else
        {
            map.put("message","查询失败");
        }
        map.put("info",warehouseInfos);
        return map;
    }
}
