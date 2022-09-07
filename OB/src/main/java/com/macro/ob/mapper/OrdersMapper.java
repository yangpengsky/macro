package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.Orders;

import java.util.List;


/**
* @author 37656
* @description 针对表【orders(订单表)】的数据库操作Mapper
* @createDate 2022-09-02 15:31:23
* @Entity com.macro.ob.pojo.Orders
*/
public interface OrdersMapper extends BaseMapper<Orders> {


    /**
     * 条件查询订单表
     * @param orders
     * @return
     */
    List<Orders> selectOrderIF(Orders orders);

    /**
     * 将订单状态修改为已审核
     * @param orders
     * @return
     */
    int updateOrderBy(Orders orders);

    /**
     * 查看订单详情
     * @param orders
     * @return
     */
    List<Orders> selectOrderByOrderCode(Orders orders);

}
