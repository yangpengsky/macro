package com.macro.ob.service;

import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.WarehouseInfo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
* @author HP
* @description 针对表【warehouse_info(仓库信息表)】的数据库操作Service
* @createDate 2022-09-02 15:33:51
*/
public interface WarehouseInfoService {
    /**
     * 按照条件查询仓库信息
     */
    Map<String,Object> selectByCondition(WarehouseInfo warehouse,Page page);
}
