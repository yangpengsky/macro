package com.macro.ob.service.impl;

import com.macro.ob.mapper.HomePageMapper;
import com.macro.ob.pojo.HomeInformation;
import com.macro.ob.service.HomeInformationService;
import com.macro.ob.mapper.HomeInformationMapper;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* @author HP
* @description 针对表【home_information(首页资讯列表)】的数据库操作Service实现
* @createDate 2022-09-08 09:23:02
*/
@Service
public class HomeInformationServiceImpl implements HomeInformationService{

    /**
     * 创建HomeInformationMapper对象
     */
    @Resource
    private HomeInformationMapper homeInformationMapper;

    /**
     * 新增咨询
     */
    public Map<String,Object> addHomeInformation(HomeInformation homeInformation){
        Map<String,Object> map = new ManagedMap<>();
        if(homeInformation.getInformationTitle() == null || homeInformation.getInformationTitle() == ""){
            map.put("message","请输入资讯标题");
        }else if(homeInformation.getEffectiveDate() == null){
            map.put("message","请输入生效日期");
        }else if(homeInformation.getTitlePicture() == null || homeInformation.getTitlePicture() == ""){
            map.put("message","请上传图片");
        }else if(homeInformation.getInformationSummary() == null || homeInformation.getInformationSummary() == ""){
            map.put("message","请上传资讯摘要");
        }else if(homeInformation.getInformationContent() == null || homeInformation.getInformationContent() == ""){
            map.put("message","请上传资讯内容");
        }else{
            homeInformationMapper.addHomeInformation(homeInformation);
            map.put("message","添加成功");
        }
            return map;
    }

    /**
     * 查看咨询
     */
    public Map<String,Object> selectHomeInformation(HomeInformation homeInformation){
        Map<String,Object> map = new ManagedMap<>();
        List<HomeInformation> homeInformations = homeInformationMapper.selectHomeInformation(homeInformation);
        if(homeInformation != null){
            map.put("message","查询成功");
        }else{
            map.put("message","查询失败");
        }
        map.put("数据",homeInformations);
         return map;
    }

    /**
     * 删除咨询
     */
    public Map<String,Object> delHomeInformationById(HomeInformation homeInformation){
        Map<String,Object> map = new ManagedMap<>();
        int i = homeInformationMapper.delHomeInformationById(homeInformation);
        if(i > 0){
            map.put("message","删除成功");
        }else{
            map.put("message","删除失败");
        }
           return map;
    }

    /**
     * 修改咨询
     */
    public Map<String,Object> updateHomeInformationById(HomeInformation homeInformation){
        Map<String,Object> map = new ManagedMap<>();
        int i = homeInformationMapper.updateHomeInformationById(homeInformation);
        if(i > 0){
            map.put("message","修改成功");
        }else{
            map.put("message","修改失败");
        }
        return map;
    }
}
