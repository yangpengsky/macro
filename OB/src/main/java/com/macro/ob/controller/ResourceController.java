package com.macro.ob.controller;

import com.macro.ob.pojo.Menu;
import com.macro.ob.pojo.Resource;
import com.macro.ob.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class ResourceController {

    @javax.annotation.Resource
            private ResourceService resourceService;

    /*
     * OB运营后台：资源列表,查看资源列表信息
     */
    @GetMapping("/selectAllByResourceId")
    Map<String,Object> selectAllByResourceId(Resource resource){
        return resourceService.selectAllByResourceId(resource);
    };

    /*
     * OB运营后台：资源列表,添加资源列表信息
     */
    @PostMapping("/insertAllResource")
    Map<String,Object> insertAllResource(HttpServletRequest request,@RequestBody Resource resource){
        HttpSession session = request.getSession();
        Map <String,Object> map =resourceService.insertAllResource(resource);
        Resource resource2 = (Resource) map.get("info");
        session.setAttribute("info",resource2);
        return map;
    };

    /*
     * OB运营后台：资源列表,删除单个资源列表信息
     */
    @DeleteMapping("/deleteByResourceId")
    Map<String,Object> deleteByResourceId(Resource resource){
        return resourceService.deleteByResourceId(resource);
    };

    /*
     * OB运营后台：资源列表,删除多个资源列表信息
     */
    @DeleteMapping("/deleteAllByResourceId")
    Map<String,Object> deleteAllByResourceId(@RequestBody Integer[] resourceId){
        return resourceService.deleteAllByResourceId(resourceId);
    };

    /*
     * OB运营后台：资源列表,修改资源列表信息
     */
    @PutMapping("/updateByResourceId")
    Map<String,Object> updateByResourceId(@RequestBody Resource resource){
        return resourceService.updateByResourceId(resource);
    };

}
