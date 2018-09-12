package com.os7blue.pl.gnmr.mapper;

import com.os7blue.pl.gnmr.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Description:    类目操作mapper
* @Author:         os7blue
* @CreateDate:     Create by 18-8-25 下午9:05
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-25 下午9:05
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@Mapper
@Component
public interface CategoryMapper {

    /**
     * Get all category.
     * @return
     */
    @Select("SELECT * FROM Category")
    List<Category> selectAllCategory();

    /**
     * Add One category.
     * @param category
     */
    @Insert("INSERT INTO Category(categoryName,categoryPrice,priceSource) VALUES(#{categoryName},#{categoryPrice},#{priceSource})")
    void insertOneCategory(Category category);

    /**
     * Delete one category by cid.
     * @param category
     */
    @Delete("DELETE FROM Category WHERE cid = #{cid}")
    void deleteOneCategory(Category category);
}
