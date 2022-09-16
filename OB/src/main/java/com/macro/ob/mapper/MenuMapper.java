package com.macro.ob.mapper;


import com.macro.ob.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author huangguo
* @description 针对表【menu(菜单表)】的数据库操作Mapper
* @createDate 2022-09-05 17:10:33
* @Entity com.macro.ob.pojo.Menu
*/
@Mapper
public interface MenuMapper {

    /*
    * OB运营后台：菜单管理,查询所有菜单信息
    */
    List<Menu> selectAllByMenuName(Menu menu);

    /*
     * OB运营后台：菜单管理,添加菜单
     */
    Integer insertAllMenu(Menu menu);

    /*
     * OB运营后台：菜单管理,删除单个菜单
     */
    Integer deleteByMenuId(Menu menu);

    /*
     * OB运营后台：菜单管理,删除多个菜单
     */
    Integer deleteAllByMenuId(Integer[] menuId);

    /*
     * OB运营后台：菜单管理,修改菜单
     */
    Integer updateByMenuId(Menu menu);

}
