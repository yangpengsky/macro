package com.macro.ocp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 * @TableName role
 * @author zhangkein
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ConfigurationProperties(prefix = "role")
public class Role implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 6744229412288503104L;
    /**
     * 角色编号
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 状态
     */
    private String roleStatus;

    /**
     * 角色描述
     */
    private String roleDescribe;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

}