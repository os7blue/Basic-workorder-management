package com.os7blue.pl.gnmr.entity;

import lombok.Data;

/**
* @Description:    Category entity.
* @Author:         os7blue
* @CreateDate:     Create by 18-8-14 下午8:52
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-14 下午8:52
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@Data
public class Category {

    private Integer cid;

    /**
     * 治疗项目名称
     */
    private String categoryName;

    /**
     * 治疗项目价格
     */
    private double categoryPrice = 0;

    /**
     * 定价来源
     */
    private String priceSource;


}
