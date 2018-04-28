package com.leeorz.lottery.news;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 上午10:23
 * description:
 */
public class NewsBean {
    private String id = "";
    private String img = "";
    private String title = "";
    private String time = "";

    public NewsBean() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
