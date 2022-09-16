package com.macro.ocp.controller;

import com.macro.ocp.pojo.Product;
import com.macro.ocp.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
public class ProductController {
    @Resource
    private ProductService productService;

    /**
     * OCP经销商系统：按条件查询产品信息
     **/
    @GetMapping("/selectByCondition")
    Map<String,Object> selectByCondition(@RequestBody Product product){
        return productService.selectByCondition(product);
    }

    /**
     * OCP经销商系统：通过产品编号查询产品信息
     **/
    @GetMapping("/selectByProductCode")
    Map<String,Object> selectByProductCode(Integer productCode){
        return productService.selectByProductCode(productCode);
    }


}
