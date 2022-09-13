package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.HomeInformation;
import com.macro.ob.pojo.HomePage;
import com.macro.ob.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author HP
* @description 针对表【home_information(首页资讯列表)】的数据库操作Mapper
* @createDate 2022-09-08 09:23:02
* @Entity com.macro.ob.pojo.HomeInformation
*/
@Mapper
public interface HomeInformationMapper extends BaseMapper<HomeInformation> {
    /**
     * 新增咨询
     */
    int addHomeInformation(HomeInformation homeInformation);

    /**
     * 查看咨询
     */
    List<HomeInformation> selectHomeInformation(HomeInformation homeInformation);

    /**
     * 删除咨询
     */
    int delHomeInformationById(HomeInformation homeInformation);

    /**
     * 修改咨询
     */
    int updateHomeInformationById(HomeInformation homeInformation);



}
