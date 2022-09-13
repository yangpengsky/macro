package com.macro.ob.service;

import com.macro.ob.pojo.HomePage;

import java.util.Map;

/**
* @author HP
* @description 针对表【home_page(首页公告列表)】的数据库操作Service
* @createDate 2022-09-07 14:50:06
*/
public interface HomePageService{
    /**
     * 添加公告信息
     */
    Map<String,Object> addHomePage(HomePage homePage);

    /**
     * 删除公告信息
     */
    Map<String,Object> delHomePage(HomePage homePage);

    /**
     * 查看公告信息
     */
    Map<String,Object> selectHomePage(HomePage homePage);

    /**
     * 修改公告信息
     */
    Map<String,Object> updateHomePage(HomePage homePage);

}
