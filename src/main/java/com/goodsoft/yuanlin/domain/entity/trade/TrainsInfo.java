package com.goodsoft.yuanlin.domain.entity.trade;

import java.util.List;
import java.util.Objects;

/**
 * function 培训信息实体
 * Created by 严彬荣 on 2017/8/21.
 * version v1.0
 */
public class TrainsInfo implements java.io.Serializable {
    private String traName;//培训名称
    private String date;//培训日期
    private String content;//培训内容
    private String filesId;//文件编号
    private String traType;//培训类型（1为施工员/2为研修班/3为草坪工/4为绿化工）
    private List<String> trainFile;//培训文件

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainsInfo)) return false;
        TrainsInfo that = (TrainsInfo) o;
        return Objects.equals(traName, that.traName) &&
                Objects.equals(date, that.date) &&
                Objects.equals(content, that.content) &&
                Objects.equals(filesId, that.filesId) &&
                Objects.equals(traType, that.traType) &&
                Objects.equals(trainFile, that.trainFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traName, date, content, filesId, traType, trainFile);
    }
}
