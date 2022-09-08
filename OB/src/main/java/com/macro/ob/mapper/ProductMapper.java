package com.macro.ob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ob.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author HP
* @description 针对表【product(产品表)】的数据库操作Mapper
* @createDate 2022-09-05 10:14:38
* @Entity com.macro.ob.pojo.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    /**
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
     */
    int delProductAll(@Param("products") List<Product> products );
}
