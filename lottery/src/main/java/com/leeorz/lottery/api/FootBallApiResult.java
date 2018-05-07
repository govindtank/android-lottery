package com.leeorz.lottery.api;

import com.leeorz.lib.api.ApiResult;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/26 下午5:11
 * description:
 */
public class FootBallApiResult<T> extends ApiResult{
    private int code = 0;
    private String msg = "";
    private T data = null;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
