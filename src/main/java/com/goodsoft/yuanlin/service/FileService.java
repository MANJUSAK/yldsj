package com.goodsoft.yuanlin.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * function 文件上传业务接口
 * Created by 严彬荣 on 2017/8/4.
 */
public interface FileService {
    //文件上传业务处理
    public int fileUploadService(MultipartFile[] files, String fileType, String fileId);
}
