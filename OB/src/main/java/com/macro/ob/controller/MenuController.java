package com.macro.ob.controller;


import com.macro.ob.pojo.Menu;
import com.macro.ob.service.MenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/MenuController")
public class MenuController {
    @Resource
    private MenuService menuService;

    /*
     * OB运营后台：菜单管理,查询所有菜单信息
     */
    @PostMapping("/selectAllByMenuName")
    Map<String,Object> selectAllByMenuName(@RequestBody Menu menu){
        return menuService.selectAllByMenuName(menu);
    }
}
