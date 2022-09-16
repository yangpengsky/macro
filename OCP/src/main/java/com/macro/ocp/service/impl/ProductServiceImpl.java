package com.macro.ocp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ocp.mapper.ProductMapper;
import com.macro.ocp.pojo.Product;
import com.macro.ocp.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author meng
* @description 针对表【product(产品表)】的数据库操作Service实现
* @createDate 2022-09-02 14:39:46
*/
@Service
public class ProductServiceImpl implements ProductService{
    @Resource
    private ProductMapper productMapper;

    /**
     * OCP经销商系统：按条件查询产品信息
     **/
    @Override
    public Map<String, Object> selectByCondition(Product product) {
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(product.getPageNum(),product.getPageSize());
        List<Product> list=productMapper.selectByCondition(product);
        PageInfo pageInfo = new PageInfo(list);
        if(list.size() > 0){
            map.put("code",list.size());
            map.put("info",pageInfo);
            map.put("message","查询成功！");
        }else {
            map.put("code",list.size());
            map.put("info",pageInfo);
            map.put("message","查询失败！");
        }
        return map;
    }

    /**
     * OCP经销商系统：通过产品编号查询产品信息
     **/
    @Override
    public Map<String, Object> selectByProductCode(Integer productCode) {
        Map<String,Object> map=new HashMap<>();
        List<Product> list=productMapper.selectByProductCode(productCode);
        if (list.size()>0){
            map.put("code",list.size());
            map.put("info",list);
            map.put("message","查询成功！");
        }else {
            map.put("code",list.size());
            map.put("info",list);
            map.put("message","查询失败！");
        }
        return map;
    }


}
