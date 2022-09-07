package com.macro.ob.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.ob.mapper.RequisitionInfoMapper;
import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.RequisitionInfo;
import com.macro.ob.service.RequisitionInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
   @Resource
    private RequisitionInfoMapper requisitionInfoMapper;

    @Override
    public Map<String, Object> RequisitionInfoSelect(RequisitionInfo requisitionInfo, Page page) {
        Map<String,Object>map=new HashMap<>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        if(requisitionInfoMapper.RequisitionInfoSelect(requisitionInfo).size()!=0){
            List<RequisitionInfo>list =requisitionInfoMapper.RequisitionInfoSelect(requisitionInfo);
            map.put("code",true);
            map.put("flag","查询数据成功");
            map.put("data",list);
        }else {
            map.put("code",false);
            map.put("flag","查询数据失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> ViewDetails(Integer requisitionCode) {
        Map<String,Object>map=new HashMap<>();
        if(requisitionInfoMapper.ViewDetails(requisitionCode).size()!=0){
            List<RequisitionInfo>list=requisitionInfoMapper.ViewDetails(requisitionCode);
            map.put("code",true);
            map.put("flag","查询成功");
            map.put("data",list);
        }else {
            map.put("code",false);
            map.put("flag","查询失败");
        }
        return map;
    }
@Value("${String.RequisitionType}")
private String RequisitionType;
    @Override
    public Map<String,Object> selectInWarehouseName(RequisitionInfo requisitionInfo) {
        Map<String,Object>map=new HashMap<>();
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
        }
        else if(requisitionInfo.getRequisitionType()==RequisitionType){








        }else {
            requisitionInfo.setInWarehouseName(requisitionInfoMapper.selectInWarehouseName(requisitionInfo));
            requisitionInfo.setOutWarehouseName(requisitionInfoMapper.selectOutWarehouseName(requisitionInfo));
            requisitionInfo.setInOrganizationName(requisitionInfoMapper.selectInOrganizationName(requisitionInfo));
            requisitionInfo.setOutOrganizationName(requisitionInfoMapper.selectOutOrganizationName(requisitionInfo));
            requisitionInfo.setDealerName(requisitionInfoMapper.selectDealerName(requisitionInfo));
            if (requisitionInfoMapper.insertName(requisitionInfo) != 0) {
                Integer num=requisitionInfoMapper.insertName(requisitionInfo);
                map.put("number", num);
                map.put("flag", "插入成功");
            } else {
                map.put("flag", "插入失败");
            }
        }
        return map;
    }
}
