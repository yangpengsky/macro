package com.macro.ob.service.impl;

import com.macro.ob.mapper.OrdersMapper;
import com.macro.ob.pojo.Orders;
import com.macro.ob.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 37656
 * @description 针对表【orders(订单表)】的数据库操作Service实现
 * @createDate 2022-09-02 15:31:23
 */
@Service
public class OrdersServiceImpl implements OrdersService {


    @Resource
    private OrdersMapper ordersMapper;


    @Override
    public Map<String, Object> selectOrderIF(Orders orders) {

        List<Orders> list = ordersMapper.selectOrderIF(orders);
        Map<String, Object> map = new HashMap<>();
        if (list.size()>0){

            map.put("code", 0);
            map.put("flag", true);
            map.put("row",list.size());
            map.put("info", list);
            map.put("message", "查询成功！");
        }else {

            map.put("code", 0);
            map.put("flag", false);
            map.put("message", "查询失败！");
        }


        return map;
    }

    @Override
    public Map<String, Object> updateOrderBy(Orders orders) {
        int i = ordersMapper.updateOrderBy(orders);
         Map<String, Object> map = new HashMap<>();
                 if (i>0){
                     map.put("code", 0);
                     map.put("flag", true);
                     map.put("row", i);
                     map.put("message", "修改成功！");
                 }else {
                     map.put("code", 0);
                     map.put("flag", false);
                     map.put("message", "修改成功修改失败！");
                 }
        return map;
    }

    @Override
    public Map<String, Object> selectOrderByOrderCode(Orders orders) {
        List<Orders> list = ordersMapper.selectOrderByOrderCode(orders);
         Map<String, Object> map = new HashMap<>();
                 if (list.size()>0){
                     map.put("code", 0);
                     map.put("flag", true);
                     map.put("row",list.size());
                     map.put("info", list);
                     map.put("message", "订单查询成功！");
                 }else {
                     map.put("code", 0);
                     map.put("flag", false);
                     map.put("message", "订单查询失败！");
                 }

        return map;
    }



}
