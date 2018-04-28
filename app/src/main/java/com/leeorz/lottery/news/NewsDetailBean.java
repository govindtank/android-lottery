package com.leeorz.lottery.news;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 下午6:18
 * description:
 */
public class NewsDetailBean {
    private int id;
    private String title;
    private String time;
    private int count;
    private String content;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
