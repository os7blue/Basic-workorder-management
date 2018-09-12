package com.os7blue.pl.gnmr.mapper;

import com.os7blue.pl.gnmr.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Select("SELECT * FROM User WHERE userName = '${userName}'")
    User selectUserByName(User u);

    @Update("UPDATE User SET userPwd = '${userPwd}' WHERE userName = '${userName}'")
    void updateUser(User user);
}
