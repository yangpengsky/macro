package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.RequisitionInfo;

import java.util.ArrayList;
import java.util.List;


/**
* @author 周学林
* @description 针对表【requisition_info(调拨单信息)】的数据库操作Mapper
* @createDate 2022-09-05 10:23:20
* @Entity com.macro.ob.pojo.RequisitionInfo
*/
public interface RequisitionInfoMapper extends BaseMapper<RequisitionInfo> {
   /**
    *调拨单列表查询
    */
   List<RequisitionInfo>RequisitionInfoSelect(RequisitionInfo requisitionInfo);
   /**
    *根据调拨单编号查看调拨单详情
    */
   List<RequisitionInfo>ViewDetails(Integer requisitionCode);
   /**
    *多表查询，根据入库仓库编码查看仓库名称
    */
   String selectInWarehouseName(RequisitionInfo requisitionInfo);
   /**
    *多表查询，根据出库仓库编码查看仓库名称
    */
   String selectOutWarehouseName(RequisitionInfo requisitionInfo);
   /**
    *多表查询，根据调入机构编码查看机构名称
    */
   String selectInOrganizationName(RequisitionInfo requisitionInfo);
   /**
    *多表查询，根据调出机构编码查看机构名称
    */
   String selectOutOrganizationName(RequisitionInfo requisitionInfo);
   /**
    *多表查询，根据经销商编码查看经销商名称
    */
   String selectDealerName(RequisitionInfo requisitionInfo);
   /**
    *制定调拨单
    */
   Integer makeTransferOrders(RequisitionInfo requisitionInfo);

}
