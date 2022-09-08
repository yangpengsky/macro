package com.macro.ob.controller;

import com.macro.ob.pojo.OperatingAccount;
import com.macro.ob.pojo.Orders;
import com.macro.ob.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
     * 初审查询订单信息
     * @param orders
     * @return
     */
    @PostMapping("/selectOrderIF")
    public Map<String, Object> selectOrderIF(@RequestBody Orders orders) {
        System.out.println(orders);
        System.out.println("yangpeng");
        return ordersService.selectOrderIF(orders);
    }


    /**
     * 复审查询
     * @param orders
     * @return
     */
    @PostMapping("/selectOrderConformIF")
    public Map<String,Object> selectOrderConformIF(@RequestBody Orders orders){
        return ordersService.selectOrderConformIF(orders);
    }


    /**
     * 初审核通过
     * @param orders
     * @return
     */
    @PutMapping("/updateOrderPass")
    public Map<String, Object> updateOrderPass(@RequestBody Orders orders, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object info = session.getAttribute("info");
        OperatingAccount operatingAccount= (OperatingAccount) info;
        orders.setOrderPreliminaryAudit(operatingAccount.getUserName());
        return ordersService.updateOrderPass(orders);
    }

    /**
     * 初审核通过
     * @param orders
     * @return
     */
    @PutMapping("/updateOrderNoPass")
    public Map<String, Object> updateOrderNoPass(@RequestBody Orders orders) {
        return ordersService.updateOrderNoPass(orders);
    }

    /**
     * 查询订单信息
     *
     * @param orders
     * @return
     */
    @PostMapping("/selectOrderByOrderCode")
    public Map<String, Object> selectOrderByOrderCode(@RequestBody Orders orders) {
        System.out.println(orders.getOrderCode() + "=============");
        return ordersService.selectOrderByOrderCode(orders);
    }


    /**
     * 导出表格
     *
     * @param orders
     * @return
     */
    @PostMapping("/exportTable")
    public Map<String, Object> exportTable(@RequestBody Orders orders) throws IOException {
        System.out.println(orders);
        System.out.println("yangpeng");
        return ordersService.exportTable(orders);
    }


}