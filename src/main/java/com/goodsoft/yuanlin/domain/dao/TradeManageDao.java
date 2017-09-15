package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.trade.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 行业协会动态dao层
 * Created by 严彬荣 on 2017/8/21.
 * version v1.0
 */
@Repository
public interface TradeManageDao {

    //查询会费信息
    public List<Dues> queryDuesDao(@Param("page") int page) throws Exception;

    //会员查询会费信息
    public List<Dues> queryMberDuesDao(@Param("date") String date, @Param("keyWord") String keyWord, @Param("page") int page) throws Exception;

    //查询培训信息
    public List<TrainsInfo> queryTrainInfoDao(@Param("date") String date, @Param("tp") String tp, @Param("keyWord") String keyWord, @Param("page") int page) throws Exception;

    //查询优质工程信息
    public List<QualEngin> queryQualEnginDao(@Param("date") String date, @Param("comp") String comp, @Param("year") String year, @Param("keyWord") String keyWord, @Param("page") int page) throws Exception;

    //查询联系协会数据
    public List<Contact> queryContactDao(@Param("date") String date, @Param("page") int page) throws Exception;

    //查询动态资讯信息
    public List<Information> queryInformationDao(@Param("date") String date, @Param("tp") String tp, @Param("keyWord") String keyWord, @Param("page") int page) throws Exception;

    //增加会费信息
    public void addDuesDao(Dues msg) throws Exception;

    //增加培训信息
    public void addTrainInfoDao(TrainsInfo msg) throws Exception;

    //增加优质工程信息
    public void addQualEngineeringDao(QualEngin msg) throws Exception;

    //增加联系协会数据
    public void addContactDao(Contact msg) throws Exception;

    //增加动态资讯信息
    public void addInformationDao(Information msg) throws Exception;

    //删除会费信息
    public void deleteDuesDao(@Param("id") String... id) throws Exception;

    //删除培训信息
    public void deleteTrainInfoDao(@Param("fileId") String... fileId) throws Exception;

    //删除优质工程信息
    public void deleteQualEngineeringDao(@Param("id") String... id) throws Exception;

    //删除动态资讯信息
    public void deleteInformationDao(@Param("id") String... id) throws Exception;

}
