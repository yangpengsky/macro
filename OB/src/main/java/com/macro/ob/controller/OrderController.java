package com.macro.ob.controller;

import com.macro.ob.pojo.Orders;
import com.macro.ob.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author :yangpeng
 * @date : 2022/9/2
 */
@RestController
@CrossOrigin
@RequestMapping("/odersOB")
public class OrderController {


    @Resource
    private OrdersService ordersService;


    /**
     * 查询订单信息
     * @param orders
     * @return
     */
    @PostMapping("/selectOrderIF")
    public Map<String,Object> selectOrderIF(@RequestBody Orders orders){
        System.out.println(orders);
        System.out.println("yangpeng");
        return ordersService.selectOrderIF(orders);
    }


    /**
     * 初审核
     * @param orders
     * @return
     */
    @PostMapping("/updateOrderBy")
    public Map<String,Object> updateOrderBy(@RequestBody Orders orders){
        return ordersService.updateOrderBy(orders);
    }

    /**
     * 查询订单信息
     * @param orders
     * @return
     */
    @PostMapping("/selectOrderByOrderCode")
    public Map<String,Object> selectOrderByOrderCode(@RequestBody Orders orders){
        System.out.println(orders.getOrderCode()+"=============");
        return ordersService.selectOrderByOrderCode(orders);
    }




}