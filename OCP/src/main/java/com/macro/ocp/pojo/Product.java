package com.macro.ocp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品表
 * @TableName product
 *@Author huangguo
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "product")
@ToString
public class Product implements Serializable {


    /**
     * 产品编码
     */
    private Integer productCode;

    /**
     * 产品线
     */
    private String productLine;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品简称
     */
    private String productAbbreviation;

    /**
     * 计量单位编码
     */
    private Integer uomCode;

    /**
     * 计量单位名称
     */
    private String uomName;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 类别编码
     */
    private Integer categoryCode;

    /**
     * 大类名称
     */
    private String categoryName;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 售后产品型号
     */
    private String aftersalesModel;

    /**
     * 颜色
     */
    private String productColor;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 提货价
     */
    private BigDecimal pickupPrice;

    /**
     * 开票价
     */
    private BigDecimal ticketPrice;

    /**
     * 标准价
     */
    private BigDecimal standardPrice;

    /**
     * 溢价(按比例)
     */
    private BigDecimal premiumRatio;

    /**
     * 溢价(按额度)
     */
    private BigDecimal premiumLimit;

    /**
     * 生效时间
     */
    private Date effectiveDate;

    /**
     * 失效时间
     */
    private Date expirationTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 修改人
     */
    private String modifyBy;

    /**
     * 销售属性
     */
    private String salesAttributes;

    /**
     * 气种
     */
    private String gasSpecies;

    /**
     * 产品属性
     */
    private String productAttributes;

    /**
     * 体积
     */
    private BigDecimal volume;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 长度
     */
    private BigDecimal length;

    /**
     * 宽度
     */
    private BigDecimal width;

    /**
     * 高度
     */
    private BigDecimal height;

    /**
     * 是否新品
     */
    private String isnewProduct;

    /**
     * 是否销售
     */
    private String issales;

    /**
     * 是否停产
     */
    private String isstopProduction;

    /**
     * 是否暂停生产
     */
    private String issuspendProduction;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态
     */
    private String productStatus;

    /**
     * 出货仓库
     */
    private String shippingWarehouse;

    }
