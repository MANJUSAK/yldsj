package com.goodsoft.yuanlin.entity;

import java.beans.Transient;

/**
 * function 文件数据实体类
 * Created by 严彬荣 on 2017/8/4.
 */
public class FileData implements java.io.Serializable {
    private int fid;//表id
    private String fileId;//文件编号
    private String path;//文件路径

    @Transient
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Transient
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}


