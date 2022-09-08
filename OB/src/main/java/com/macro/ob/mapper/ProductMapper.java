package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
* @author huangguo
* @description 针对表【product(产品表)】的数据库操作Mapper
* @createDate 2022-09-02 23:10:27
* @Entity com.macro.ob.pojo.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * OB运营后台：按条件查询产品信息
     **/
    List<Product> selectAllByCondition(Product product);

    /**
     * OB运营后台：溢价维护，修改溢价
     **/
    Integer updateAllByProductCode(Product product);

    /**
     * OB运营后台：查看溢价历史记录
     **/
    List<Product> selectRecordsByChange(Product product);

    /**
     * OB运营后台：根据订单编号查询产品信息
     * @param orders
     * @return
     */
    List<Product> selectProductByOrderCode(Integer orders);

     /*
     * 按照条件查询可售产品信息
     */
    List<Product> selectProductByCondition(Product product);
    /**
     * 添加可售产品信息
     */
    int addProduct(@Param("products") List<Product> products);
    /**
     * 删除单个可售产品信息
     */
    int delProductById(Product product);

    /**
     * 批量删除可售产品信息
     * @param products
     * @return
     */
    int delProductAll(@Param("products") List<Product> products );

}
