package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.demand.SeedlingOffer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 苗木参考访问数据库dao层
 * Created by 严彬荣 on 2017/9/4.
 * version v1.0
 */
@Repository
public interface SeedlingOfferDao {
    //查询苗木参考报价dao方法
    public List<SeedlingOffer> querySeedlingOfferDao(@Param("price") String price, @Param("mate") String mate, @Param("tp") String tp, @Param("spf") String spf, @Param("date") String date, @Param("page") int page) throws Exception;

    //添加苗木参考报价dao方法
    public void addSeedlingOfferDao(List<SeedlingOffer> msg) throws Exception;
}
