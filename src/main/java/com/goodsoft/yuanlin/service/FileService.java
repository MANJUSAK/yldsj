package com.goodsoft.yuanlin.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function 文件上传业务接口
 * Created by 严彬荣 on 2017/8/4.
 */
public interface FileService {
    public int fileUploadService(MultipartFile[] files, HttpServletRequest request, String fileType, String fileId);
}
