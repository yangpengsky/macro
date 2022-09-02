package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.FactoryInventory;

import java.util.Map;


/**
* @author 周学林
* @description 针对表【factory_inventory(工厂库存表)】的数据库操作Mapper
* @createDate 2022-09-02 16:47:30
* @Entity com.macro.ob.pojo.FactoryInventory
*/
public interface FactoryInventoryMapper extends BaseMapper<FactoryInventory> {
      Map<String,Object> FactoryInventorySelect();

}
