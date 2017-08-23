package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.domain.entity.maintenance.Maintain;
import com.goodsoft.yuanlin.domain.entity.maintenance.Management;
import com.goodsoft.yuanlin.domain.entity.maintenance.PlantInformation;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 植株养护信息录入
 * Created by 龙宏 on 2017/8/16.
 */
public interface MaintainService {
    /**
     * app园林养护前植物信息录入
     *
     * @return
     */
    public Status addPlantInformation(PlantInformation msg);

    /**
     * app园林管护信息录入
     *
     * @param files      图片
     * @param request
     * @param management 管护信息
     * @return
     */
    public Status addInformation(@RequestParam(value = "file", required = false) List<MultipartFile> files, HttpServletRequest request, ModelMap model, Management management);

    /**
     * 养护信息录入
     *
     * @param maintain
     * @return
     */
    public Status addMaintenanceInformation(Maintain maintain);

    /**
     * 树苗信息查询
     *
     * @param code
     * @return
     */
    public <T> T findPlantInformation(String code);

    /**
     * 个人管护信息查询
     *
     * @param userId
     * @param <T>
     * @return
     */
    public <T> T findManagementInfo(String userId, String code, HttpServletRequest request);

    /**
     * 个人养护信息查询
     *
     * @param userId
     * @param <T>
     * @return
     */
    public <T> T findMaintenanceInfo(String userId);
}
