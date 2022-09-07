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


    @PostMapping("/selectOrderIF")
    public Map<String,Object> selectOrderIF(@RequestBody Orders orders){
        System.out.println(orders);
        System.out.println("yangpeng");
        return ordersService.selectOrderIF(orders);
    }


    @PostMapping("/updateOrderBy")
    public Map<String,Object> updateOrderBy(@RequestBody Orders orders){
        return ordersService.updateOrderBy(orders);
    }


}