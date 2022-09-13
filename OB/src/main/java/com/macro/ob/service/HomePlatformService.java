package com.macro.ob.service;


import com.macro.ob.pojo.HomePlatform;

import java.util.Map;

/**
* @author 周学林
* @description 针对表【home_platform(首页信息平台列表)】的数据库操作Service
* @createDate 2022-09-08 14:08:59
*/
public interface HomePlatformService{
    Map<String,Object>selectInfo();
    Map<String,Object> addInfo(HomePlatform homePlatform);
    Map<String,Object> deleteInfo(HomePlatform homePlatform);
    Map<String,Object> updateInfo(HomePlatform homePlatform);
}
