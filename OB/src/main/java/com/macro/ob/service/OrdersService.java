package com.macro.ob.service;


import com.macro.ob.pojo.Orders;

import java.util.List;
import java.util.Map;

/**
* @author 37656
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2022-09-02 15:31:23
*/
public interface OrdersService  {

    /**
     * 条件查询订单表
     * @param orders
     * @return
     */
    Map<String,Object> selectOrderIF(Orders orders);


    /**
     * 将订单状态修改为已审核
     * @param orders
     * @return
     */
    Map<String,Object> updateOrderBy(Orders orders);


}
