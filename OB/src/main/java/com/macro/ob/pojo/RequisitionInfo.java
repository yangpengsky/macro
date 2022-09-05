package com.macro.ob.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 调拨单信息
 * @TableName requisition_info
 */
@Data
@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "requisitioninfo")
@TableName("requisition_info")
public class RequisitionInfo implements Serializable {
    /**
     * 调拨单号
     */
    private Integer requisitionCode;

    /**
     * 调拨类型
     */
    private String requisitionType;

    /**
     * 调出仓库编码
     */
    private Integer outWarehouseCode;

    /**
     * 调出仓库名称
     */
    private String outWarehouseName;

    /**
     * 调入仓库编码
     */
    private Integer inWarehouseCode;

    /**
     * 调入仓库名称
     */
    private String inWarehouseName;

    /**
     * 产品编码
     */
    private Integer productCode;

    /**
     * 调拨数量
     */
    private Integer requisitionNumber;

    /**
     * 单位
     */
    private String productUnit;

    /**
     * 调出机构编码
     */
    private Integer outOrganizationCode;

    /**
     * 调入机构编码
     */
    private Integer inOrganizationCode;

    /**
     * 调出机构名称
     */
    private String outOrganizationName;

    /**
     * 调入机构名称
     */
    private String inOrganizationName;

    /**
     * 创建人
     */
    private String initiator;

    /**
     * 发运方式
     */
    private String deliverStyle;

    /**
     * 经销商编码
     */
    private Integer dealerCode;

    /**
     * 经销商名称
     */
    private String dealerName;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货人电话
     */
    private String consigneePhone;

    /**
     * 收货地址
     */
    private String consigneeAddress;

    /**
     * 收货人身份证
     */
    private String consigneeIdentity;

    /**
     * 调拨总体积
     */
    private BigDecimal requisitionTotalVolume;

    /**
     * 发往城市
     */
    private String sendCity;

    /**
     * 备注
     */
    private String note;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 备货计划订单编号
     */
    private Integer orderCode;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String stopTime;

    /**
     * 产品类别
     */
    private String categoryName;

    /**
     * 产品名称
     */
    private String productName;




}