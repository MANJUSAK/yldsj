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
 * version v1.0
 */
@RestController
public class CarouselController {
    @Resource
    private CarouselService service;

    /**
     * 查询轮播图接口
     *
     * @param request http请求
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @RequestMapping("/carousel")
    public Object queryCarouselController(HttpServletRequest request) {
        return this.service.queryCarouselService(request);
    }

    /**
     * 添加轮播图接口
     *
     * @param files 文件
     * @param msg   数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("/add/carousel")
    public Status addCarouselController(@RequestParam("files") MultipartFile[] files, Carousel msg) {
        return this.service.addCarouselService(files, msg);
    }

    /**
     * 删除轮播图接口
     *
     * @param id 数据id（文件编号）
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("/delete/carousel")
    public Status deleteCarouselController(String... id) {
        return this.service.deleteCarouselService(id);
    }

    /**
     * 修改轮播图接口
     *
     * @param files 修改文件
     * @param msg   修改数据
     * @return 响应结果
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @RequestMapping("/update/carousel")
    public Status updateCarouselController(@RequestParam("files") MultipartFile[] files, Carousel msg) {
        return this.service.updateCarouselService(files, msg);
    }
}
