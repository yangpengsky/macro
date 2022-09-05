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
   List<RequisitionInfo>RequisitionInfoSelect(RequisitionInfo requisitionInfo);
   List<RequisitionInfo>ViewDetails(Integer requisitionCode);
   Integer MakeTransferOrder(RequisitionInfo requisitionInfo);

}
