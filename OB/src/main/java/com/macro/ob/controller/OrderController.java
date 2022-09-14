package com.macro.ob.controller;

import com.macro.ob.pojo.OperatingAccount;
import com.macro.ob.pojo.Orders;
import com.macro.ob.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
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

@Api("计划备货管理")
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
    @ApiOperation("初审查询订单信息")
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
    @ApiOperation("复审查询")
    @PostMapping("/selectOrderConformIF")
    public Map<String,Object> selectOrderConformIF(@RequestBody Orders orders){
        return ordersService.selectOrderConformIF(orders);
    }


    /**
     * 初审核通过
     * @param orders
     * @return
     */
    @ApiOperation("初审核通过")
    @PutMapping("/updateOrderPass")
    public Map<String, Object> updateOrderPass(@RequestBody Orders orders, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object info = session.getAttribute("info");
        OperatingAccount operatingAccount= (OperatingAccount) info;
        orders.setOrderPreliminaryAudit(operatingAccount.getUserName());
        return ordersService.updateOrderPass(orders);
    }

    /**
     * 初审核不通过
     * @param orders
     * @return
     */
    @ApiOperation("初审核不通过")
    @PutMapping("/updateOrderNoPass")
    public Map<String, Object> updateOrderNoPass(@RequestBody Orders orders) {
        return ordersService.updateOrderNoPass(orders);
    }

    /**
     * 查询订单信息
     * @param orders
     * @return
     */
    @ApiOperation("查询订单信息")
    @PostMapping("/selectOrderByOrderCode")
    public Map<String, Object> selectOrderByOrderCode(@RequestBody Orders orders) {
        System.out.println(orders.getOrderCode() + "=============");
        return ordersService.selectOrderByOrderCode(orders);
    }

    /**
     * 计划备货列表
     * @param orders
     * @return
     */
    @ApiOperation("计划备货列表")
    @PostMapping("/selectOrderStockList")
    public Map<String,Object> selectOrderStockList(@RequestBody Orders orders){
        return ordersService.selectOrderStockList(orders);
    }


    /**
     * 导出表格
     *
     * @param orders
     * @return
     */
    @ApiOperation("导出表格")
    @PostMapping("/exportTable")
    public Map<String, Object> exportTable(@RequestBody Orders orders) throws IOException {
        System.out.println(orders);
        System.out.println("yangpeng");
        return ordersService.exportTable(orders);
    }


    /**
     * 备货计划列表数据导出
     * @param orders
     * @return
     */
    @ApiOperation("备货计划列表数据导出")
    @SneakyThrows
    @PostMapping("/selectOrderStockListExport")
    public Map<String,Object> selectOrderStockListExport(@RequestBody Orders orders) throws IOException {
        return ordersService.selectOrderStockListExport(orders);
    }


}