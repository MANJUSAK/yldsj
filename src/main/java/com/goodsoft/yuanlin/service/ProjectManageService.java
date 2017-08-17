package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function 项目管理业务接口类
 * Created by 严彬荣 on 2017/8/15.
 */
public interface ProjectManageService {

    //查询项目管理数据
    public <T> T queryProjectDataService(HttpServletRequest request, String deptId, String uid, String type, String page);

    //添加项目管理数据(有文件)
    public Status addProjectDataService(HttpServletRequest request, MultipartFile[] files, Object msg, String type);

    //添加项目管理数据(无文件)
    public Status addProjectDataService(Object msg, String type);

}
