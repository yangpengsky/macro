package com.macro.ob.service.impl;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.macro.ob.mapper.OrdersMapper;
import com.macro.ob.mapper.RequisitionInfoMapper;
import com.macro.ob.pojo.MakeRequisition;
import com.macro.ob.pojo.Orders;
import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.RequisitionInfo;
import com.macro.ob.service.RequisitionInfoService;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 周学林
* @description 针对表【requisition_info(调拨单信息)】的数据库操作Service实现
* @createDate 2022-09-05 10:23:20
*/
@Service
public class RequisitionInfoServiceImpl implements RequisitionInfoService{

    RequisitionInfo requisitionInfo;
    List<Orders> orders;
    @Resource
    private OrdersMapper ordersMapper;
   @Resource
    private RequisitionInfoMapper requisitionInfoMapper;
    /**
     *分页查询调拨单列表
     */
    @Override
    public Map<String, Object> RequisitionInfoSelect(RequisitionInfo requisitionInfo, Page page) {
        Map<String,Object>map=new HashMap<>();
        if(page.getPageNum()==null) {
            page.setPageNum(1);
        }
        if(page.getPageSize()==null){
            page.setPageSize(10);
        }
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<RequisitionInfo>list =requisitionInfoMapper.RequisitionInfoSelect(requisitionInfo);
        if(list.size()!=0){
            map.put("code",true);
            map.put("flag","查询数据成功");
            map.put("data",list);
        }else {
            map.put("code",false);
            map.put("flag","查询数据失败");
        }
        return map;
    }
    /**
     *根据requisitionCode查看调拨单信息情况
     */
    @Override
    public Map<String, Object> ViewDetails(Integer requisitionCode) {
        Map<String,Object>map=new HashMap<>();
        List<RequisitionInfo>list=requisitionInfoMapper.ViewDetails(requisitionCode);
        if(list.size()!=0){
            map.put("code",true);
            map.put("flag","查询成功");
            map.put("data",list);
        }else {
            map.put("code",false);
            map.put("flag","查询失败");
        }
        return map;
    }
    /**
     *制定调拨单
     */

    @Value("${String.requisitionType}")
    private String requisitionType;
    @Override
    public Map<String,Object> selectInWarehouseName(MakeRequisition makeRequisition) {
        Map<String,Object>map=new HashMap<>();
        /**
         *判断输入值是orders,requisitionInfo是否为空，是否为对应实体类类型
         */
        if (makeRequisition.getRequisitionInfo() != null && makeRequisition.getRequisitionInfo() instanceof RequisitionInfo){
             this.requisitionInfo = makeRequisition.getRequisitionInfo();
        }
        if (makeRequisition.getOrders().size() !=0 && makeRequisition.getRequisitionInfo() instanceof RequisitionInfo){
            this.orders = makeRequisition.getOrders();
        }
        /**
         * 判断调拨订单类型是否为电商备货调拨类型
         */
        if (requisitionInfo.getRequisitionType().equals(requisitionType)){
            /**
             * 判断为电商备货调拨类型
             */
           List<Orders> order=ordersMapper.selectInOrderInfo(orders);
            BigDecimal BulkVolume=BigDecimal.ZERO;
           int ProductQuantity=0;
           for (int i=0;i<order.size();i++){
               ProductQuantity= ProductQuantity+order.get(i).getProductQuantity();
               BulkVolume=BulkVolume.add(order.get(i).getBulkVolume());
           }
            /**
             * 通过订单数量和体积，计算出调拨单总数量和体积
             */
           requisitionInfo.setRequisitionNumber(ProductQuantity);
           requisitionInfo.setRequisitionTotalVolume(BulkVolume);
        }

        if(requisitionInfo.getRequisitionType()==null){
            map.put("flag","调拨类型不能为空");
        }else if(requisitionInfo.getInOrganizationCode()==null){
            map.put("flag","调入机构不能为空");
        }else if(requisitionInfo.getOutOrganizationCode()==null){
            map.put("flag","调出机构不能为空");
        }else if (requisitionInfo.getInWarehouseCode()==null){
            map.put("flag","调入仓库不能为空");
        }else if(requisitionInfo.getOutWarehouseCode()==null){
            map.put("flag","调出仓库不能为空");
        }else if(requisitionInfo.getDealerCode()==null){
            map.put("flag","经销商不能为空");
        }else if(requisitionInfo.getDeliverStyle()==null){
            map.put("flag","请选择发运方式");
        }else if(requisitionInfo.getConsigneeAddress()==null){
            map.put("flag","送货地址不能为空");
        }else if(requisitionInfo.getProductCode()==null){
            map.put("flag","请选择产品");
        }else if(requisitionInfo.getRequisitionNumber()==null){
            map.put("flag","请填写正确的调拨数量");
        } else {

            this.requisitionInfo.setInWarehouseName(requisitionInfoMapper.selectInWarehouseName(this.requisitionInfo));
            /**
             *获取出库仓库名称
             */
            this.requisitionInfo.setOutWarehouseName(requisitionInfoMapper.selectOutWarehouseName(this.requisitionInfo));
            /**
             *获取调入机构名称
             */
            this.requisitionInfo.setInOrganizationName(requisitionInfoMapper.selectInOrganizationName(this.requisitionInfo));
            /**
             *获取调出机构名称
             */
            this.requisitionInfo.setOutOrganizationName(requisitionInfoMapper.selectOutOrganizationName(this.requisitionInfo));
            /**
             *获取经销商名称
             */
            this.requisitionInfo.setDealerName(requisitionInfoMapper.selectDealerName(this.requisitionInfo));
            /**
             *插入调拨单信息
             */
            int num = requisitionInfoMapper.makeTransferOrders(this.requisitionInfo);
            if (num != 0) {
                map.put("number", num);
                map.put("flag", "插入成功");
            } else {
                map.put("flag", "插入失败");
            }
        }
        return map;
    }

    /**
     *
     * @param requisitionInfo
     * @param orders
     * @return 备货调拨列表信息
     */
    @Override
    public Map<String, Object> selectStockingSchedule(RequisitionInfo requisitionInfo,Orders orders) {
        Map<String,Object>map=new HashMap<>();
        if (requisitionInfo.getRequisitionType().equals(requisitionType)){
           map.put("data",ordersMapper.selectOrderStockList(orders));
        }
        return map;
    }

}
