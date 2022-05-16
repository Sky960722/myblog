package com.sry.springboot.myblog.dao;

import com.sry.springboot.myblog.entity.BlogComment;
import com.sry.springboot.myblog.entity.BlogConfig;

import java.util.List;

public interface BlogConfigMapper {
    List<BlogConfig> selectAll();

    BlogConfig selectByPrimaryKey(String configName);

    int updateByPrimaryKeySelective(BlogConfig record);
}
