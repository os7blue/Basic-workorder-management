package com.os7blue.pl.gnmr.utils;

import com.os7blue.pl.gnmr.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
* @Description:    简单的用户权限验证
* @Author:         os7blue
* @CreateDate:     Create by 18-8-13 下午2:57
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-13 下午2:57
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
public class UserState {

    /**
     * session中所储存的用户信息标识
     */
    private static final String USER_STATE_NAME = "userState";

    /**
     * 保存/移除用户登录状态
     * @param request
     * @param user
     * @param activeCode
     */
    public static void setUserState(HttpServletRequest request, User user,int activeCode){
        if (activeCode==0) {
            request.getSession().setAttribute("userState", user);
        }   
        else if (activeCode==1){
            request.getSession().removeAttribute("userState");
        }

    }

    /**
     * 验证session中储存的用户信息
     * @param request
     * @return
     */
    public static boolean checkState(HttpServletRequest request){
        if(null!=request.getSession().getAttribute(USER_STATE_NAME)){
            return true;
        }
        return false;


    }
}
