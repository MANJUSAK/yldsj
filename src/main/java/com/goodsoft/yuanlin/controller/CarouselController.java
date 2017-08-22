package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.carousel.Carousel;
import com.goodsoft.yuanlin.service.CarouselService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 轮播图访问入口
 * Created by 严彬荣 on 2017/8/18.
 */
@RestController
public class CarouselController {
    @Resource
    private CarouselService service;

    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/carousel")
    public Object queryCarouselController(HttpServletRequest request) {
        return this.service.queryCarouselService(request);
    }

    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("/add/carousel")
    public Status addCarouselController(HttpServletRequest request, @RequestParam("files") MultipartFile[] files, Carousel msg) {
        return this.service.addCarouselService(request, files, msg);
    }

}
