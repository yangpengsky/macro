package com.macro.ob.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ob.mapper.MenuMapper;
import com.macro.ob.pojo.Menu;
import com.macro.ob.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author huangguo
* @description 针对表【menu(菜单表)】的数据库操作Service实现
* @createDate 2022-09-05 17:10:33
*/
@Service
@CrossOrigin
public class MenuServiceImpl implements MenuService{

    @Resource
    private MenuMapper menuMapper;

    /*
     * OB运营后台：菜单管理,查询所有菜单信息
     */
    @Override
    public Map<String, Object> selectAllByMenuName(Menu menu) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(menu.getPageNum(), menu.getPageSize());
        List<Menu> list = menuMapper.selectAllByMenuName(menu);
        PageInfo<Menu> pageInfo = new PageInfo<>(list);
        if (list.size() > 0){
            map.put("code",list.size());
            map.put("info",pageInfo);
            map.put("message","查询菜单成功!");
        }else{
            map.put("code",list.size());
            map.put("info",pageInfo);
            map.put("message","查询菜单失败!");
        }
        return map;
    }

    /*
     * OB运营后台：菜单管理,添加菜单
     */
    @Override
    public Map<String, Object> insertAllMenu(Menu menu) {
        Map<String,Object> map = new HashMap<>();
        Integer integer = menuMapper.insertAllMenu(menu);
        if (integer>0){
            map.put("code",integer);
            map.put("message","插入菜单成功!");
        }else{
            map.put("code",integer);
            map.put("message","插入菜单失败!");
        }
        return map;
    }

    /*
     * OB运营后台：菜单管理,删除单个菜单
     */
    @Override
    public Map<String, Object> deleteByMenuId(Menu menu) {
        Map<String,Object> map = new HashMap<>();
        Integer integer = menuMapper.deleteByMenuId(menu);
        if (integer>0){
            map.put("code",integer);
            map.put("message","删除菜单成功!");
        }else{
            map.put("code",integer);
            map.put("message","删除菜单失败!");
        }
        return map;
    }

    /*
     * OB运营后台：菜单管理,删除多个菜单
     */

    @Override
    public Map<String, Object> deleteAllByMenuId(Integer[] menuId) {
        Map<String,Object> map = new HashMap<>();
        Integer integer = menuMapper.deleteAllByMenuId(menuId);
        if (integer>0){
            map.put("code",integer);
            map.put("message","删除多个菜单成功!");
        }else{
            map.put("code",integer);
            map.put("message","删除多个菜单失败!");
        }
        return map;
    }

    /*
     * OB运营后台：菜单管理,修改菜单
     */
    @Override
    public Map<String, Object> updateByMenuId(Menu menu) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = menuMapper.updateByMenuId(menu);
        if (integer > 0) {
            map.put("code", integer);
            map.put("message", "修改菜单成功!");
        } else {
            map.put("code", integer);
            map.put("message", "修改菜单失败!");
        }
        return map;
    }
}
