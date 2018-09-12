package com.os7blue.pl.gnmr.controller;


import com.os7blue.pl.gnmr.entity.User;
import com.os7blue.pl.gnmr.service.UserService;
import com.os7blue.pl.gnmr.utils.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
* @Description:    java类作用描述
* @Author:         os7blue
* @CreateDate:     Create by 18-8-24 下午11:01
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-24 下午11:01
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@RestController
@RequestMapping(value = "/u")
public class UserController {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param u
     * @return
     */
    @RequestMapping(value = "/login")
    public HashMap<String, String> login(User u){
        HashMap<String, String> map = new HashMap<>();
        boolean status = userService.checkUser(u);

        if (status){
            System.out.println(true);
            UserState.setUserState(request,u,0);
            map.put("Text","登录成功，正在跳转");
            map.put("Status","ok");
        }else {
            System.out.println(false);
            map.put("Text","登录失败，返回重新登录");
            map.put("status","error");
        }
        return map;

    }

    @RequestMapping("/changeUser")
    public String changeUser(String un,String oup,String nup){
        boolean staus=userService.changeUser(un,oup,nup);
        if (staus){
            UserState.setUserState(request,null,1);
            return "ok";
        }else {
            return "err";
        }
    }



}
