package com.goodsoft.yuanlin.controller;

import com.goodsoft.yuanlin.domain.entity.maintenance.MaintenanceInformation;
import com.goodsoft.yuanlin.domain.entity.maintenance.Management;
import com.goodsoft.yuanlin.service.MaintenanceInformationService;
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
public class MaintenanceInformationController {
    @Resource
    private MaintenanceInformationService maintenanceInformationService;

    /**
     * app植株养护前植物信息录入
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("addPlantInformation")
    public Status addPlantInformation(String code, String name, String purpose, String specifications, String address, String time, String deptId)throws Exception{
        return  maintenanceInformationService.addPlantInformation(code,name,purpose,specifications,address,time,deptId);
    }

    /**
     * app植株管护信息录入
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("addInformation")
    public Status addInformation(@RequestParam(value = "files", required = false) List<MultipartFile> files,
                                 HttpServletRequest request,ModelMap model, Management management)throws Exception{
        return maintenanceInformationService.addInformation(files,request,model,management);
    }

    /**
     * 养护信息录入
     * @param maintenanceInformation
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addMaintenanceInformation")
    public Status addMaintenanceInformation(MaintenanceInformation maintenanceInformation)throws Exception{
       return maintenanceInformationService.addMaintenanceInformation(maintenanceInformation);
    }

    /**
     * 树苗信息查询
     * @param code
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/findPlantInformation")
    public Object findPlantInformation(String code)throws Exception{
        return maintenanceInformationService.findPlantInformation(code);
    }

    /**
     * 个人管护信息查询
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/findManagementInfo")
    public Object findManagementInfo(String userId,String code,HttpServletRequest request)throws  Exception{
        return maintenanceInformationService.findManagementInfo(userId,code,request);
    }

    /**
     * 个人养护信息查询
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/findMaintenanceInfo")
    public Object findMaintenanceInfo(String userId)throws Exception{
        return maintenanceInformationService.findMaintenanceInfo(userId);
    }
}
