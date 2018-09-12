package com.os7blue.pl.gnmr;

import com.os7blue.pl.gnmr.service.PersonnelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GnmrApplicationTests {

    @Autowired
    private PersonnelService personnelService;
    @Test
    public void contextLoads() {
       /* for (int i = 0; i < 10; i++) {
            Personnel personnel = new Personnel();
            personnel.setName("操作人"+i+"号");
            personnelService.addOnePersonnel(personnel);
        }*/
    }

}
