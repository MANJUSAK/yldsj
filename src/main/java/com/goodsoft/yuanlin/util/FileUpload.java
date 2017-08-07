package com.goodsoft.yuanlin.util;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * function 文件上传工具类
 * Created by 严彬荣 on 2017/8/4.
 */
@SuppressWarnings("ALL")
@Service
public class FileUpload {
    private List<String> fileList = new ArrayList<String>();
    //实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();

    public List fileUpload(MultipartFile[] files, String fileType, String savePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(savePath);
        //自定义文件保存路径
        String str = "/ylfile/demand/";
        sb.append(str);
        sb.append(fileType);
        sb.append("/");
        String str1 = sb.toString();
        File folder = new File(sb.toString());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        for (int i = 0, length = files.length; i < length; ++i) {
            String fileName = files[i].getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            String var = this.uuid.getUUID().toString();
            sb.delete(0, sb.length());
            sb.append(str1);
            sb.append(var);
            sb.append(suffix);
            files[i].transferTo(new File(sb.toString()));
            sb.delete(0, sb.length());
            sb.append(str);
            sb.append(fileType);
            sb.append("/");
            sb.append(var);
            sb.append(suffix);
            fileList.add(sb.toString());
        }
        return fileList;
    }
}
