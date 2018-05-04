package com.leeorz.lottery.api;

import com.leeorz.lottery.bean.SsqAnalysisBean;
import com.leeorz.lottery.bean.SsqDetailResultBean;
import com.leeorz.lottery.match.dynamic.DynamicCompensationBean;
import com.leeorz.lottery.news.NewsBean;
import com.leeorz.lottery.news.NewsDetailActivity;
import com.leeorz.lottery.news.NewsDetailBean;
import com.leeorz.lottery.ssq.SsqBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 下午4:40
 * description:
 */
public interface PApi {

    public static final String HOST = "http://lottery.panghailong.com/api/";
    /**
     * 获取双色球列表
     * @param id
     * @param pageSize
     * @return
     */
    @FormUrlEncoded
    @POST("ssq/index")
    Observable<FootBallApiResult<List<SsqBean>>> getSsqList(@Field("id") String id, @Field("page_size") int pageSize);


    /**
     * 获取双色球中奖详情
     * @param id

     * @return
     */
    @FormUrlEncoded
    @POST("ssq/info")
    Observable<FootBallApiResult<SsqDetailResultBean>> getSsqDetail(@Field("id") String id);

    /**
     * 获取专家预测列表
     * @param time

     * @return
     */
    @FormUrlEncoded
    @POST("zhuanjia/index")
    Observable<FootBallApiResult<List<SsqAnalysisBean>>> getSsqAnalysisList(@Field("time") String time, @Field("page_size") int pageSize);
    @FormUrlEncoded
    @POST("zhuanjia/index")
    Observable<FootBallApiResult<List<SsqAnalysisBean>>> getSsqAnalysisList(@Field("time") String tuime, @Field("ssqid")String ssqId, @Field("page_size") int pageSize);

    /**
     * 获取专家预测详情
     * @param id

     * @return
     */
    @FormUrlEncoded
    @POST("zhuanjia/info")
    Observable<FootBallApiResult<NewsDetailBean>> getSsqAnalysisDetail(@Field("id") String id);


    /**
     * 获取新闻列表
     * @param id
     * @param pageSize
     * @return
     */
    @FormUrlEncoded
    @POST("news/index")
    Observable<FootBallApiResult<List<NewsBean>>> getNewsList(@Field("id") String id, @Field("page_size") int pageSize);

    /**
     * 获取新闻详情
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("news/info")
    Observable<FootBallApiResult<NewsDetailBean>> getNewsDetail(@Field("id") String id);

    /**
     * 是否关闭APP
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("app_auth")
    Observable<FootBallApiResult<String>> checkAppAuth(@Field("appId") String id);
}
