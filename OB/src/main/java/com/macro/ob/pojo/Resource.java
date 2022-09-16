package com.macro.ob.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源列表
 * @author huangguo
 * @TableName resource
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = -3613946538589852106L;

    /**
     * 资源编号
     */
    private Integer resourceId;

    /**
     * 按钮名称
     */
    private String buttonName;

    /**
     * 权限标识
     */
    private String permissionsLogo;

    /**
     * 资源路径
     */
    private String resourcePath;

    /**
     * 提交方式
     */
    private String method;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 显示页码
     */
    private Integer pageNum;

    /**
     * 显示条数
     */
    private Integer pageSize;


}