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
 * 首页资讯列表
 * @TableName home_information
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "homeinformation")
public class HomeInformation implements Serializable {

    /**
     * id主键
     */
    private Integer id;

    /**
     * 资讯标题
     */
    private String informationTitle;

    /**
     * 资讯类型
     */
    private String informationType;

    /**
     * 发布日期
     */
    private Date publicationDate;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 状态
     */
    private String informationStatus;

    /**
     * 标题图片
     */
    private String titlePicture;

    /**
     * 资讯摘要
     */
    private String informationSummary;

    /**
     * 资讯内容
     */
    private String informationContent;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 失效日期
     */
    private Date expirationDate;

    private static final long serialVersionUID = 1L;
}