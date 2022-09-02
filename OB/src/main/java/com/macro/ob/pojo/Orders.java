package com.macro.ob.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 * @TableName orders
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    private static final long serialVersionUID = -1914901589489311684L;
    /**
     * 订单编号
     */
    private Integer orderCode;

    /**
     * 订单类型（备货/批发）
     */
    private String orderType;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 提货方式
     */
    private String deliveryMethod;

    /**
     * 产品编码
     */
    private Integer productCode;

    /**
     * 出库仓库
     */
    private Integer outWarehouse;

    /**
     * 入库仓库
     */
    private Integer inWarehouse;

    /**
     * 详细送货地址
     */
    private String deliveryAddress;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 联系电话
     */
    private String contactNumber;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 经销商账号编码
     */
    private Integer dealerCode;

    /**
     * 总数量
     */
    private Integer productQuantity;

    /**
     * 总体积
     */
    private BigDecimal bulkVolume;

    /**
     * 总金额
     */
    private BigDecimal aggregateAmount;

    /**
     * 开票价格
     */
    private BigDecimal invoicePrice;

    /**
     * 订单初审人
     */
    private String orderPreliminaryAudit;

    /**
     * 订单复审人
     */
    private String orderReviewAudit;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 下单日期
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 汇总计划编号
     */
    private Integer summaryPlanCode;
}