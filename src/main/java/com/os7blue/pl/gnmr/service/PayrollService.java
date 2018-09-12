package com.os7blue.pl.gnmr.service;

import com.os7blue.pl.gnmr.entity.Payroll;
import com.os7blue.pl.gnmr.mapper.PersonnelMapper;
import com.os7blue.pl.gnmr.mapper.WorkOrderMapper;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Autowired
    private PersonnelMapper personnelMapper;

    public List<Payroll> getWage(String date) {
        var plist = personnelMapper.selectAllPersonnel();
        System.out.println(plist);
        var payrollList = new ArrayList<Payroll>();
        for (int i = 0; i < plist.size(); i++) {
            Payroll payroll = new Payroll();
            try {
                payroll.setWage(workOrderMapper.selectWorkOrdrWithWage(plist.get(i).getProportion(), date, plist.get(i).getName()));
            }catch (Exception e){
                System.err.println("没有数据");
                continue;
            }
            payroll.setName(plist.get(i).getName());
            payroll.setTurnover(payroll.getWage() / plist.get(i).getProportion());
            payrollList.add(payroll);
        }
        return payrollList;
    }
}
