package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.carousel.Carousel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 轮播图数据dao层
 * Created by 严彬荣 on 2017/8/18.
 */
@Repository
public interface CarouselDao {
    //查询轮播图dao方法
    public List<String> queryCarouselByIdDao(@Param("id") String id);

    //获取轮播图id
    public Carousel queryCarouselDao();
}
