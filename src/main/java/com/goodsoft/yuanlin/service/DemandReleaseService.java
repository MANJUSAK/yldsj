package com.goodsoft.yuanlin.service;

import com.goodsoft.yuanlin.util.resultentity.Status;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function 需求发布业务接口类
 * Created by 严彬荣 on 2017/8/4.
 * version v1.0
 */
public interface DemandReleaseService {
    //查询需求发布数据
    public <T> T queryReleaseData(String keyWord, String comp, String uid, String type, HttpServletRequest request, String date, String breed, String tp, String characters, String sub, String page);

    //添加需求发布数据（有文件）
    public Status releaseDataService(MultipartFile[] files, Object msg, String type);

    //添加需求发布数据（无文件）
    public Status releaseDataService(Object msg, String type);

    //删除需求发布数据
    public Status deleteReleaseDataService(int[] id, String type);
}
