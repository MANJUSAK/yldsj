package com.goodsoft.yuanlin.domain.entity.trade;

/**
 * function 动态资讯实体
 * Created by 严彬荣 on 2017/8/21.
 */
public class Information implements java.io.Serializable {
    private int id;//表id
    private String title;//标题
    private String content;//内容
    private String date;//发布日期
    private int infoType;//类别（1为协会动态/2为行业动态/3为媒体报道/4为公告通知）

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getInfoType() {
        return infoType;
    }

    public void setInfoType(int infoType) {
        this.infoType = infoType;
    }
}
