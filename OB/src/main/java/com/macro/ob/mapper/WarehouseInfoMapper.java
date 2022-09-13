package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.WarehouseInfo;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @author HP
* @description 针对表【warehouse_info(仓库信息表)】的数据库操作Mapper
* @createDate 2022-09-02 15:33:51
* @Entity com.macro.ob.pojo.WarehouseInfo
*/
@Mapper
public interface WarehouseInfoMapper extends BaseMapper<WarehouseInfo> {
    /**
     * 按照条件查询仓库信息
     */
     List<WarehouseInfo> selectByCondition(WarehouseInfo warehouseInfo);
}


