package com.sry.springboot.myblog.service.impl;

import com.sry.springboot.myblog.dao.BlogCommentMapper;
import com.sry.springboot.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Override
    public int getTotalComment() {
        return blogCommentMapper.getTotalBlogComments(null);
    }
}
