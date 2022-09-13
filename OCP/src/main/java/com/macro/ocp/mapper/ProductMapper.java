package com.macro.ocp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.ocp.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author huangguo
* @description 针对表【product(产品表)】的数据库操作Mapper
* @createDate 2022-09-02 14:39:46
* @Entity com.macro.ocp.pojo.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * OCP经销商系统：按条件查询产品信息
     **/
    List<Product> selectByCondition(Product product);

    /**
     * OCP经销商系统：通过产品编号查询产品信息
     **/
    List<Product> selectByProductCode(Integer productCode);


}
