package com.sry.springboot.myblog.service.impl;

import com.sry.springboot.myblog.service.CategoryService;
import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {



    @Override
    public PageResult getBlogCategoryPage(PageQueryUtil pageQueryUtil) {
        return null;
    }

    @Override
    public int getTotalCategories() {
        return 0;
    }
}
