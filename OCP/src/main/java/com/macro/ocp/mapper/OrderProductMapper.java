package com.macro.ocp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ocp.pojo.OrderProduct;

import java.util.Map;

/**
* @author zhangkein
* @description 针对表【order_product】的数据库操作Mapper
* @createDate 2022-09-02 16:29:58
* @Entity com.macro.ocp.pojo.OrderProduct
*/
public interface OrderProductMapper extends BaseMapper<OrderProduct> {
    /**
     * 插入一条订单产品关联记录
     * @param map
     * @return 影响的行数，成功返回值大于0
     */
    Integer insertOrderProduct(Map<String,Integer> map);


}
