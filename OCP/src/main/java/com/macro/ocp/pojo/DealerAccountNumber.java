package com.macro.ocp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 经销商总账号
 *
 * @author zhangkein
 * @date 2022/09/05
 * @TableName dealer_account_number
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@ConfigurationProperties(prefix = "account")
public class DealerAccountNumber implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 3261968056686270559L;
    /**
     * 账号编码
     */
    private Integer accountCode;


    /**
     * 用户名
     */
    private String userName;


    /**
     * 联系人
     */
    private String contacts;

    /**
     * 性别
     */
    private String gender;

    /**
     * 手机号码
     */
    private String phoneNumber;

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
     * 原密码
     */
    @TableField(exist = false)
    private String originPassword;

    /**
     * 父账号编码
     */
    private Integer parentAccountCode;

    /**
     * 角色
     */
    private String role;

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