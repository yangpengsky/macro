package com.macro.ob.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :yangpeng
 * @date : 2022/9/8
 */
public  class   SimpleDate {

    public static String myDateFormat(Date date){
        String pattern="yyyy/MM/dd HH时mm分ss秒";
        SimpleDateFormat sdf= new SimpleDateFormat(pattern);
        String datestr=sdf.format(date);// format  为格式化方法
        return datestr;
    }

}
