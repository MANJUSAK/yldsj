package com.goodsoft.yuanlin.dao;

import com.goodsoft.yuanlin.entity.FileData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 上传文件后的路径保存到数据库dao层
 * Created by 严彬荣 on 2017/8/4.
 */
@Repository
public interface FileDao {

    //文件查询
    public List<FileData> queryFileDao(String fileId);

    //文件保存
    public void saveFileDao(FileData msg);
}
