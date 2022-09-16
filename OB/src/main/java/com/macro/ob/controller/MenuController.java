package com.macro.ob.controller;

import com.macro.ob.pojo.Resource;
import com.macro.ob.pojo.Menu;
import com.macro.ob.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class MenuController {
    @javax.annotation.Resource
    private MenuService menuService;


    /*
     * OB运营后台：菜单管理,查询所有菜单信息
     */
    @PostMapping("/selectAllByMenuName")
    Map<String,Object> selectAllByMenuName(@RequestBody Menu menu){
        return menuService.selectAllByMenuName(menu);
    }

    /*
     * OB运营后台：菜单管理,添加菜单
     */
    @PostMapping("/insertAllMenu")
    Map<String,Object> insertAllMenu(@RequestBody Menu menu){
        return menuService.insertAllMenu(menu);
    }

    /*
     * OB运营后台：菜单管理,删除单个菜单
     */
    @DeleteMapping("/deleteByMenuId")
    Map<String,Object> deleteByMenuId(@RequestBody Menu menu){
        return menuService.deleteByMenuId(menu);
    }

    /*
     * OB运营后台：菜单管理,删除多个菜单
     */
    @DeleteMapping("/deleteAllByMenuId")
    Map<String,Object> deleteAllByMenuId(@RequestBody Integer[] menuId){
        return menuService.deleteAllByMenuId(menuId);
    }

    /*
     * OB运营后台：菜单管理,修改菜单
     */
    @PutMapping("/updateByMenuId")
    Map<String,Object> updateByMenuId( @RequestBody Menu menu){
        return menuService.updateByMenuId(menu);
    }


}
