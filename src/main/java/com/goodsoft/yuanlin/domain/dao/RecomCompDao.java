package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.recommend.RecomComp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 企业推荐dao层
 * Created by 严彬荣 on 2017/8/11.
 */
@Repository
public interface RecomCompDao {

    public List<RecomComp> queryRecomCompDao();
}
