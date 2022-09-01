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
 * 经销商
 * @TableName dealer
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ConfigurationProperties(prefix = "dealer")
public class Dealer implements Serializable {
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
     * 机构名称
     */
    private String organizationName;

    /**
     * 经销商类别
     */
    private String dealerCategory;

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
     * 是否删除
     */
    private Integer isdelete;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}