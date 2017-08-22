package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.carousel.Carousel;
import org.springframework.stereotype.Repository;

/**
 * function 轮播图数据dao层
 * Created by 严彬荣 on 2017/8/18.
 */
@Repository
public interface CarouselDao {

    //获取轮播图id
    public Carousel queryCarouselDao() throws Exception;

    //添加轮播图
    public void addCarouselDao(Carousel msg) throws Exception;
}
