package com.macro.ob.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 首页信息平台列表
 * @TableName home_platform
 */
@Data
public class HomePlatform implements Serializable {
    /**
     * 信息平台名称
     */
    private String platformName;

    /**
     * 信息平台地址
     */
    private String platformAddress;

    /**
     * 信息平台图片
     */
    private String platformPicture;

    /**
     * 状态
     */
    private String platformStatus;

    /**
     * 唯一标识
     */
    private Integer id;


}