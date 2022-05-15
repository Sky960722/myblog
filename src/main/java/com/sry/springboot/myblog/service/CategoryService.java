package com.sry.springboot.myblog.service;

import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.PageResult;

public interface CategoryService {

    /**
     * 查询分类的分页数据
     * @param pageQueryUtil 保存从前端传来的页数，和条数
     * @return
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageQueryUtil);

    /**
     *
     * @return
     */
    int getTotalCategories();
}
