package com.leeorz.lottery.bean;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 下午6:36
 * description:
 */
public class SsqAnalysisBean {

    /**
     * id : 1
     * title : 双色球头奖9注693万分落7地 奖池升至9.06亿
     * time : 2018-04-27 09:25:41
     * count : 22
     * img : http://n.sinaimg.cn/sports/transform/214/w568h446/20180426/hmHG-fztkpin8233958.png
     */

    private int id;
    private String title;
    private String time;
    private int count;
    private String img;
    private String desn;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesn() {
        return desn;
    }

    public void setDesn(String desn) {
        this.desn = desn;
    }
}
