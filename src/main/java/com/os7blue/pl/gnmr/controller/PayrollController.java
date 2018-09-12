package com.os7blue.pl.gnmr.controller;

import com.os7blue.pl.gnmr.entity.Payroll;
import com.os7blue.pl.gnmr.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description:    Payroll controller
* @Author:         os7blue
* @CreateDate:     Create by 18-9-1 下午9:17
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-9-1 下午9:17
* @UpdateRemark:   
* @Version:        1.0
*/

@RequestMapping("/business/payroll")
@RestController
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @RequestMapping("/getPayroll")
    public List<Payroll> getPayroll(String date){
        System.out.println(date);
        return payrollService.getWage(date);

    }


}


