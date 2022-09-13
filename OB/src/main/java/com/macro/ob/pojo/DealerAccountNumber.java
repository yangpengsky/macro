package com.macro.ob.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 经销商总账号
 * @TableName dealer_account_number
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "dealeraccountnumber")
public class DealerAccountNumber implements Serializable {
    private static final long serialVersionUID = 5511558547263577173L;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 经销商名称
     */
    private String dealerName;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 手机号码
     */
    private Integer phoneNumber;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态
     */
    private String dealerStatus;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 修改人
     */
    private String modifiedBy;

    /**
     * 密码
     */
    private String password;

    /**
     * 经销商编码
     */
    private Integer accountCode;

    /**
     * 关联编号
     */
    private Integer dealerCode;

    /**
     * 定义数组批量删除经销商账号
     */
    private Integer[] accountCodes;

    /**
     * 定义分页的页数
     */
    private Integer pageNum;

    /**
     * 定义分页的记录数
     */
    private Integer pageSize;

}