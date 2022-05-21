package com.sry.springboot.myblog.controller.admin;

import com.sry.springboot.myblog.dao.BlogTagMapper;
import com.sry.springboot.myblog.service.TagService;
import com.sry.springboot.myblog.util.PageQueryUtil;
import com.sry.springboot.myblog.util.Result;
import com.sry.springboot.myblog.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Resource
    private TagService tagService;

    /**
     * 标签页面
     * @param request
     * @return
     */
    @GetMapping("/tags")
    public String tagPage(HttpServletRequest request) {
        request.setAttribute("path", "tags");
        return "admin/tag";
    }

    /**
     * 标签接口
     * @param params
     * @return
     */
    @GetMapping("/tags/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(tagService.getBlogTagPage(pageUtil));
    }

    /**
     * 标签保存
     * @param tagName
     * @return
     */
    @PostMapping("/tags/save")
    @ResponseBody
    public Result save(@RequestParam("tagName") String tagName) {
        if (StringUtils.isEmpty(tagName)) {
            return ResultGenerator.genFailResult("参数异常");
        }
        if (tagService.saveTag(tagName)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("标签名重复");
        }
    }

    /**
     * 标签删除
     * @param ids
     * @return
     */
    @PostMapping("/tags/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常");
        }
        if (tagService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("有关联数据请勿强行删除");
        }
    }
}
