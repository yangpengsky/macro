package com.macro.ob.controller;

import com.macro.ob.pojo.MakeRequisition;
import com.macro.ob.pojo.Orders;
import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.RequisitionInfo;
import com.macro.ob.service.OrdersService;
import com.macro.ob.service.RequisitionInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/RequisitionInfoSelectController")
public class RequisitionInfoController {
    @Resource
    private OrdersService ordersService;
    @Resource
    private RequisitionInfoService requisitionInfoService;
    /**
     *调拨单列表查询
     */
    @RequestMapping("/RequisitionInfoSelect")
    public Map<String,Object>RequisitionInfoSelect(RequisitionInfo requisitionInfo, Page page){
        return requisitionInfoService.RequisitionInfoSelect(requisitionInfo,page);
    }
    /**
     *调拨单详情
     */
    @RequestMapping("/ViewDetails")
    public Map<String,Object> ViewDetails(Integer requisitionCode){
        return requisitionInfoService.ViewDetails(requisitionCode);
    }
    /**
     *制定调拨单
     */
    @RequestMapping("/makeTransferOrders")
    public Map<String,Object> makeTransferOrders(@RequestBody MakeRequisition makeRequisition){

      return requisitionInfoService.selectInWarehouseName(makeRequisition);

    }

    /**4
     *
     * @param requisitionInfo
     * @param orders
     * @return orders
     * 当调拨单类型为电商调拨类型时，全表查询备货计划列表
     */
    @RequestMapping("/selectStockingSchedule")
    public Map<String,Object> selectStockingSchedule( RequisitionInfo requisitionInfo, Orders orders){

        return requisitionInfoService.selectStockingSchedule(requisitionInfo,orders);
    }


}
