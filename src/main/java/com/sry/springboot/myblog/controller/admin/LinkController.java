package com.sry.springboot.myblog.controller.admin;

import com.sry.springboot.myblog.entity.BlogLink;
import com.sry.springboot.myblog.service.LinkService;
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
public class LinkController {
    @Resource
    private LinkService linkService;

    /**
     * 链接页面
     * @param request
     * @return
     */
    @GetMapping("/links")
    public String linkPage(HttpServletRequest request) {
        request.setAttribute("path", "links");
        return "admin/link";
    }

    /**
     * 链接列表
     *
     * @param params
     * @return
     */
    @GetMapping("/links/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(linkService.getBlogLinkPage(pageUtil));
    }

    /**
     * 链接添加
     * @param linkType
     * @param linkName
     * @param linkUrl
     * @param linkRank
     * @param linkDescription
     * @return
     */
    @PostMapping("/links/save")
    @ResponseBody
    public Result save(@RequestParam("linkType") Integer linkType,
                       @RequestParam("linkName") String linkName,
                       @RequestParam("linkUrl") String linkUrl,
                       @RequestParam("linkRank") Integer linkRank,
                       @RequestParam("linkDescription") String linkDescription) {
        if (linkType == null || linkName == null || linkUrl == null || linkRank == null || linkDescription == null) {
            return ResultGenerator.genFailResult("参数异常");
        } else {
            BlogLink blogLink = new BlogLink();
            blogLink.setLinkType(linkType.byteValue());
            blogLink.setLinkName(linkName);
            blogLink.setLinkUrl(linkUrl);
            blogLink.setLinkRank(linkRank);
            blogLink.setLinkDescription(linkDescription);
            return ResultGenerator.genSuccessResult(linkService.saveLink(blogLink));
        }
    }

    /**
     * 链接详情
     * @param id
     * @return
     */
    @GetMapping("/links/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Integer id) {
        BlogLink link = linkService.selectById(id);
        return ResultGenerator.genSuccessResult(link);
    }

    /**
     * 友链修改
     * @param linkId
     * @param linkType
     * @param linkName
     * @param linkUrl
     * @param linkRank
     * @param linkDescription
     * @return
     */
    @PostMapping("/links/update")
    @ResponseBody
    public Result update(@RequestParam("linkId") Integer linkId,
                       @RequestParam("linkType") Integer linkType,
                       @RequestParam("linkName") String linkName,
                       @RequestParam("linkUrl") String linkUrl,
                       @RequestParam("linkRank") Integer linkRank,
                       @RequestParam("linkDescription") String linkDescription) {
        BlogLink tempLink = linkService.selectById(linkId);
        if (tempLink == null) {
            return ResultGenerator.genFailResult("无数据");
        }
        if (linkType == null || linkName == null || linkUrl == null || linkRank == null || linkDescription == null) {
            return ResultGenerator.genFailResult("参数异常");
        }
        tempLink.setLinkType(linkType.byteValue());
        tempLink.setLinkName(linkName);
        tempLink.setLinkUrl(linkUrl);
        tempLink.setLinkRank(linkRank);
        tempLink.setLinkDescription(linkDescription);
        return ResultGenerator.genSuccessResult(linkService.updateLink(tempLink));
    }

    /**
     * 友链删除
     * @param ids
     * @return
     */
    @PostMapping("/links/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常");
        }
        if (linkService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }
}
