package com.macro.ob.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单表
 * @TableName menu
 * @author huangguo
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 337264366090186916L;

    /**
     * 菜单编号
     */
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单标识
     */
    private String menuLogo;

    /**
     * 菜单url
     */
    private String menuUrl;

    /**
     * 资源
     */
    private String resources;

    /**
     * icon
     */
    private String icon;

    /**
     * 排序号
     */
    private Integer orderNumber;

    /**
     * 资源编号
     */
    private Integer resourceId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 资源编号
     */
    private Integer pageNum;

    /**
     * 资源编号
     */
    private Integer pageSize;



}