package com.macro.ob.controller;

import com.macro.ob.pojo.HomePlatform;
import com.macro.ob.service.HomePlatformService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/HomePlatFromController")
public class HomePlatFromController {
    @Resource
    private HomePlatformService homePlatformService;
    @RequestMapping("/selectInfo")
    public Map<String,Object> selectInfo(){
        return homePlatformService.selectInfo();
    }
    @RequestMapping("/addInfo")
    public Map<String,Object> addInfo(HomePlatform homePlatform){
        return homePlatformService.addInfo(homePlatform);
    }
    @RequestMapping("/updateInfo")
    public Map<String,Object> updateInfo(HomePlatform homePlatform){
        return homePlatformService.updateInfo(homePlatform);
    }
    @RequestMapping("/deleteInfo")
    public Map<String,Object> deleteInfo(HomePlatform homePlatform){
        return homePlatformService.deleteInfo(homePlatform);
    }
}
