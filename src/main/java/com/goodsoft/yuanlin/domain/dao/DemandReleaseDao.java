package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.demand.Bid;
import com.goodsoft.yuanlin.domain.entity.demand.Equipment;
import com.goodsoft.yuanlin.domain.entity.demand.Recruit;
import com.goodsoft.yuanlin.domain.entity.demand.Seedling;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 需求发布dao层
 * Created by 严彬荣 on 2017/8/4.
 */
@Repository
public interface DemandReleaseDao {
    // 查询设备租赁信息数据dao接口
    public List<Equipment> queryEquipmentDao(@Param("keyWord") String keyWord, @Param("compId") String compId, @Param("uid") String uid, @Param("date") String date, @Param("page") int page) throws Exception;

    // 查询苗木信息数据dao接口
    public List<Seedling> querySeedlingDao(@Param("keyWord") String keyWord, @Param("compId") String compId, @Param("uid") String uid, @Param("breed") String breed, @Param("sub") String sub, @Param("date") String date, @Param("page") int page) throws Exception;

    // 查询招标信息数据数据dao接口
    public List<Bid> queryBidDao(@Param("keyWord") String keyWord, @Param("compId") String compId, @Param("uid") String uid, @Param("date") String date, @Param("page") int page) throws Exception;

    // 查询人才招聘信息数据dao接口
    public List<Recruit> queryRecruitDao(@Param("keyWord") String keyWord, @Param("compId") String compId, @Param("uid") String uid, @Param("tp") String tp, @Param("characters") String characters, @Param("date") String date, @Param("page") int page) throws Exception;

    // 设备租赁信息数据发布dao接口
    public void saveEquipmentDao(Equipment msg) throws Exception;

    // 苗木信息数据发布dao接口
    public void saveSeedlingDao(Seedling msg) throws Exception;

    // 人员招聘信息数据发布dao接口
    public void saveRecruitDao(Recruit msg) throws Exception;

    // 招标信息数据发布dao接口
    public void saveBidDao(Bid msg) throws Exception;

    // 设备租赁信息数据删除dao接口
    public void updateEquipmentDao(@Param("id") int[] id) throws Exception;

    // 苗木信息数据删除dao接口
    public void updateSeedlingDao(@Param("id") int[] id) throws Exception;

    // 人员招聘信息数据删除dao接口
    public void updateRecruitDao(@Param("id") int[] id) throws Exception;

    // 招标信息数据删除dao接口
    public void updateBidDao(@Param("id") int[] id) throws Exception;
}
