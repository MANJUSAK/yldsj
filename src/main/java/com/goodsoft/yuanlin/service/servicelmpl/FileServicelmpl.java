package com.goodsoft.yuanlin.service.servicelmpl;

import com.goodsoft.yuanlin.dao.FileDao;
import com.goodsoft.yuanlin.entity.FileData;
import com.goodsoft.yuanlin.service.FileService;
import com.goodsoft.yuanlin.util.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * function 文件上传业务接口实现类
 * Created by 严彬荣 on 2017/8/4.
 */
@SuppressWarnings("ALL")
@Service
public class FileServicelmpl implements FileService {

    @Resource
    private FileUpload fileUpload;
    @Resource
    private FileDao dao;

    @Override
    public int fileUploadService(MultipartFile[] files, HttpServletRequest request, String fileType, String fileId) {
        for (int i = 0, length = files.length; i < length; ++i) {
            //判断文件是否为空
            if (!files[i].isEmpty()) {
                // 获取文件名
                String fileName = files[i].getOriginalFilename().toLowerCase();
                // 判断文件格式是否正确
                if (!(fileName.endsWith("jpg") || fileName.endsWith("jpeg") || fileName.endsWith("png") || fileName.endsWith("gif"))) {
                    return 603;
                }
            } else {
                return 604;
            }
        }
        //获取服务器项目更目录
        String var = request.getSession().getServletContext().getRealPath("");
        //截取服务器更目录
        String var1 = var.substring(0, var.lastIndexOf("y"));
        try {
            //初始化文件实体类
            FileData file = new FileData();
            //设置文件编号
            file.setFileId(fileId);
            List<String> fileList = this.fileUpload.fileUpload(files, fileType, var1);
            for (int i = 0, length = fileList.size(); i < length; ++i) {
                //设置文件路径
                file.setPath(fileList.get(i));
                this.dao.saveFileDao(file);
            }
            fileList.clear();
        } catch (Exception e) {
            e.printStackTrace();
            return 600;
        }
        return 0;
    }
}
