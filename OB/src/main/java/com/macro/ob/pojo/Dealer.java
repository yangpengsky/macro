package com.macro.ob.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经销商
 * @TableName dealer
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "dealer")
public class Dealer implements Serializable {
    private static final long serialVersionUID = 6707122368191528510L;
    /**
     * 经销商编码
     */
    private Integer dealerCode;

    /**
     * 经销商名称
     */
    private String dealerName;

    /**
     * 经销商简称
     */
    private String dealerAbbreviation;

    /**
     * 经销商类别
     */
    private String dealerCategory;

    /**
     * 机构编码
     */
    private Integer categoryCode;

    /**
     * 机构名称
     */
    private String organizationName;

    /**
     * 状态
     */
    private String status;

    /**
     * 信用额度
     */
    private BigDecimal creditLine;

    /**
     * 发货额度
     */
    private BigDecimal shipmentQuota;

    /**
     * ocp实际发货余额
     */
    private BigDecimal ocpActualBalance;

    /**
     * 商折余额
     */
    private BigDecimal tradeBookBalance;

    /**
     * 是否溢价
     */
    private Integer ispremium;

    /**
     * 扣款比例
     */
    private BigDecimal deductionProportion;

    /**
     * 预警金额
     */
    private BigDecimal alertAmount;

    /**
     * 已缴备货保证金
     */
    private BigDecimal paidStockDeposit;

    /**
     * 经销商总账号编码
     */
    private Integer accountCode;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 分页的页数
     */
    private Integer pageNum;
    /**
     * 分页的记录数
     */
    private Integer pageSize;

}