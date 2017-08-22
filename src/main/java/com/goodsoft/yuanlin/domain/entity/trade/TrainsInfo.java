package com.goodsoft.yuanlin.domain.entity.trade;

import java.util.List;

/**
 * function 培训信息实体
 * Created by 严彬荣 on 2017/8/21.
 */
public class TrainsInfo implements java.io.Serializable {
    private int id;//表id
    private String traName;//培训名称
    private String date;//培训日期
    private String content;//培训内容
    private String filesId;//文件编号
    private String traType;//培训类型（1为施工员/2为研修班/3为草坪工/4为绿化工）
    private List<String> trainFile;//培训文件

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraName() {
        return traName;
    }

    public void setTraName(String traName) {
        this.traName = traName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getTraType() {
        return traType;
    }

    public void setTraType(String traType) {
        this.traType = traType;
    }

    public List<String> getTrainFile() {
        return trainFile;
    }

    public void setTrainFile(List<String> trainFile) {
        this.trainFile = trainFile;
    }
}
