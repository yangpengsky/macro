package com.macro.ob.service;


import com.macro.ob.pojo.Resource;

import java.util.List;
import java.util.Map;

/**
* @author huangguo
* @description 针对表【resource(资源列表)】的数据库操作Service
* @createDate 2022-09-08 20:13:30
*/
public interface ResourceService {

    /*
     * OB运营后台：资源列表,查看资源列表信息
     */
    Map<String,Object> selectAllByResourceId(Resource resource);

    /*
     * OB运营后台：资源列表,添加资源列表信息
     */
    Map<String,Object> insertAllResource(Resource resource);

    /*
     * OB运营后台：资源列表,删除单个资源列表信息
     */
    Map<String,Object> deleteByResourceId(Resource resource);

    /*
     * OB运营后台：资源列表,删除多个资源列表信息
     */
    Map<String,Object> deleteAllByResourceId(Integer[] resourceId);

    /*
     * OB运营后台：资源列表,修改资源列表信息
     */
    Map<String,Object> updateByResourceId(Resource resource);

}
