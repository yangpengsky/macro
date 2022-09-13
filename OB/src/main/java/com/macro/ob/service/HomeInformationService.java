package com.macro.ob.service;

import com.macro.ob.pojo.HomeInformation;

import java.util.List;
import java.util.Map;

/**
* @author HP
* @description 针对表【home_information(首页资讯列表)】的数据库操作Service
* @createDate 2022-09-08 09:23:02
*/
public interface HomeInformationService{
    /**
     * 新增咨询
     */
    Map<String,Object> addHomeInformation(HomeInformation homeInformation);

    /**
     * 查看咨询
     */
    Map<String,Object> selectHomeInformation(HomeInformation homeInformation);

    /**
     * 删除咨询
     */
    Map<String,Object> delHomeInformationById(HomeInformation homeInformation);

    /**
     * 修改咨询
     */
    Map<String,Object> updateHomeInformationById(HomeInformation homeInformation);
}
