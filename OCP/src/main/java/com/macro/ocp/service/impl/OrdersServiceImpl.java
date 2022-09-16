package com.macro.ocp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ocp.pojo.DealerAccountNumber;
import com.macro.ocp.service.OrdersService;
import com.macro.ocp.mapper.OrderProductMapper;
import com.macro.ocp.mapper.OrdersMapper;
import com.macro.ocp.pojo.Orders;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 针对表【orders(订单表)】的数据库操作Service实现
 *
 * @author zhangkein
 * @description
 * @createDate 2022-09-02 14:05:25
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    public OrdersMapper ordersMapper;
    @Resource
    private SqlSessionFactory sessionFactory;

    /**
     * <p>插入一个备货订单</p>
     *
     * @param request:
     * @param order:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 21:15
     */
    @Override
    public Map<String, Object> insertStockUpOrders(HttpServletRequest request, Orders order) {

        //返回值结果处理
        Map<String, Object> map = new HashMap<>();
        //获得登录账号信息
        DealerAccountNumber account = null;
        Object attribute = request.getSession().getAttribute("account");
        if (attribute instanceof DealerAccountNumber) {
            account = (DealerAccountNumber) attribute;
        }
        //判断账号是否登录
        if (account == null) {
            map.put("code", 4);
            map.put("flag", false);
            map.put("message", "请登录");
            return map;
        }//将账号编码和创建人录入
        order.setDealerCode(account.getAccountCode());
        order.setCreatedBy(account.getUserName());
        //插入一条订单记录
        Integer orderNum = 0;
        if (order.getOrderStatus() != null) {
            orderNum = ordersMapper.insertOrders(order);
        }
        System.out.println(order);
        //声明订单关联产品个数
        Integer count = 0;
        //判断订单生成是否成功
        if (orderNum != null && orderNum > 0) {
            //通过sessionFactory重新得到会话，不自动提交
            SqlSession session = sessionFactory.openSession(false);
            //通过这个会话获得orderProductMapper
            OrderProductMapper orderProductMapper = session.getMapper(OrderProductMapper.class);
            //产品编码
            Integer[] products = order.getProductCodes();
            //通过产品编码循环插入订单关联产品
            for (int i = 0; i < products.length; i++) {
                //零时的Map存插入的值
                Map<String, Integer> mapTemp = new HashMap<>();
                mapTemp.put("orderCode", order.getOrderCode());
                mapTemp.put("productCode", products[i]);
                //执行插入，对插入的条数进行统计
                count += orderProductMapper.insertOrderProduct(mapTemp);
            }
            session.commit();
            map.put("code", 0);
            map.put("flag", true);
            map.put("orderCode", order.getOrderCode());
            map.put("productNum", count);
        } else {
            map.put("code", 1);
            map.put("flag", false);
        }
        return map;
    }

    /**
     * <p>根据前端传入的时间范围，总金额范围，订单编号，订单状态等查询</p>
     *
     * @param request:
     * @param order:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/7 21:15
     */
    @Override
    public Map<String, Object> selectOrdersByInfo(HttpServletRequest request, Orders order) {
        //返回值结果处理
        Map<String, Object> map = new HashMap<>();
        //获得登录账号信息
        DealerAccountNumber account = null;
        Object attribute = request.getSession().getAttribute("account");
        if (attribute instanceof DealerAccountNumber) {
            account = (DealerAccountNumber) attribute;
        }
        //判断账号是否登录
        if (account == null) {
            map.put("code", 4);
            map.put("flag", false);
            map.put("message", "请登录");
            return map;
        }
        //设置分页
        if (order.getPageNum() == null && order.getPageSize() == null) {
            order.setPageNum(1);
            order.setPageSize(5);
        }
        PageHelper.startPage(order.getPageNum(), order.getPageSize());
        order.setDealerCode(account.getAccountCode());
        //进行查询
        List<Orders> list = ordersMapper.selectOrdersByInfo(order);
        //进行分页
        //处理数据
        if (list.size() > 0) {
            PageInfo<Orders> info = new PageInfo<>(list);
            map.put("code", 0);
            map.put("flag", true);
            map.put("info", info);
        } else {
            map.put("code", 1);
            map.put("flag", false);
        }
        return map;
    }

    /**
     * <p>更新订单信息</p>
     *
     * @param request:
     * @param order:
     * @return Map<String, Object>
     * @author zhangkein
     * @date 2022/9/8 11:59
     */
    @Override
    public Map<String, Object> updateOrder(HttpServletRequest request, Orders order) {
        //创建返回值map
        Map<String, Object> map = new HashMap<>();
        //获得登录账号信息
        DealerAccountNumber account = null;
        Object attribute = request.getSession().getAttribute("account");
        if (attribute instanceof DealerAccountNumber) {
            account = (DealerAccountNumber) attribute;
        }
        //判断账号是否登录
        if (account == null) {
            map.put("code", 4);
            map.put("flag", false);
            map.put("message", "请登录");
            return map;
        }
        //设置订单账号
        order.setDealerCode(account.getAccountCode());
        //更新
        if (ordersMapper.updateOrder(order) > 0) {
            map.put("code", 0);
            map.put("flag", true);
            map.put("message", "成功");
        } else {
            map.put("code", 1);
            map.put("flag", false);
            map.put("message", "请重试");
        }
        return map;
    }

}
