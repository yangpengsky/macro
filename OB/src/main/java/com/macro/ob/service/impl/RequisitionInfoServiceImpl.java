package com.macro.ob.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.ob.mapper.RequisitionInfoMapper;
import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.RequisitionInfo;
import com.macro.ob.service.RequisitionInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
}
