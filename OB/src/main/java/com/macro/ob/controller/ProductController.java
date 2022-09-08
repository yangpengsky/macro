package com.macro.ob.controller;

import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.Product;
import com.macro.ob.pojo.WarehouseInfo;
import com.macro.ob.service.ProductService;
import com.macro.ob.service.WarehouseInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品信息表的控制层实现
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    /**
     * 创建产品信息业务层对象
     */
    @Resource
    private ProductService productService;
    /**
     * 查询可售产品信息方法
     */
    @GetMapping(value = "/getProduct")
    public Map<String,Object> selectByCondition(Product pro, Page page){
        Map<String, Object>  productInfo = productService.selectProductByCondition(pro, page);
        return productInfo;
    }

    /**
     * 添加产品信息方法
     */
    @PostMapping(value = "/addProduct")
    public Map <String, Object> addEmpInfo(@RequestBody List<Product> product)
    {
        return productService.addProduct(product);
    }

    /**
     * 按照仓库编码删除单个仓库信息
     */
    @DeleteMapping(value = "/delProductById")
    public Map<String, Object> delProductById(Product product){
        return productService.delProductById(product);
    }

    @DeleteMapping(value = "/delProductAll")
    /**
     * 批量删除可售产品信息
     */
    public Map<String, Object> delProductAll(@RequestBody List<Product> products){
        return productService.delProductAll(products);
    }
}
