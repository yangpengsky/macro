package com.macro.ob.controller;

import com.macro.ob.mapper.HomeInformationMapper;
import com.macro.ob.pojo.HomeInformation;
import com.macro.ob.service.HomeInformationService;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/HomeInformation")
public class HomeInformationController {
    /**
     * 创建HomeInformationService对象
     */
    @Resource
    private HomeInformationService homeInformationService;
    /**
     * 新增咨询
     */
    @PostMapping(value = "/addHomeInformation")
    public Map<String,Object> addHomeInformation(@RequestBody HomeInformation homeInformation){
        return homeInformationService.addHomeInformation(homeInformation);
    }

    /**
     * 查看咨询
     */
    @GetMapping(value = "/selectHomeInformation")
    public Map<String,Object> selectHomeInformation(@RequestBody HomeInformation homeInformation){
        return homeInformationService.selectHomeInformation(homeInformation);
    }

    /**
     * 删除咨询
     */
    @DeleteMapping(value = "/delHomeInformationById")
    public Map<String,Object> delHomeInformationById(@RequestBody HomeInformation homeInformation){
        return homeInformationService.delHomeInformationById(homeInformation);
    }

    /**
     * 修改咨询
     */
    @PutMapping(value = "/updateHomeInformationById")
    public Map<String,Object> updateHomeInformationById(@RequestBody HomeInformation homeInformation){
        return homeInformationService.updateHomeInformationById(homeInformation);
    }
}
