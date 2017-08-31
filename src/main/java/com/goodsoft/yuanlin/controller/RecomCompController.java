package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.service.RecomCompService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 企业推荐接口类
 * Created by 严彬荣 on 2017/8/14.
 */
@RestController
@RequestMapping("/qytj")
public class RecomCompController {
    @Resource
    private RecomCompService service;

    /**
     * 查询企业推荐接口
     *
     * @param request http请求
     * @param page    页数
     * @param var     类型
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/find/tj")
    public Object recomCompController(HttpServletRequest request, String page, String var) {
        return this.service.queryRecomService(request, page, var);
    }
}
