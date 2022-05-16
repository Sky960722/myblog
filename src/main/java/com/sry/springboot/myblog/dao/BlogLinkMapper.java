package com.sry.springboot.myblog.dao;

import com.sry.springboot.myblog.entity.BlogLink;
import com.sry.springboot.myblog.util.PageQueryUtil;

import java.util.List;

public interface BlogLinkMapper {

    int deleteByPrimaryKey(Integer linkId);

    int insert(BlogLink record);

    int insertSelective(BlogLink record);

    BlogLink selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(BlogLink record);

    int updateByPrimaryKey(BlogLink record);

    List<BlogLink> findLinkList(PageQueryUtil pageUtil);

    int getTotalLinks(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);
}
