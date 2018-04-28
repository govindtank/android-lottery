package com.leeorz.lottery.ssq;

import java.util.List;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 上午11:34
 * description:
 */
public class SsqBean {

    /**
     * id : 2018047
     * open_time : 2018-04-26 22:13:27
     * open_date : 2018/4/26
     * red : 07,25,12,06,22,16
     * blue : 07
     */

    private String id;
    private String open_time;
    private String open_date;
    private String[] red;
    private String[] blue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getOpen_date() {
        return open_date;
    }

    public void setOpen_date(String open_date) {
        this.open_date = open_date;
    }

    public String[] getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red.split(",");
    }

    public String[] getBlue() {
        return blue;
    }

    public void setBlue(String blue) {
        this.blue = blue.split(",");
    }
}
