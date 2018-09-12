package com.os7blue.pl.gnmr.mapper;

import com.os7blue.pl.gnmr.entity.WorkOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Description: 工单操作mapper
 * @Author: os7blue
 * @CreateDate: Create by 18-8-24 下午9:29
 * @UpdateUser: os7blue
 * @UpdateDate: Update by 18-8-24 下午9:29
 * @UpdateRemark: 修改内容:无
 * @Version: 1.0
 */
@Mapper
@Component
public interface WorkOrderMapper {

    /**
     * Add one work order.
     *
     * @param workOrder
     */
    @Insert("INSERT INTO WorkOrder(categoryName,operator,price,source,workDate) VALUES(#{categoryName},#{operator},#{price},#{source},#{workDate})")
    void insertWorkOrder(WorkOrder workOrder);

    /**
     * Get all work order.
     *
     * @return
     */
    @Select("SELECT * FROM WorkOrder ORDER BY wid desc")
    ArrayList<WorkOrder> selectWorkOrderList();

    /**
     * Get work order by work date.
     *
     * @param workOrder
     * @return
     */
    @Select("SELECT * FROM WorkOrder WHERE workDate LIKE '${workDate}%' ORDER BY wid desc")
    ArrayList<WorkOrder> selectWorkOrderListByDate(WorkOrder workOrder);

    /**
     * @param wid
     */
    @Delete("DELETE FROM WorkOrder where wid = #{wid}")
    void deleteWorkOrderById(String wid);

    /**
     * @param proportion
     * @param date
     * @param name
     * @return
     */
    @Select("SELECT (sum(price) * ${proportion}) FROM WorkOrder WHERE workDate LIKE '${date}%' AND operator = '${name}'")
    double selectWorkOrdrWithWage(@Param("proportion") double proportion, @Param("date") String date, @Param("name") String name);
}
