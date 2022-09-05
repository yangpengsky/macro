package com.macro.ob.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 工厂库存表
 * @TableName factory_inventory
 */
@Data
@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "factoryinventory")

public class FactoryInventory implements Serializable {
    /**
     * 产品编码
     */

    private Integer productCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品类别
     */
    private String productCategory;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 仓库编码
     */
    private Integer warehouseCode;

    /**
     * 可用数量
     */
    private Integer availableQuantity;

    /**
     * 占用数量
     */
    private Integer occupationQuantity;

    /**
     * 实仓数量
     */
    private Integer realQuantity;

    /**
     * 厨房科技实仓数量
     */
    private Integer kitchenRealQuantity;

    /**
     * 厨房科技占用数量
     */
    private Integer kitchenOccupationQuantity;

    /**
     * 厨房子公司实仓数量
     */
    private Integer kitchenSubsidiaryReal;

    /**
     * 厨房子公司占用数量
     */
    private Integer kitchenSubsidiaryQuantity;

    /**
     * 燃气具实仓数量
     */
    private Integer gasRealQuantity;

    /**
     * 燃气具占用数量
     */
    private Integer gasOccupationQuantity;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private String updatedTime;


}