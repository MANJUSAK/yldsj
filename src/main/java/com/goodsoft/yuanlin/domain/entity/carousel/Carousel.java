package com.goodsoft.yuanlin.domain.entity.carousel;

import java.util.List;

/**
 * function 轮播图实体
 * Created by 严彬荣 on 2017/8/18.
 */
public class Carousel implements java.io.Serializable {
    private String id;//图片id
    private List<String> picture;//图片
    private String picName;//图片名称
    private String description;//图片描述
    private String effect;//图片作用
    private String urlAddress;//图片跳转地址
    private String date;//时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
