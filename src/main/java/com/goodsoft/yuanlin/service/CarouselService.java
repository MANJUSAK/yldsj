package com.goodsoft.yuanlin.service;

import javax.servlet.http.HttpServletRequest;

/**
 * function 轮播图业务接口类
 * Created by 严彬荣 on 2017/8/18.
 */
public interface CarouselService {
    //查询轮播图
    public <T> T queryCarouselService(HttpServletRequest request, String var);
}
