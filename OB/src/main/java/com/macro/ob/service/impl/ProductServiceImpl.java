package com.macro.ob.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.ob.mapper.ProductMapper;
import com.macro.ob.pojo.Product;
import com.macro.ob.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author huangguo
* @description 针对表【product(产品表)】的数据库操作Service实现
* @createDate 2022-09-02 23:10:27
*/
@Service
public class ProductServiceImpl implements ProductService{
    @Resource
    private ProductMapper productMapper;

    /**
     * OB运营后台：按条件查询产品信息
     **/
    @Override
    public Map<String, Object> selectAllByCondition(Product product) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(product.getPageNum(), product.getPageSize());
        List<Product> list = productMapper.selectAllByCondition(product);
        PageInfo pageInfo =new PageInfo(list);
        if (list.size() > 0) {
            map.put("code", list.size());
            map.put("info", pageInfo);
            map.put("message", "查询成功！");
        } else {
            map.put("code", list.size());
            map.put("info", pageInfo);
            map.put("message", "查询失败！");
        }
        return map;
    }

    /**
     * OB运营后台：溢价维护，修改溢价
     **/
    @Override
    public Map<String, Object> updateAllByProductCode(Product product) {
        Map<String,Object> map= new HashMap<>();
        if (productMapper.updateAllByProductCode(product)>0){
            map.put("code", 1);
            map.put("message", "添加溢价信息成功！");
        }else {
            map.put("code", 0);
            map.put("message", "添加溢价信息失败！");
        }
        return map;
    }

    /**
     * OB运营后台：查看溢价历史记录
     **/
    @Override
    public Map<String, Object> selectRecordsByChange(Product product) {
        Map<String, Object> map = new HashMap<>();
        List<Product> list = productMapper.selectRecordsByChange(product);
        if (list.size() > 0) {
            map.put("code", list.size());
            map.put("info", list);
            map.put("message", "查询成功！");
        } else {
            map.put("code", list.size());
            map.put("info", list);
            map.put("message", "查询失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> selectProductByOrderCode(Integer orderCode) {
        List<Product> list = productMapper.selectProductByOrderCode(orderCode);
        Map<String, Object> map = new HashMap<>();
                 if (list.size()>0){
                     map.put("code", 0);
                     map.put("flag", true);
                     map.put("row",list.size());
                     map.put("info", list);
                     map.put("message", "查询成功！");
                 }else {

                     map.put("code", 0);
                     map.put("flag", false);
                     map.put("message", "查询失败！");
                 }
        return map;
    }

}
