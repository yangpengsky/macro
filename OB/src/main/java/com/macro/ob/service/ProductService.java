package com.macro.ob.service;


import com.macro.ob.pojo.Page;
import com.macro.ob.pojo.Product;

import java.util.List;
import java.util.Map;

/**
* @author huangguo
* @description 针对表【product(产品表)】的数据库操作Service
* @createDate 2022-09-02 23:10:27
*/
public interface ProductService {
    /**
     * OB运营后台：按条件查询产品信息
     **/
    Map<String,Object> selectAllByCondition(Product product);

    /**
     * OB运营后台：溢价维护，修改溢价
     **/
    Map<String,Object> updateAllByProductCode(Product product);

    /**
     * OB运营后台：查看溢价历史记录
     **/
    Map<String,Object> selectRecordsByChange(Product product);

    /**
     * OB运营后台：根据订单编号查看产品信息
     * @param orderCode
     * @return
     */
    Map<String,Object> selectProductByOrderCode(Integer orderCode);


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
