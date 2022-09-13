package com.macro.ob.service;


import com.macro.ob.pojo.MakeRequisition;
import com.macro.ob.pojo.Orders;
import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.RequisitionInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @author 周学林
* @description 针对表【requisition_info(调拨单信息)】的数据库操作Service
* @createDate 2022-09-05 10:23:20
*/
public interface RequisitionInfoService{
  /**
   *
   * @param requisitionInfo
   * @param page
   * @return requisitionInfo
   */
  Map<String,Object>RequisitionInfoSelect(RequisitionInfo requisitionInfo, Page page);

  /**
   *
   * @param requisitionCode
   * @return requisitionInfo
   */
  Map<String,Object>ViewDetails(Integer requisitionCode);

  /**
   *
   * @param makeRequisition
   * @return map
   */
  Map<String,Object> selectInWarehouseName(MakeRequisition makeRequisition);

  /**
   *
   * @param requisitionInfo
   * @param orders
   * @return
   */
  Map<String,Object> selectStockingSchedule(RequisitionInfo requisitionInfo,Orders orders);

}
