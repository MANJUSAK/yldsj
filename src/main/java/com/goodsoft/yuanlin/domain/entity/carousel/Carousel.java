package com.goodsoft.yuanlin.domain.entity.carousel;

import java.util.List;
import java.util.Objects;

/**
 * function 轮播图实体
 * Created by 严彬荣 on 2017/8/18.
 * version v1.0
 */
@SuppressWarnings("ALL")
public class Carousel implements java.io.Serializable {

    private String id;//数据id
    private List<String> picture;//图片
    private String picName;//图片名称
    private String description;//图片描述
    private String effect;//图片作用
    private String urlAddress;//图片跳转地址
    private String date;//时间
    private String filesId;//图片编号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carousel)) return false;
        Carousel carousel = (Carousel) o;
        return Objects.equals(id, carousel.id) &&
                Objects.equals(picture, carousel.picture) &&
                Objects.equals(picName, carousel.picName) &&
                Objects.equals(description, carousel.description) &&
                Objects.equals(effect, carousel.effect) &&
                Objects.equals(urlAddress, carousel.urlAddress) &&
                Objects.equals(date, carousel.date) &&
                Objects.equals(filesId, carousel.filesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picture, picName, description, effect, urlAddress, date, filesId);
    }
}
