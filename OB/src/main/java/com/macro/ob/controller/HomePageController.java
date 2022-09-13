package com.macro.ob.controller;

import com.macro.ob.pojo.HomePage;
import com.macro.ob.service.HomePageService;
import com.macro.ob.service.ProductService;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 首页公告列表的控制层实现
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/announcement")
public class HomePageController {
    /**
     * 创建首页公告信息业务层对象
     */
    @Resource
    private HomePageService homePageService;

    /**
     * 添加公告信息
     */
    @PostMapping(value = "/addHomePage")
    public Map<String,Object> addHomePage(@RequestBody HomePage homePage){
        return homePageService.addHomePage(homePage);
    }

    /**
     * 查看公告信息
     */
    @GetMapping(value = "/selectHomePage")
    public Map<String,Object> selectHomePage(@RequestBody HomePage homePage){
        return homePageService.selectHomePage(homePage);
    }

    /**
     * 删除公告信息
     */
    @DeleteMapping(value = "/delHomePage")
    public Map<String,Object> delHomePage(@RequestBody HomePage homePage){
        return homePageService.delHomePage(homePage);
    }

    /**
     * 修改公告信息
     */
    @PutMapping(value = "/updateHomePage")
    public Map<String,Object> updateHomePage(@RequestBody HomePage homePage){
        return homePageService.updateHomePage(homePage);
    }
}
