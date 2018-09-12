package com.os7blue.pl.gnmr.service;

import com.os7blue.pl.gnmr.entity.WorkOrder;
import com.os7blue.pl.gnmr.mapper.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
* @Description:    工单service
* @Author:         os7blue
* @CreateDate:     Create by 18-8-24 下午9:36
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-24 下午9:36
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@Service
public class WorkOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    public void addOneWorkOrder(WorkOrder wk){
       workOrderMapper.insertWorkOrder(wk);

    }

    public ArrayList<WorkOrder> getAllWorkOrder(){
        return workOrderMapper.selectWorkOrderList();
    }

    public ArrayList<WorkOrder> getWorkOrderListByDate(WorkOrder workOrder) {
        return workOrderMapper.selectWorkOrderListByDate(workOrder);
    }

    public String removeWorkOrderById(String wid) {
        workOrderMapper.deleteWorkOrderById(wid);
        return "200";
    }
}
