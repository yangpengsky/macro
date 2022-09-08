package com.macro.ob.service;


import com.macro.ob.pojo.Orders;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    Map<String,Object> updateOrderPass(Orders orders);


    /**
     * 将初审驳回
     * @param orders
     * @return
     */
    Map<String,Object> updateOrderNoPass(Orders orders);

    /**
     * 查看订单详情
     * @param orders
     * @return
     */
    Map<String,Object> selectOrderByOrderCode(Orders orders);


    /**
     * 导出订单表
     * @param orders
     * @return
     */
    Map<String,Object>  exportTable(Orders orders) throws IOException;

    /**
     * 复核查询
     * @param orders
     * @return
     */
    Map<String,Object> selectOrderConformIF(Orders orders);


}
