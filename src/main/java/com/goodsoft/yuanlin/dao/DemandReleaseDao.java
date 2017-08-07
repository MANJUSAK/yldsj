package com.goodsoft.yuanlin.dao;

import com.goodsoft.yuanlin.entity.Bid;
import com.goodsoft.yuanlin.entity.Equipment;
import com.goodsoft.yuanlin.entity.Recruit;
import com.goodsoft.yuanlin.entity.Seedling;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 需求发布dao层
 * Created by 严彬荣 on 2017/8/4.
 */
@Repository
public interface DemandReleaseDao {
    // 查询设备租赁信息
    public List<Equipment> queryEquipmentDao(@Param("uid") String uid, @Param("date") String date, @Param("page") int page);

    // 查询用户发布的苗木信息数据dao接口
    public List<Seedling> querySeedlingDao(@Param("uid") String uid, @Param("breed") String breed, @Param("sub") String sub, @Param("date") String date, @Param("page") int page);

    // 查询招标信息数据公共数据dao接口
    public List<Bid> queryBidDao(@Param("uid") String uid, @Param("date") String date, @Param("page") int page);

    // 查询人才招聘信息公共数据dao接口
    public List<Recruit> queryRecruitDao(@Param("uid") String uid, @Param("tp") String tp, @Param("characters") String characters, @Param("date") String date, @Param("page") int page);

    // 添加设备租赁发布信息数据dao接口
    public void saveEquipmentDao(Equipment msg) throws Exception;

    // 添加苗木发布信息数据dao接口
    public void saveSeedlingDao(Seedling msg) throws Exception;

    // 添加人员招聘发布信息数据dao接口
    public void saveRecruitDao(Recruit msg) throws Exception;

    // 抓取招标信息数据存储dao接口
    public void saveBidDao(Bid msg) throws Exception;
}
