package com.macro.ob.service;

import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
* @author HP
* @description 针对表【product(产品表)】的数据库操作Service
* @createDate 2022-09-05 10:14:38
*/
public interface ProductService{
    /**
     * 按照条件查询可售产品信息
     */
    Map<String,Object> selectProductByCondition(Product product, Page page);

    /**
     * 添加可售产品信息
     */
    Map<String, Object> addProduct(List<Product> products);

    /**
     * 按照仓库编码删除单个仓库信息
     */
    Map<String, Object> delProductById(Product product);

    /**
     * 批量删除可售产品信息
     */
    Map<String, Object> delProductAll(List<Product> products);
}
