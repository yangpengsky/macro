package com.macro.ob.service.impl;


import com.macro.ob.pojo.HomePage;
import com.macro.ob.service.HomePageService;
import com.macro.ob.mapper.HomePageMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
* @author HP
* @description 针对表【home_page(首页公告列表)】的数据库操作Service实现
* @createDate 2022-09-07 14:50:06
*/
@Service
public class HomePageServiceImpl implements HomePageService{
    /**
     * 创建HomePage对象
     */
    @Resource
    private HomePageMapper homePageMapper;

    /**
     * ordinaryHomePage = "普通公告"
     */
    @Value("${String.ordinaryHomePage}")
    private String ordinaryHomePage;


    /**
     * 添加公告信息
     */
    public Map<String,Object> addHomePage(HomePage homePage){
        Map<String,Object> map = new ManagedMap<>();
        if(homePage.getAnnouncementType().equals(ordinaryHomePage)){
                if (homePage.getPlatformType() == null || homePage.getPlatformType().equals("")) {
                    map.put("message", "信息不全");
                } else if (homePage.getAnnouncementTitle() == null || homePage.getAnnouncementTitle().equals("")) {
                    map.put("message", "信息不全");
                } else if (homePage.getEffectiveDate() == null) {
                    map.put("message", "信息不全");
                } else if (homePage.getExpirationDate() == null) {
                    map.put("message", "信息不全");
                } else if (homePage.getAnnouncementPicture() == null || homePage.getAnnouncementPicture().equals("")) {
                    map.put("message", "信息不全");
                } else if (homePage.getAnnouncementContents() == null || homePage.getAnnouncementContents().equals("")) {
                    map.put("message", "信息不全");
                } else {
                    homePageMapper.addOrdinaryHomePage(homePage);
                    map.put("message", "添加成功");
                }
        }else{
                if(homePage.getPlatformType() == null || homePage.getPlatformType().equals("")) {
                        map.put("message", "信息不全");
                }else if (homePage.getAnnouncementTitle() == null || homePage.getAnnouncementTitle().equals("")) {
                        map.put("message", "信息不全");
                }else if (homePage.getEffectiveDate() == null) {
                        map.put("message", "信息不全");
                }else if (homePage.getExpirationDate() == null) {
                        map.put("message", "信息不全");
                }else {
                        homePageMapper.addUrgentHomePage(homePage);
                        map.put("message", "添加成功");
                }
             }
                        return map;
    }

    /**
     * 删除公告信息
     */
    public Map<String,Object> delHomePage(HomePage homePage){
        Map<String,Object> map = new ManagedMap<>();
        int i = homePageMapper.delHomePage(homePage);
        if(i > 0){
            map.put("message","删除成功");
        }else{
            map.put("message","删除失败");
        }
        return map;
    }

    /**
     * 查看公告信息
     */
    public Map<String,Object> selectHomePage(HomePage homePage){
        if(homePage.getAnnouncementType().equals(ordinaryHomePage)){
            Map<String,Object> map = new ManagedMap<>();
            List<HomePage> homePages = homePageMapper.selectOrdinaryHomePage(homePage);
            if(homePages != null){
                map.put("message","查询成功");
                map.put("查询数据",homePages);
            }else{
                map.put("message","查询失败");
                map.put("查询数据",homePages);
            }
            return map;

        }else{
            Map<String,Object> map = new ManagedMap<>();
            List<HomePage> homePages = homePageMapper.selectUrgentHomePage(homePage);
            if(homePages != null){
                map.put("message","查询成功");
                map.put("查询数据",homePages);
            }else{
                map.put("message","查询失败");
                map.put("查询数据",homePages);
            }
            return map;
        }
    }

    /**
     * 修改公告信息
     */
    public Map<String,Object> updateHomePage(HomePage homePage){
        Map<String,Object> map = new ManagedMap<>();
        if(homePage.getAnnouncementType().equals(ordinaryHomePage)){
            int i = homePageMapper.updateOrdinaryHomePage(homePage);
            if(i > 0){
                map.put("message","修改成功");
            }else{
                map.put("message","修改失败");
            }
            return map;
        }else{
            int i = homePageMapper.updateUrgentHomePage(homePage);
            if(i > 0){
                map.put("message","修改成功");
            }else{
                map.put("message","修改失败");
            }
            return map;
        }
    }
}
