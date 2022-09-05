package com.macro.ob.controller;

import com.macro.ob.pojo.FactoryInventory;
import com.macro.ob.service.FactoryInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
@RestController
@RequestMapping("/FactoryInventorySelectController")
public class FactoryInventorySelectController {
    @Resource
    private FactoryInventoryService factoryInventoryService;
    @RequestMapping("/FactoryInventorySelect")
    public Map<String,Object> FactoryInventorySelect(FactoryInventory fa){
        return factoryInventoryService.FactoryInventorySelect(fa);
    }
}
