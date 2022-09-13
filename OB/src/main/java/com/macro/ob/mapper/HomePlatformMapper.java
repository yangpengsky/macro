package com.macro.ob.mapper;


import com.macro.ob.pojo.HomePlatform;

import java.util.List;

/**
* @author 周学林
* @description 针对表【home_platform(首页信息平台列表)】的数据库操作Mapper
* @createDate 2022-09-08 14:08:59
* @Entity com.macro.ob.pojo.HomePlatform
*/
public interface HomePlatformMapper {
    /**
     *
     * @return HomePlatform
     */
    List<HomePlatform>selectInfo();

    /**
     *
     * @param homePlatform
     * @return int
     */
    Integer addInfo(HomePlatform homePlatform);

    /**
     *
     * @param homePlatform
     * @return int
     */
    Integer updateInfo(HomePlatform homePlatform);

    /**
     *
     * @param homePlatform
     * @return int
     */
    Integer deleteInfo(HomePlatform homePlatform);


}
