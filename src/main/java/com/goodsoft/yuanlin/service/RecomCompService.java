package com.goodsoft.yuanlin.service;

import javax.servlet.http.HttpServletRequest;

/**
 * function 企业推荐业务接口类
 * Created by 严彬荣 on 2017/8/14.
 */
public interface RecomCompService {

    //企业推荐数据
    public <T> T queryRecomService(HttpServletRequest request, String page);
}
