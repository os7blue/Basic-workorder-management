package com.os7blue.pl.gnmr.controller;

import com.os7blue.pl.gnmr.entity.WorkOrder;
import com.os7blue.pl.gnmr.service.WorkOrderService;
import com.os7blue.pl.gnmr.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
* @Description:    业务操作相关controller
* @Author:         os7blue
* @CreateDate:     Create by 18-8-24 下午8:23
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-24 下午8:23
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@RequestMapping("/business/workOrder")
@RestController
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;
    
    /**
     * 获取所有工单
     * @return
     */
    @RequestMapping("/getAllWorkOrderList")
    public ArrayList<WorkOrder> getAllWorkOrderList(){
        return workOrderService.getAllWorkOrder();
    }

    /**
     * 添加一个工单
     * @param workOrder
     */
    @RequestMapping("/addOneWorkOrder")
    public void addOneWorkOrder(WorkOrder workOrder){

        workOrderService.addOneWorkOrder(workOrder);
    }

    /**
     * 根据日期查询工单
     * @param workOrder
     * @return
     */
    @RequestMapping("/getWorkOrderListByDate")
    public ArrayList<WorkOrder> getWorkOrderListByDate(WorkOrder workOrder){
        System.out.println(workOrder);
        return workOrderService.getWorkOrderListByDate(workOrder);
    }

    /**
     * 根据id删除工单
     * @param wid
     */
    @RequestMapping("/removeWorkOrderById")
    public void removeWorkOrderById(String wid){
        workOrderService.removeWorkOrderById(wid);

    }

    @RequestMapping("/getTime")
    public String getTime(){
        return DateUtil.getDateNowByPattern("yyyy-MM-dd");
    }

}
