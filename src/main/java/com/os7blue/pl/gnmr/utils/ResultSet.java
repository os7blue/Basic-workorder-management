package com.os7blue.pl.gnmr.utils;

import lombok.Data;

import java.util.HashMap;


/**
* @Description:    查询结果集处理 根据日期分页
* @Author:         os7blue
* @CreateDate:     Create by 18-8-24 下午11:36
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-24 下午11:36
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@Data
public class ResultSet <T>{

    /**
     * 查询日期
     */
    private String sdate;
    /**
     * 结果集
     */
   private HashMap<String, T> result;

}
