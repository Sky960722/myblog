package com.sry.springboot.myblog.service;

import com.sry.springboot.myblog.entity.BlogComment;
import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.PageResult;

public interface CommentService {

    int getTotalComment();

    PageResult getCommentsPage(PageQueryUtil pageUtil);

    boolean checkDone(Integer[] ids);

    boolean reply(Long commentId, String replyBody);

    boolean deleteBatch(Integer[] ids);

    Boolean addComment(BlogComment blogComment);

    PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int commentPage);
}
