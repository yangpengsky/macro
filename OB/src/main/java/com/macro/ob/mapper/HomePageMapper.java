package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.HomePage;
import com.macro.ob.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
* @author HP
* @description 针对表【home_page(首页公告列表)】的数据库操作Mapper
* @createDate 2022-09-07 14:50:06
* @Entity com.macro.ob.pojo.HomePage
*/
@Mapper
public interface HomePageMapper extends BaseMapper<HomePage> {
    /**
     * 添加普通公告信息
     */
    int addOrdinaryHomePage(HomePage homePage);

    /**
     * 添加紧急公告信息
     */
    int addUrgentHomePage(HomePage homePage);

    /**
     * 查看普通公告信息
     */
    List<HomePage> selectOrdinaryHomePage(HomePage homePage);

    /**
     * 查看紧急公告信息
     */
    List<HomePage> selectUrgentHomePage(HomePage homePage);

    /**
     * 删除公告信息
     */
    int delHomePage(HomePage homePage);

    /**
     * 修改普通公告信息
     */
    int updateOrdinaryHomePage(HomePage homePage);

    /**
     * 修改紧急公告信息
     */
    int updateUrgentHomePage(HomePage homePage);

}
