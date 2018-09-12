package com.os7blue.pl.gnmr.service;

import com.os7blue.pl.gnmr.entity.Personnel;
import com.os7blue.pl.gnmr.mapper.PersonnelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
* @Description:
* @Author:         os7blue
* @CreateDate:     Create by 18-8-25 下午10:27
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-25 下午10:27
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@Service
public class PersonnelService {

    @Autowired
    private PersonnelMapper personnelMapper;

    public List<Personnel> getAllPersonnel(){
        return personnelMapper.selectAllPersonnel();
    }

    public void addOnePersonnel(Personnel personnel) {
        personnelMapper.insertOnePersonnel(personnel);
    }

    public void removeOnePersonnel(Personnel personnel) {
        personnelMapper.deleteOnePersonnel(personnel);
    }
}
