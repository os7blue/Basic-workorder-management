package com.os7blue.pl.gnmr.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Description:    处理日期格式的工具类
* @Author:         os7blue
* @CreateDate:     Create by 18-8-25 下午8:16
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-25 下午8:16
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
public class DateUtil {

    public static String getDateNow(){
        return new SimpleDateFormat("yyyy-MM-dd-EEE-HH:mm").format(new Date());
    }

    public static String getDateNowByPattern(String pattern){
        return new SimpleDateFormat(pattern).format(new Date());
    }
}
