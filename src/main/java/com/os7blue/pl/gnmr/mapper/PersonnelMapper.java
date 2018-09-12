package com.os7blue.pl.gnmr.mapper;

import com.os7blue.pl.gnmr.entity.Personnel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 人员操作mapper
 * @Author: os7blue
 * @CreateDate: Create by 18-8-25 下午10:20
 * @UpdateUser: os7blue
 * @UpdateDate: Update by 18-8-25 下午10:20
 * @UpdateRemark: 修改内容:无
 * @Version: 1.0
 */
@Mapper
@Component
public interface PersonnelMapper {


    /**
     * Get all personnel.
     * @return
     */
    @Select("SELECT * FROM Personnel")
    List<Personnel> selectAllPersonnel();

    /**
     * Add one personnel.
     * @param personnel
     */
    @Insert("INSERT INTO Personnel(name,proportion) VALUES(#{name},#{proportion})")
    void insertOnePersonnel(Personnel personnel);

    /**
     * Delete one personnel by pid.
     * @param personnel
     */
    @Delete("DELETE FROM Personnel WHERE pid = #{pid}")
    void deleteOnePersonnel(Personnel personnel);
}
