package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.domain.entity.carousel.Carousel;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function 轮播图业务接口类
 * Created by 严彬荣 on 2017/8/18.
 * version v1.0
 */
public interface CarouselService {
    //查询轮播图
    public <T> T queryCarouselService(HttpServletRequest request);

    //查询轮播图
    public Status addCarouselService(MultipartFile[] files, Carousel msg);
}
