package com.macro.ocp.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * orders控制层
=======
import com.macro.ocp.pojo.Orders;
import com.macro.ocp.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * orders控制层
 *
>>>>>>> 94f054ec28cf73fa11a51bb8290ab8db4246c87b
 * @author zhangkein
 * @date 2022/09/02
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

<<<<<<< HEAD
=======

    @Resource
    private OrdersService ordersService;

    /**
     * <p>插入一条备货订单记录</p>
     *
     * @param request: HttpServletRequest对象，用于获取会话中的sesion
     * @param order:   Orders对象，用于保存备货订单信息信息
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 19:19
     */
    @PostMapping(value = "/stockUp/insertStockUpOrder")
    public Map<String, Object> insertStockUpOrders(HttpServletRequest request, @RequestBody Orders order) {
        return ordersService.insertStockUpOrders(request, order);
    }

    /**
     * 查询订单信息
     *
     * @param order
     * @return
     */
    @GetMapping(value = "/selectOrdersByInfo")
    public Map<String, Object> selectOrdersByInfo(HttpServletRequest request, @RequestBody Orders order) {
        return ordersService.selectOrdersByInfo(request, order);
    }

    /**
     * <p>更新订单信息</p>
     * @param request:
     * @param order:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 12:03
     */
    @PutMapping("/updateOrder")
    public Map<String,Object> updateOrder(HttpServletRequest request,@RequestBody Orders order){
        return ordersService.updateOrder(request, order);
    }
>>>>>>> 94f054ec28cf73fa11a51bb8290ab8db4246c87b
}
