package com.macro.ob.service.impl;


import com.github.pagehelper.PageHelper;
import com.macro.ob.mapper.WarehouseInfoMapper;
import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.Product;
import com.macro.ob.pojo.WarehouseInfo;
import com.macro.ob.service.ProductService;
import com.macro.ob.mapper.ProductMapper;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author HP
* @description 针对表【product(产品表)】的数据库操作Service实现
* @createDate 2022-09-05 10:14:38
*/
@Service
public class ProductServiceImpl implements ProductService {
    /**
     * 创建Product对象
     */
    @Resource
    private ProductMapper productMapper;

    /**
     * 按照条件查询可售产品信息
     */
    public Map<String, Object> selectProductByCondition(Product product, Page page) {
        Map<String, Object> map = new ManagedMap<>();
        /** 分页查询*/
        if(page.getPageNum()==null) {
            page.setPageNum(1);
        }
        if(page.getPageSize()==null){
            page.setPageSize(10);
        }
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Product> products = productMapper.selectProductByCondition(product);
        if (products != null) {
            map.put("message", "查询成功");
            map.put("info", products);
        } else {
            map.put("message", "查询失败");
            map.put("info", products);
        }
        return map;
    }

    /**
     * 添加可售产品信息
     */
    public Map<String, Object> addProduct(List<Product> pro) {
        Map<String, Object> map = new HashMap<>();
        int number = productMapper.addProduct(pro);
        for (int i = 0; i < number; i++) {
            if (pro.get(i).getProductModel() == null) {
                map.put("message", "数据输入不全");
            } else if (pro.get(i).getProductName() == null) {
                map.put("message", "数据输入不全");
            } else if (pro.get(i).getCategoryName() == null) {
                map.put("message", "数据输入不全");
            } else if (pro.get(i).getGasSpecies() == null) {
                map.put("message", "数据输入不全");
            } else if (pro.get(i).getProductAttributes() == null) {
                map.put("message", "数据输入不全");
            } else {
                map.put("message", "数据插入成功");
            }
        }
        map.put("product", pro);
        return map;
    }

    /**
     * 按照仓库编码删除单个仓库信息
     */
    public Map<String, Object> delProductById(Product product){
        Map<String, Object> map = new HashMap<>();
        int i = productMapper.delProductById(product);
        if (i > 0) {
            map.put("message", "删除成功");
        } else {
            map.put("message", "删除失败");
        }
           return map;
    }

    /**
     * 批量删除可售产品信息
     */
    public Map<String, Object> delProductAll(List<Product> products){
        Map<String, Object> map = new HashMap<>();
        int i = productMapper.delProductAll(products);
        if (i > 0) {
            map.put("message", "删除成功");
        } else {
            map.put("message", "删除失败");
        }
        return map;
    }
}
