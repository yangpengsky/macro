package com.macro.ocp.service;
<<<<<<< HEAD
/**
* @author zhangkein
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2022-09-02 14:05:25
*/
public interface OrdersService{

=======

import com.macro.ocp.pojo.Orders;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>针对表【orders(订单表)】的数据库操作Service</p>
 *
 * @author zhangkein
 * @description 针对表【orders(订单表)】的数据库操作Service
 * @createDate 2022-09-02 14:05:25
 */

public interface OrdersService {

    /**
     * <p>插入一个备货订单</p>
     * @param request:
     * @param order:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 21:14
     */
    Map<String, Object> insertStockUpOrders(HttpServletRequest request, Orders order);

    /**
     * <p>根据前端传入的时间范围，总金额范围，订单编号，订单状态等查询</p>
     * @param request:
     * @param order:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 21:14
     */
    Map<String, Object> selectOrdersByInfo(HttpServletRequest request, Orders order);

    /**
     * <p>更新订单信息</p>
     * @param request:
     * @param order:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 11:58
     */
    Map<String, Object> updateOrder(HttpServletRequest request, Orders order);
>>>>>>> 94f054ec28cf73fa11a51bb8290ab8db4246c87b
}
