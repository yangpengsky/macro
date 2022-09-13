package com.macro.ocp.service;


import com.macro.ocp.pojo.Product;

import java.util.Map;

/**
* @author huangguo
* @description 针对表【product(产品表)】的数据库操作Service
* @createDate 2022-09-02 14:39:46
*/
public interface ProductService {
    /**
     * OCP经销商系统：按条件查询产品信息
     **/
    Map<String,Object> selectByCondition(Product product);

    /**
     * OCP经销商系统：通过产品编号查询产品信息
     **/
    Map<String,Object> selectByProductCode(Integer productCode);
}
