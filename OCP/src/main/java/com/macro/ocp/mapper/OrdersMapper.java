package com.macro.ocp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ocp.pojo.Orders;

import java.util.List;

/**
* @author zhangkein
* @description 针对表【orders(订单表)】的数据库操作Mapper
* @createDate 2022-09-02 14:05:25
* @Entity com.macro.ocp.pojo.Orders
*/
public interface OrdersMapper extends BaseMapper<Orders> {

    /**
     * 传入一个orders对象，返回这个order的ID值
     * @param orders
     * @return 数据插入后的ID值进行返显
     */
    Integer insertOrders(Orders orders);


    /**
     * 返回满足条件的orders集合
     * @param order
     * @return 符合条件的orders集合
     */
    List<Orders> selectOrdersByInfo(Orders order);
    /**
     * <p>更新订单信息</p>
     * @param orders:
     * @return Integer
     * @author zhangkein
     * @date 2022/9/8 11:57
     */
    Integer updateOrder(Orders orders);
}
