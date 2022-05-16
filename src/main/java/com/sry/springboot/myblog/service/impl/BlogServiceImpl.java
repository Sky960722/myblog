package com.sry.springboot.myblog.service.impl;

import com.sry.springboot.myblog.dao.BlogMapper;
import com.sry.springboot.myblog.entity.Blog;
import com.sry.springboot.myblog.service.BlogService;
import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public String saveBlog(Blog blog) {
        return null;
    }

    @Override
    public PageResult getBlogsPage(PageQueryUtil pageUtil) {
        return null;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public int getTotalBlogs() {
        return blogMapper.getTotalBlogs(null);
    }

    @Override
    public Blog getBlogById(Long blogId) {
        return null;
    }

    @Override
    public String updateBlog(Blog blog) {
        return null;
    }

    @Override
    public PageResult getBlogsForIndexPage(int page) {
        return null;
    }
}
