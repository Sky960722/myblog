package com.sry.springboot.myblog.service.impl;

import com.sry.springboot.myblog.dao.BlogTagMapper;
import com.sry.springboot.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Override
    public int getTotalTags() {
        return blogTagMapper.getTotalTags(null);
    }
}
