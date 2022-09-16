package com.macro.ob.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ob.mapper.ResourceMapper;
import com.macro.ob.pojo.Resource;
import com.macro.ob.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author meng
* @description 针对表【resource(资源列表)】的数据库操作Service实现
* @createDate 2022-09-08 20:13:30
*/
@Service
public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    /*
     * OB运营后台：资源列表,查看资源列表信息
     */
    @Override
    public Map<String, Object> selectAllByResourceId(Resource resource) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(resource.getPageNum(),resource.getPageSize());
        List<Resource> list = resourceMapper.selectAllByResourceId(resource);
        PageInfo pageInfo =new PageInfo(list);
        if (list.size() > 0) {
            map.put("code", list.size());
            map.put("info", pageInfo);
            map.put("message", "查询资源成功！");
        } else {
            map.put("code", list.size());
            map.put("info", pageInfo);
            map.put("message", "查询资源失败！");
        }
        return map;
    }

    /*
     * OB运营后台：资源列表,添加资源列表信息
     */
    @Override
    public Map<String, Object> insertAllResource(Resource resource) {
        Map<String,Object> map = new HashMap<>();
        Integer integer = resourceMapper.insertAllResource(resource);
        if (integer>0){
            map.put("code",integer);
            map.put("message","插入资源列表成功!");
        }else{
            map.put("code",integer);
            map.put("message","插入资源列表失败!");
        }
        return map;
    }

    /*
     * OB运营后台：资源列表,删除单个资源列表信息
     */
    @Override
    public Map<String, Object> deleteByResourceId(Resource resource) {
        Map<String,Object> map = new HashMap<>();
        Integer integer = resourceMapper.deleteByResourceId(resource);
        if (integer>0){
            map.put("code",integer);
            map.put("message","删除成功!");
        }else{
            map.put("code",integer);
            map.put("message","删除失败!");
        }
        return map;
    }

    /*
     * OB运营后台：资源列表,删除多个资源列表信息
     */
    @Override
    public Map<String, Object> deleteAllByResourceId(Integer[] resourceId) {
        Map<String,Object> map = new HashMap<>();
        Integer integer = resourceMapper.deleteAllByResourceId(resourceId);
        if (integer>0){
            map.put("code",integer);
            map.put("message","删除多个资源列表成功!");
        }else{
            map.put("code",integer);
            map.put("message","删除多个资源列表失败!");
        }
        return map;
    }

    /*
     * OB运营后台：资源列表,修改资源列表信息
     */
    @Override
    public Map<String, Object> updateByResourceId(Resource resource) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = resourceMapper.updateByResourceId(resource);
        if (integer > 0) {
            map.put("code", integer);
            map.put("message", "修改资源列表成功!");
        } else {
            map.put("code", integer);
            map.put("message", "修改资源列表失败!");
        }
        return map;
    }

}
