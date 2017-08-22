package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.service.CarouselService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 轮播图访问入口
 * Created by 严彬荣 on 2017/8/18.
 */
@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Resource
    private CarouselService service;

    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/{type}")
    public Object queryCarouselController(HttpServletRequest request, @PathVariable("type") String type) {
        System.out.println(1);
        return this.service.queryCarouselService(request, type);
    }

}
