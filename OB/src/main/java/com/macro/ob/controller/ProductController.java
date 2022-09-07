package com.macro.ob.controller;


import com.macro.ob.pojo.Product;
import com.macro.ob.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
public class ProductController {
    @Resource
    private ProductService productService;

    /**
     * OB运营后台：按条件查询产品信息
     **/
    @PostMapping("/selectAllByCondition")
    Map<String,Object> selectByCondition(@RequestBody Product product){
        return productService.selectAllByCondition(product);
    }

    /**
     * OB运营后台：溢价维护，修改溢价
     **/
    @PutMapping("/updateAllByProductCode")
    Map<String,Object> updateAllByProductCode(@RequestBody Product product){
        return productService.updateAllByProductCode(product);
    }

    /**
     * OB运营后台：查看溢价历史记录
     **/
    @PostMapping("/selectRecordsByChange")
    Map<String,Object> selectRecordsByChange(@RequestBody Product product){
        return productService.selectRecordsByChange(product);
    }

}
