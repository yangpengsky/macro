package com.macro.ob.service.impl;
import com.macro.ob.mapper.HomePlatformMapper;
import com.macro.ob.pojo.HomePlatform;
import com.macro.ob.service.HomePlatformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 周学林
* @description 针对表【home_platform(首页信息平台列表)】的数据库操作Service实现
* @createDate 2022-09-08 14:08:59
*/
@Service
public class HomePlatformServiceImpl implements HomePlatformService{
    @Resource
    private HomePlatformMapper homePlatformMapper;
    @Override
    public Map<String, Object> selectInfo() {
        Map<String,Object>map=new HashMap<>();
        List<HomePlatform>list=homePlatformMapper.selectInfo();
        if (list.size()>0){
            map.put("data",list);
            map.put("rows",list.size());
            map.put("flag","查询成功");
        }else {
            map.put("flag","查询失败");
        }
        return map;
    }

    @Override
    public Map<String,Object> addInfo(HomePlatform homePlatform) {
        Map<String,Object>map=new HashMap<>();
        Integer num=homePlatformMapper.addInfo(homePlatform);
        if (num>0){
            map.put("rows",num);
            map.put("flag","提交成功");
        }else {
            map.put("flag","提交失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteInfo(HomePlatform homePlatform) {
        Map<String,Object>map=new HashMap<>();
        Integer num=homePlatformMapper.deleteInfo(homePlatform);
        if(num>0){
            map.put("rows",num);
            map.put("flag","删除成功");
        }else {

            map.put("flag","删除失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> updateInfo(HomePlatform homePlatform) {
        Map<String,Object>map=new HashMap<>();
        Integer num=homePlatformMapper.updateInfo(homePlatform);
        if (num>0){
            map.put("rows",num);
            map.put("flag","修改成功");
        }else {
            map.put("flag","修改失败");
        }
        return map;
    }
}
