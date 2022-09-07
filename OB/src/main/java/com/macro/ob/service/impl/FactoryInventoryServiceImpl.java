package com.macro.ob.service.impl;


import com.github.pagehelper.PageHelper;
import com.macro.ob.mapper.FactoryInventoryMapper;
import com.macro.ob.pojo.FactoryInventory;
import com.macro.ob.pojo.Page;
import com.macro.ob.service.FactoryInventoryService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 周学林
* @description 针对表【factory_inventory(工厂库存表)】的数据库操作Service实现
* @createDate 2022-09-02 16:47:30
*/
@Service
public class FactoryInventoryServiceImpl implements FactoryInventoryService{
    @Resource
    private FactoryInventoryMapper factoryInventoryMapper;
    @Override
    public Map<String, Object> FactoryInventorySelect(FactoryInventory fa, Page page) {
        Map<String,Object>map=new HashMap<>();
        /**
         *分页查询
         */
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        /**
         *查询工厂库存列表
         */
        List<FactoryInventory> list=factoryInventoryMapper.FactoryInventorySelect(fa);
       if(list.size()!=0){
           map.put("code",true);
           map.put("data",list);
           map.put("flag","查看成功");
       }else {
           map.put("code",false);
           map.put("flag","查看失败");
       }
        return map;
    }
}
