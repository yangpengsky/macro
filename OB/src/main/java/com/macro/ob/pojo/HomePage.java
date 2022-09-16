package com.macro.ob.pojo;

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
 * 首页公告列表
 * @TableName home_page
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "homepage")
public class HomePage implements Serializable {
    /**
     * id主键
     */
    private Integer id;
    /**
     * 公告标题
     */
    private String announcementTitle;

    /**
     * 发布日期
     */
    private Date publicationDate;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 失效日期
     */
    private Date expirationDate;

    /**
     * 状态
     */
    private String announcementStatus;

    /**
     * 公告类型
     */
    private String announcementType;

    /**
     * 平台类型
     */
    private String platformType;

    /**
     * 公告图片
     */
    private String announcementPicture;

    /**
     * 公告内容
     */
    private String announcementContents;

    private static final long serialVersionUID = 1L;
}