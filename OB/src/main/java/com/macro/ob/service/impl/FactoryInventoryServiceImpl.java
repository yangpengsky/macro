package com.macro.ob.service.impl;


import com.macro.ob.mapper.FactoryInventoryMapper;
import com.macro.ob.pojo.FactoryInventory;
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
    public Map<String, Object> FactoryInventorySelect(FactoryInventory fa) {
        Map<String,Object>map=new HashMap<>();
        List<FactoryInventory> list=factoryInventoryMapper.FactoryInventorySelect(fa);
        map.put("data",list);
        return map;
    }
}
