package com.os7blue.pl.gnmr.controller;

import com.os7blue.pl.gnmr.entity.Personnel;
import com.os7blue.pl.gnmr.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description:    人员管理controller
* @Author:         os7blue
* @CreateDate:     Create by 18-8-25 下午10:27
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-25 下午10:27
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@RequestMapping("/business/personnel")
@RestController
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @RequestMapping("/getAllPersonnel")
    public List<Personnel> getAllPersonnel(){
        return personnelService.getAllPersonnel();
    }

    @RequestMapping("/removeOnePersonnel")
    public void removeOnePersonnel(Personnel personnel){
        personnelService.removeOnePersonnel(personnel);
    }

    @RequestMapping("/addOnePersonnel")
    public void addOnePersonnel(Personnel personnel){
        personnelService.addOnePersonnel(personnel);
    }
}
