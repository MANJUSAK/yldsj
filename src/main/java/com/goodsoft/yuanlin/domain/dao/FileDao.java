package com.goodsoft.yuanlin.domain.dao;

import com.goodsoft.yuanlin.domain.entity.file.FileData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * function 上传文件后的路径保存到数据库dao层
 * Created by 严彬荣 on 2017/8/4.
 * version v1.0
 */
@Repository
public interface FileDao {

    //文件查询
    public List<FileData> queryFileDao(@Param("fileId") String fileId) throws Exception;

    //文件保存
    public void saveFileDao(FileData msg) throws Exception;
}
