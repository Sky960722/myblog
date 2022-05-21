package com.sry.springboot.myblog.controller.blog;

import com.sry.springboot.myblog.controller.vo.SimpleBlogListVO;
import com.sry.springboot.myblog.service.BlogService;
import com.sry.springboot.myblog.service.TagService;
import com.sry.springboot.myblog.util.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyBlogController {


    public static String theme = "amaze";
//    public static String theme = "default";
//    public static String theme = "yummy-jekyll";
    @Resource
    private BlogService blogService;
    @Resource
    private TagService tagService;


    /**
     * 首页（取第一页数据)
     * @param request
     * @return
     */
    @GetMapping({"/", "/index", "index.html"})
    public String index(HttpServletRequest request) {
        return this.page(request,1);
    }


    /**
     * 首页  分页数据
     * @param pageNum
     * @return
     */
    @GetMapping("/page/{pageNum}")
    public String page(HttpServletRequest request,@PathVariable("pageNum") int pageNum){
        PageResult blogPageResult = blogService.getBlogsForIndexPage(pageNum);
        if(blogPageResult == null){
            return "error/error_404";
        }
        request.setAttribute("newBlogs",blogService.getBlogListForIndexPage(1));//1-最新发布
        request.setAttribute("hotBlogs",blogService.getBlogListForIndexPage(0));//0-点击最多
        request.setAttribute("hotTags",tagService.getBlogTagCountForIndex());//标签前20
        request.setAttribute("blogPageResult",blogPageResult);
        request.setAttribute("pageName","首页");
        return "blog/index";
    }



}
