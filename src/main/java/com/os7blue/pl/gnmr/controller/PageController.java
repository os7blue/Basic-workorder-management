package com.os7blue.pl.gnmr.controller;

import com.os7blue.pl.gnmr.service.WorkOrderService;
import com.os7blue.pl.gnmr.utils.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
* @Description:    页面跳转controller
* @Author:         os7blue
* @CreateDate:     Create by 18-8-13 下午3:41
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-13 下午3:41
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@Controller
public class PageController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private WorkOrderService workOrderService;

    @RequestMapping("/")
    public String gotoIndex(){
        return "/login.html";
    }

    @RequestMapping("/noLogin")
    public String gotoNoLogin(){
        return "/noLogin.html";
    }

    @RequestMapping("/login")
    public String gotoLogin(){
        if (UserState.checkState(request)) {
            return "/business";
        }
            return "/login.html";
    }

    @RequestMapping("/business")
    public String gotoBusiness(){

        return "/business.html";
    }

    @RequestMapping("/loginOut")
    public String gotoLoginOut(){
        UserState.setUserState(request,null,1);
        return "/noLogin";
    }

}
