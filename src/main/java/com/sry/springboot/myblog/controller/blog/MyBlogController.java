package com.sry.springboot.myblog.controller.blog;

import com.sry.springboot.myblog.service.BlogService;
import com.sry.springboot.myblog.service.TagService;
import com.sry.springboot.myblog.util.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyBlogController {


    public static String theme = "amaze";
//    public static String theme = "default";
//    public static String theme = "yummy-jekyll";
    @Resource
    private BlogService blogService;
    @Resource
    private TagService tagService;



    @GetMapping({"/", "/index", "index.html"})
    public String index(HttpServletRequest request) {
        return "blog/index";
    }


}
