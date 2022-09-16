package com.macro.ob.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "page")
public class Page implements Serializable {
    /**
     * 当前页码数
     */
    private Integer pageNum;
    /**
     * 页面要展示的条数
     */
    private Integer pageSize;

    private static final long serialVersionUID = 9142779484796954556L;

}
