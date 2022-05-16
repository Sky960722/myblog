package com.sry.springboot.myblog.service.impl;

import com.sry.springboot.myblog.dao.BlogLinkMapper;
import com.sry.springboot.myblog.entity.BlogLink;
import com.sry.springboot.myblog.service.LinkService;
import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.PageResult;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private BlogLinkMapper blogLinkMapper;

    @Override
    public PageResult getBlogLinkPage(PageQueryUtil pageUtil) {
        return null;
    }

    @Override
    public int getTotalLinks() {
        return blogLinkMapper.getTotalLinks(null);
    }

    @Override
    public Boolean saveLink(BlogLink link) {
        return null;
    }

    @Override
    public BlogLink selectById(Integer id) {
        return null;
    }

    @Override
    public Boolean updateLink(BlogLink tempLink) {
        return null;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public Map<Byte, List<BlogLink>> getLinksForLinkPage() {
        return null;
    }
}
