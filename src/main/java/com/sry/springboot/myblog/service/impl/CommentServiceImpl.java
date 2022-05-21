package com.sry.springboot.myblog.service.impl;

import com.sry.springboot.myblog.dao.BlogCommentMapper;
import com.sry.springboot.myblog.entity.BlogComment;
import com.sry.springboot.myblog.service.CommentService;
import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private BlogCommentMapper blogCommentMapper;

    @Override
    public int getTotalComment() {
        return blogCommentMapper.getTotalBlogComments(null);
    }

    @Override
    public PageResult getCommentsPage(PageQueryUtil pageUtil) {
        List<BlogComment> comments = blogCommentMapper.findBlogCommentList(pageUtil);
        int total = blogCommentMapper.getTotalBlogComments(pageUtil);
        PageResult pageResult = new PageResult(comments, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public boolean checkDone(Integer[] ids) {
        return blogCommentMapper.checkDone(ids) > 0;
    }

    @Override
    public boolean reply(Long commentId, String replyBody) {
        BlogComment blogComment = blogCommentMapper.selectByPrimaryKey(commentId);
        //blogComment不为空且状态为已审核，则继续后续操作
        if (blogComment != null && blogComment.getCommentStatus().intValue() == 1) {
            blogComment.setReplyBody(replyBody);
            blogComment.setReplyCreateTime(new Date());
            return blogCommentMapper.updateByPrimaryKeySelective(blogComment) > 0;
        }
        return false;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return blogCommentMapper.deleteBatch(ids) > 0;
    }

    @Override
    public Boolean addComment(BlogComment blogComment) {
        return blogCommentMapper.insertSelective(blogComment) > 0;
    }

    @Override
    public PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page) {
        if (page < 1) {
            return null;
        }
        Map params = new HashMap();
        params.put("page", page);
        //每页8条
        params.put("limit", 8);
        params.put("blogId", blogId);//过滤当前博客下的评论数据
        params.put("commentStatus", 1);//过滤审核通过的数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<BlogComment> comments = blogCommentMapper.findBlogCommentList(pageUtil);
        if (!CollectionUtils.isEmpty(comments)) {
            int total = blogCommentMapper.getTotalBlogComments(pageUtil);
            PageResult pageResult = new PageResult(comments, total, pageUtil.getLimit(), pageUtil.getPage());
            return pageResult;
        }
        return null;
    }
}
