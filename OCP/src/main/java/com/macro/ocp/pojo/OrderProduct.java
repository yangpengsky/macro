package com.macro.ocp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhangkein
 * @Date 2022/09/02
 * @TableName order_product
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class OrderProduct implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 订单编号
     */
    private Integer orderCode;

    /**
     * 产品编号
     */
    private Integer productCode;
}