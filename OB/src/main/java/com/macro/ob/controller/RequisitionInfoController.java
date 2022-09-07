package com.macro.ob.controller;

import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.RequisitionInfo;
import com.macro.ob.service.RequisitionInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/RequisitionInfoSelectController")
public class RequisitionInfoController {
    @Resource
    private RequisitionInfoService requisitionInfoService;
    @RequestMapping("/RequisitionInfoSelect")
    public Map<String,Object>RequisitionInfoSelect(RequisitionInfo requisitionInfo, Page page){
        return requisitionInfoService.RequisitionInfoSelect(requisitionInfo,page);
    }
    @RequestMapping("/ViewDetails")
    public Map<String,Object> ViewDetails(Integer requisitionCode){
        return requisitionInfoService.ViewDetails(requisitionCode);
    }
    @RequestMapping("/selectInName")
    public Map<String,Object> selectInName(RequisitionInfo requisitionInfo){
        return requisitionInfoService.selectInWarehouseName(requisitionInfo);
    }

}
