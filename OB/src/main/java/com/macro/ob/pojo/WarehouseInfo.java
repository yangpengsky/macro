package com.macro.ob.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库信息表
 * @TableName warehouse_info
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "warehouseinfo")
@TableName("warehouse_info")
public class WarehouseInfo implements Serializable {
    /**
     * 仓库编号
     */
    private Integer warehouseCode;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 状态
     */
    private String warehouseStatus;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 仓库地址
     */
    private String warehouseAddress;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 创建时间
     */
    private Date createdTime;

    private static final long serialVersionUID = 1L;

}