package com.os7blue.pl.gnmr.service;

import com.os7blue.pl.gnmr.entity.Category;
import com.os7blue.pl.gnmr.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:    类目操作业务逻辑
* @Author:         os7blue
* @CreateDate:     Create by 18-8-25 下午9:10
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-8-25 下午9:10
* @UpdateRemark:   修改内容:无
* @Version:        1.0
*/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getAllCategoryList(){
        return categoryMapper.selectAllCategory();
    }

    public void addOneCategory(Category category){
        categoryMapper.insertOneCategory(category);
    }

    public void removeOneCategory(Category category) {

        categoryMapper.deleteOneCategory(category);
    }
}
