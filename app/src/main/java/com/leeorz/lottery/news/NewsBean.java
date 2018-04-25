package com.leeorz.lottery.news;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 上午10:23
 * description:
 */
public class NewsBean {
    private String imagePath = "";
    private String title = "";
    private long date = 0l;

    public NewsBean() {
        this.imagePath = "http://t2.hddhhn.com/uploads/tu/201804/9999/958521719c.jpg";
        this.date = System.currentTimeMillis();
        this.title = "这个是标题";
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
