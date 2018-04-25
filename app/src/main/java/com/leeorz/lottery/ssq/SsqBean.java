package com.leeorz.lottery.ssq;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 上午11:34
 * description:
 */
public class SsqBean {
    private String date = "";

    private String redBall1,redBall2,redBall3,redBall4,redBall5,redBall6,blueBall1,blueBall2;

    public SsqBean() {
        this.redBall1 = "01";
        this.redBall2 = "01";
        this.redBall3 = "31";
        this.redBall4 = "29";
        this.redBall5 = "18";
        this.redBall6 = "17";
        this.blueBall1 = "01";
        this.blueBall2 = "";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRedBall1() {
        return redBall1;
    }

    public void setRedBall1(String redBall1) {
        this.redBall1 = redBall1;
    }

    public String getRedBall2() {
        return redBall2;
    }

    public void setRedBall2(String redBall2) {
        this.redBall2 = redBall2;
    }

    public String getRedBall3() {
        return redBall3;
    }

    public void setRedBall3(String redBall3) {
        this.redBall3 = redBall3;
    }

    public String getRedBall4() {
        return redBall4;
    }

    public void setRedBall4(String redBall4) {
        this.redBall4 = redBall4;
    }

    public String getRedBall5() {
        return redBall5;
    }

    public void setRedBall5(String redBall5) {
        this.redBall5 = redBall5;
    }

    public String getRedBall6() {
        return redBall6;
    }

    public void setRedBall6(String redBall6) {
        this.redBall6 = redBall6;
    }

    public String getBlueBall1() {
        return blueBall1;
    }

    public void setBlueBall1(String blueBall1) {
        this.blueBall1 = blueBall1;
    }

    public String getBlueBall2() {
        return blueBall2;
    }

    public void setBlueBall2(String blueBall2) {
        this.blueBall2 = blueBall2;
    }
}
