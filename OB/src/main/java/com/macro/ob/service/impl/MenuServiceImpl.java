package com.macro.ob.service.impl;

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
        List<Menu> list = menuMapper.selectAllByMenuName(menu);
        if (list.size() > 0){
            map.put("code",list.size());
            map.put("info",list);
            map.put("message","查询成功!");
        }else{
            map.put("code",list.size());
            map.put("info",list);
            map.put("message","查询失败!");
        }
        return map;
    }


}
