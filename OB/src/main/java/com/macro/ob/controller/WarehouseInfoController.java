package com.macro.ob.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.WarehouseInfo;
import com.macro.ob.service.WarehouseInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 仓库信息表的控制层实现
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/warehouseInfo")
public class WarehouseInfoController {
    /**
     * 创建仓库信息业务层对象
     */
    @Resource
    private WarehouseInfoService warehouseInfoService;


    /**
     * 查询仓库信息方法
     */
    @GetMapping(value = "/getWarehouseInfo")
    public Map<String,Object> selectByCondition(WarehouseInfo wi, Page page){
        Map<String, Object> wInfo = warehouseInfoService.selectByCondition(wi,page);
        return wInfo;
    }
}
