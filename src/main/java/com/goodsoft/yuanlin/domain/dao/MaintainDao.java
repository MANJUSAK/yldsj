package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.maintenance.Maintain;
import com.goodsoft.yuanlin.domain.entity.maintenance.Management;
import com.goodsoft.yuanlin.domain.entity.maintenance.PlantInformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 养护信息查询及录入
 * Created by 龙宏 on 2017/8/15.
 */
@Repository
public interface MaintainDao {
    /**
     * app树苗信息录入
     *
     * @return
     */
    public void plantInformation(PlantInformation msg);

    /**
     * app 管护信息录入
     *
     * @param management
     */
    public void addmainInformation(Management management);

    /**
     * 修改管护状态
     *
     * @param maintain
     */
    public void updateMainStatus(Maintain maintain);

    /**
     * 养护信息录入
     *
     * @param maintain
     */
    public void addMaintenanceInformation(Maintain maintain);

    /**
     * app树苗信息查询
     *
     * @return
     */
    public PlantInformation findPlantInformation(@Param("code") String code);

    /**
     * 个人管护信息查询
     *
     * @param userId
     * @return
     */
    public Management findManagementInfo(@Param("userId") String userId, @Param("code") String code);

    /**
     * 当日管护信息
     *
     * @param code
     * @param time
     * @return
     */
    public List<Management> findNowManagementInfo(@Param("code") String code, @Param("time") String time);

    /**
     * 个人养护信息查询
     *
     * @param userId
     * @return
     */
    public List<Maintain> findMaintenanceInfo(@Param("userId") String userId);

    /**
     * 当日养护信息查询
     *
     * @param code
     * @return
     */
    public List<Maintain> findNowMaintenanceInfo(@Param("code") String code, @Param("time") String time);
}
