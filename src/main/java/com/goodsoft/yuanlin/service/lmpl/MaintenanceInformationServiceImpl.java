package com.goodsoft.yuanlin.service.lmpl;

import com.goodsoft.yuanlin.domain.dao.MaintenanceInformationDao;
import com.goodsoft.yuanlin.domain.entity.maintenance.MaintenanceInformation;
import com.goodsoft.yuanlin.domain.entity.maintenance.Management;
import com.goodsoft.yuanlin.domain.entity.maintenance.PlantInformation;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.service.MaintenanceInformationService;
import com.goodsoft.yuanlin.util.DateUtils;
import com.goodsoft.yuanlin.util.UUIDUtil;
import com.goodsoft.yuanlin.util.resultentity.Status;
import com.goodsoft.yuanlin.util.resultentity.StatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 植株养护信息
 * Created by 龙宏 on 2017/8/16.
 */
@Service
public class MaintenanceInformationServiceImpl implements MaintenanceInformationService {
    @Resource
    private MaintenanceInformationDao maintenanceInformationDao;
    @Resource
    private FileService fileService;
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();

    /**
     * app植株养护信息录入
     * @param code  植株编码
     * @param name  植株名称
     * @param purpose  植株用途
     * @param specifications  植株规格
     * @param address    种植地点
     * @param time      录入时间
     * @param deptId   部门ID
     * @return   返回录入信息
     */
    public Status addPlantInformation(String code,String name,String purpose,String specifications,String address,String time,String deptId){
        PlantInformation plantInformation = new PlantInformation();
        plantInformation = maintenanceInformationDao.findPlantInformation(code);
        if (plantInformation == null){
            try {
                PlantInformation information = new PlantInformation();
                String id = uuid.getUUID().toString();
                information.setId(id);
                information.setCode(code);
                information.setName(name);
                information.setPurpose(purpose);
                information.setSpecifications(specifications);
                information.setAddress(address);
                information.setTime(time);
                information.setDeptId(deptId);
                maintenanceInformationDao.plantInformation(information);
                //String name1 = information.getName();
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            } catch (Exception e) {
                System.out.println(e.toString());
                return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
            }
        }else {
            return new Status(StatusEnum.NO_ADD.getCODE(), StatusEnum.NO_ADD.getEXPLAIN());
        }
    }

    /**
     * app管护信息录入
     * @param files  图片
     * @param request
     * @param management  管护信息
     * @return
     */
    public Status addInformation(@RequestParam(value = "file", required = false) List<MultipartFile> files,
                                 HttpServletRequest request,ModelMap model, Management management) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());// 当前日期
        String code = management.getCode();
        List<Management> list = maintenanceInformationDao.findNowManagementInfo(code,time);
        if (list.size() == 0) {
            String id = uuid.getUUID().toString();
            int size = files.size();
            if (size != 0) {
                for (int i = 0; i < files.size(); i++) {
                    String path = request.getSession().getServletContext().getRealPath("/") + "ylfile";
                    if (!new File(path).exists()) {
                        new File(path).mkdirs();
                    }
                    //System.out.println(path);
                    // 获取文件名称
                    String fileName = files.get(i).getOriginalFilename();
                    // 获取文件类型
                    String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    // 文件重命名
                    String file_ture_name = DateUtils.getCurrentDate("yyyyMMddHHmmssms" + i + ".") + extensionName;
                   //访问路径
                    String filepath ="ylfile"+ "/" + file_ture_name;
                    File targetFile = new File(path, file_ture_name);
                    if (i == 0) {
                        management.setFrontPhoto(filepath);
                    } else {
                        management.setAfterPhoto(filepath);
                    }
                    // 保存
                    try {
                        //保存图片到屋里磁盘
                        files.get(i).transferTo(targetFile);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);
                    model.addAttribute("downFileUrl", path + "/" + fileName);
                }
                try {
                    management.setId(id);
                    maintenanceInformationDao.addmainInformation(management);
                    String maintenanceCode = management.getMaintenanceCode();
                    String status = "1";
                    MaintenanceInformation maintenanceInformation = new MaintenanceInformation();
                    maintenanceInformation.setStatus(status);
                    maintenanceInformation.setId(maintenanceCode);
                    maintenanceInformationDao.updateMainStatus(maintenanceInformation);
                    return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());

                } catch (Exception e) {
                    System.out.println(e.toString());
                    return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
                }

            } else {
                if (size < 2) {
                    return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
                }
                return new Status(StatusEnum.NO_FILE.getCODE(), StatusEnum.NO_FILE.getEXPLAIN());
            }
        }else {
            return new Status(StatusEnum.NO_ADDMABAGEMENT.getCODE(), StatusEnum.NO_ADDMABAGEMENT.getEXPLAIN());
        }

    }

    /**
     * 养护信息录入
     * @param maintenanceInformation
     * @return
     */
    public Status addMaintenanceInformation(MaintenanceInformation maintenanceInformation){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String time = df.format(new Date());// 当前日期
                String code = maintenanceInformation.getCode();
        List<MaintenanceInformation> list = maintenanceInformationDao.findNowMaintenanceInfo(code,time);
        if(list.size() == 0) {
            try {
                String id = uuid.getUUID().toString();
                maintenanceInformation.setId(id);
                String status = "0";
                maintenanceInformation.setStatus(status);
                this.maintenanceInformationDao.addMaintenanceInformation(maintenanceInformation);
                return new Status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            } catch (Exception e) {
                System.out.println(e.toString());
                return new Status(StatusEnum.SERVER_ERROR.getCODE(), StatusEnum.SERVER_ERROR.getEXPLAIN());
            }
        }else {
            return new Status(StatusEnum.NO_ADDMAINANCE.getCODE(), StatusEnum.NO_ADDMAINANCE.getEXPLAIN());
        }
      }

    /**
     * 树苗信息查询
     * @param code
     * @return
     */
    public <T> T findPlantInformation(String code){
        PlantInformation plantInformation = new PlantInformation();
        plantInformation = maintenanceInformationDao.findPlantInformation(code);
        if (plantInformation != null) {
            return (T) new com.goodsoft.yuanlin.util.resultentity.Result(0, plantInformation);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 个人管护信息查询
     * @param userId
     * @param <T>
     * @return
     */
    public <T> T findManagementInfo(String userId ,String code,HttpServletRequest request){
        Management management = maintenanceInformationDao.findManagementInfo(userId,code);
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        String filePath = tempContextUrl + management.getFrontPhoto();
        String filePath1 = tempContextUrl + management.getAfterPhoto();
        management.setFrontPhoto(filePath);
        management.setAfterPhoto(filePath1);
        if (management != null) {
            return (T) new com.goodsoft.yuanlin.util.resultentity.Result(0, management);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }

    /**
     * 个人养护信息查询
     * @param userId
     * @param <T>
     * @return
     */
    public <T> T findMaintenanceInfo(String userId){
        List<MaintenanceInformation> list = maintenanceInformationDao.findMaintenanceInfo(userId);
        if (list.size() > 0) {
            return (T) new com.goodsoft.yuanlin.util.resultentity.Result(0, list);
        }
        return (T) new Status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
    }
}
