package com.goodsoft.yuanlin.domain.entity.project;

import com.goodsoft.yuanlin.domain.entity.file.FileData;

import java.util.List;

/**
 * Settlement entity.项目结算表实体
 *
 * @author 严彬荣
 */
public class Settlement implements java.io.Serializable {
    // 表ID
    private Integer sid;
    // 项目名称
    private String name;
    // 结算日期
    private String dates;
    // 结算书编号
    private String filesId;
    // 用户ID
    private String uid;
    // 项目编号
    private Integer pid;
    //部门编号
    private String deptId;
    // 图片路径
    private List<FileData> url;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<FileData> getUrl() {
        return url;
    }

    public void setUrl(List<FileData> url) {
        this.url = url;
    }
}