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
@RequestMapping("/recommend")
public class RecomCompController {
    @Resource
    private RecomCompService service;

    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/company")
    public Object recomCompController(HttpServletRequest request, int page) {
        return this.service.queryRecomService(request, page);
    }
}
