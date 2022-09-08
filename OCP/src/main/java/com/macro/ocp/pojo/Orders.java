package com.macro.ocp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 订单表
 * @TableName orders
 * @author zhangkein
 * @date 2022/09/02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@ConfigurationProperties(prefix ="orders")
public class Orders implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1433195924491995575L;
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
     * OB系统订单状态
     */
    private String obOrderStatus;
    /**
     * 提货方式
     */
    private String deliveryMethod;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    /**
     * 汇总计划编号
     */
    private Integer summaryPlanCode;
    /**
     * 产品编号数组
     */
    @TableField(exist = false)
    private Integer[] productCodes;
    /**
     * （用于查询） 开始查询时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * （用于查询） 结束查询时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    /**
     * （用于查询） 开始范围的金额
     */
    @TableField(exist = false)
    private Double startAggregateAmount;
    /**
     * （用于查询） 结束范围金额
     */
    @TableField(exist = false)
    private Double endAggregateAmount;
    /**
     * 查询的页数
     */
    @TableField(exist = false)
    private Integer pageNum;
    /**
     * 查询的页面大小
     */
    @TableField(exist = false)
    private Integer pageSize;
}