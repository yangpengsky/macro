package com.macro.ob.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 运营账号表
 * @TableName operating_account
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "operatingaccount")
@ToString
public class OperatingAccount implements Serializable {
    /**
     * 运营账号实体序列号ID
     */
    private static final long serialVersionUID = -4202757144552829723L;
    /**
     * 运营账号编号
     */
    private Integer operationAccountId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 所属机构
     */
    private String affiliation;

    /**
     * 所属产品线
     */
    private String productLine;

    /**
     * 角色
     */
    private String role;

    /**
     * 性别
     */
    private String gender;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private Integer phoneNumber;

    /**
     * 状态
     */
    private String operationAccountState;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

}
