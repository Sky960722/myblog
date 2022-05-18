package com.sry.springboot.myblog.service;

import com.sry.springboot.myblog.entity.BlogTagCount;
import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.PageResult;
import com.sry.springboot.myblog.util.Result;

import java.util.List;

public interface TagService {

    /**
     * 查询标签总数
     * @return
     */
    int getTotalTags();

    /**
     * 查询标签的分页数据
     * @param pageUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    /**
     * 保存标签
     * @param tagName
     * @return
     */
    boolean saveTag(String tagName);

    boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();
}
