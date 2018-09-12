package com.os7blue.pl.gnmr.controller;

import com.os7blue.pl.gnmr.entity.Category;
import com.os7blue.pl.gnmr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description:    Category controller
* @Author:         os7blue
* @CreateDate:     Create by 18-9-1 下午9:17
* @UpdateUser:     os7blue
* @UpdateDate:     Update by 18-9-1 下午9:17
* @UpdateRemark:   
* @Version:        1.0
*/

@RequestMapping("/business/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getAllCategory")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategoryList();
    }

    @RequestMapping("/addOneCategory")
    public void addOneCategory(Category category){
        categoryService.addOneCategory(category);
    }

    @RequestMapping("/removeOneCategory")
    public void removeOneCategory(Category category){
        categoryService.removeOneCategory(category);
    }
}
