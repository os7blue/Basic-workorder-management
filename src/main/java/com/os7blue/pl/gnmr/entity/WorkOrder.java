package com.os7blue.pl.gnmr.entity;

import lombok.Data;

/**
 * @Description: Work order entity.
 * @Author: os7blue
 * @CreateDate: Create by 18-8-14 下午8:55
 * @UpdateUser: os7blue
 * @UpdateDate: Update by 18-8-14 下午8:55
 * @UpdateRemark: 修改内容:无
 * @Version: 1.0
 */
@Data
public class WorkOrder {

    private Integer wid;

    /**
     * 项目名称
     */
    private String categoryName;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 价格
     */
    private double price = 0;

    /**
     * 顾客来源
     */
    private String source;

    /**
     * 操作时间
     */
    private String workDate;

}
