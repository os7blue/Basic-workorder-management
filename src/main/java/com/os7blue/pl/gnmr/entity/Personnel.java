package com.os7blue.pl.gnmr.entity;

import lombok.Data;

/**
* @Description:    Personnel entity.
* @Author:         os7blue
* @CreateDate:     Create by 18-8-14 下午9:03
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-14 下午9:03
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@Data
public class Personnel {

    private Integer pid;

    private String name;

    private double proportion = 0;
}
