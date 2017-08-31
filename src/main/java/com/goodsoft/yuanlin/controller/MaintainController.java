package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.maintenance.Maintain;
import com.goodsoft.yuanlin.domain.entity.maintenance.Management;
import com.goodsoft.yuanlin.domain.entity.maintenance.PlantInformation;
import com.goodsoft.yuanlin.service.MaintainService;
import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 植株信息管理
 * Created by 龙宏 on 2017/8/16.
 */
@Controller
@RequestMapping("/maintenance")
public class MaintainController {
    @Resource
    private MaintainService maintainService;

    /**
     * app植株养护前植物信息录入
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addPlantInformation")
    public Status addPlantInformation(PlantInformation msg) throws Exception {
        return maintainService.addPlantInformation(msg);
    }

    /**
     * app植株管护信息录入
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addInformation")
    public Status addInformation(@RequestParam(value = "files", required = false) List<MultipartFile> files, HttpServletRequest request, ModelMap model, Management management) throws Exception {
        return maintainService.addInformation(files, request, model, management);
    }

    /**
     * 养护信息录入
     *
     * @param maintain
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addMaintenanceInformation")
    public Status addMaintenanceInformation(Maintain maintain) throws Exception {
        return maintainService.addMaintenanceInformation(maintain);
    }

    /**
     * 树苗信息查询
     *
     * @param code
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/findPlantInformation")
    public Object findPlantInformation(String code) throws Exception {
        return maintainService.findPlantInformation(code);
    }

    /**
     * 个人管护信息查询
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/findManagementInfo")
    public Object findManagementInfo(String userId, String code, HttpServletRequest request) throws Exception {
        return maintainService.findManagementInfo(userId, code, request);
    }

    /**
     * 个人养护信息查询
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/findMaintenanceInfo")
    public Object findMaintenanceInfo(String userId) throws Exception {
        return maintainService.findMaintenanceInfo(userId);
    }
}
