package com.sry.springboot.myblog.service;

import com.sry.springboot.myblog.entity.BlogCategory;
import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.PageResult;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface CategoryService {

    /**
     * 查询分类的分页数据
     * @param pageQueryUtil 保存从前端传来的页数，和分页的条数
     * @return
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageQueryUtil);

    /**
     * 返回总的博客种类数目
     * @return
     */
    int getTotalCategories();

    /**
     * 添加分类数据
     * @param categoryName
     * @param categoryIcon
     * @return
     */
    Boolean saveCategory(String categoryName,String categoryIcon);

    /**
     * 修改分类
     * @param categoryId
     * @param categoryName
     * @param categoryIcon
     * @return
     */
    Boolean updateCategory(Integer categoryId,String categoryName,String categoryIcon);

    /**
     * 批量删除博客分类
     * @param ids
     * @return
     */
    Boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();

}
