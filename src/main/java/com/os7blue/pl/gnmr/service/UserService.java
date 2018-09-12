package com.os7blue.pl.gnmr.service;

import com.os7blue.pl.gnmr.entity.User;
import com.os7blue.pl.gnmr.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean checkUser(User u) {
        User user = userMapper.selectUserByName(u);
        if (user==null){
            return false;
        }
        if (user.getUserName().equals(u.getUserName())&&user.getUserPwd().equals(u.getUserPwd())){
            return true;
        }
        return false;
    }

    public boolean changeUser(String un, String oup, String nup) {
        User user = new User();
        user.setUserName(un);
        user.setUserPwd(nup);
        User u  = userMapper.selectUserByName(user);
        if (u==null){
            return false;
        }else if (u.getUserPwd().equals(oup)){
            userMapper.updateUser(user);
            return true;
        }

        return false;
    }
}
