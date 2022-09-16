package com.macro.ob.mapper;


import com.macro.ob.pojo.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author huangguo
* @description 针对表【resource(资源列表)】的数据库操作Mapper
* @createDate 2022-09-08 20:13:30
* @Entity com.macro.ob.pojo.Resource
*/
@Mapper
public interface ResourceMapper {

    /*
     * OB运营后台：资源列表,查看资源列表信息
     */
    List<Resource> selectAllByResourceId(Resource resource);

    /*
     * OB运营后台：资源列表,添加资源列表信息
     */
    Integer insertAllResource(Resource resource);

    /*
     * OB运营后台：资源列表,删除单个资源列表信息
     */
    Integer deleteByResourceId(Resource resource);

    /*
     * OB运营后台：资源列表,删除多个资源列表信息
     */
    Integer deleteAllByResourceId(Integer[] resourceId);

    /*
     * OB运营后台：资源列表,修改资源列表信息
     */
    Integer updateByResourceId(Resource resource);


}
