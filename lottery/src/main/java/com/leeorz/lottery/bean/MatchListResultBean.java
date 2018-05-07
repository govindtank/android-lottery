package com.leeorz.lottery.bean;

import com.leeorz.lottery.match.MatchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 下午8:23
 * description:
 */
public class MatchListResultBean {
    private List<MatchBean> list = new ArrayList();

    public List<MatchBean> getList() {
        return list;
    }

    public void setList(List<MatchBean> list) {
        this.list = list;
    }
}
