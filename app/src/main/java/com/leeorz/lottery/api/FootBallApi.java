package com.leeorz.lottery.api;

import com.leeorz.lottery.bean.ColdHotIndexResultBean;
import com.leeorz.lottery.bean.MatchAnalysisDataResultBean;
import com.leeorz.lottery.bean.MatchDetailResultBean;
import com.leeorz.lottery.bean.MatchDetailVideoResultBean;
import com.leeorz.lottery.match.dynamic.DynamicCompensationBean;
import com.leeorz.lottery.match.remind.RemindBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/26 下午4:43
 * description:
 */
public interface FootBallApi {
    public static final String HOST = "http://i.qqshidao.com/api/";
    public static final String T = "1";
    public static final String MATCH_DETAIL_KEY = "8a7f6b611dd399c8cafcc46c35b9853c";
    public static final String MATCH_ANALYSIS_KEY = "541ba457d67da316c6acbbd1e57004f5";
    public static final String MATCH_VIDEO_KEY = "8feb1ce971012d2b20f795ebf836eabc";
    public static final String REMIND_KEY = "a0d44b5a75707fc2a08f25a6e31398a6";
    public static final String DYNAMIC_COMPENSATION_KEY = "3933efc8f670e8766a92a81a611a9057";

    public static final String C_KEY = "180cb5ec5433cefa0e604df978699a4b";
    public static final String C_CK = "NjU2OTA1YzEzYzMxMTg4ZmM3NjVkMDc2MmM1YjlkNGRjZGIwNzM=";

    public static final String REMIND_T1 = "1";
    public static final String REMIND_T2 = "2";
    public static final String REMIND_T3 = "3";

    /**
     * 获取获取冷热指数
     * @param t
     * @param c_key
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?c_id=40029&c_type=2&c_cpid=2&suid=36ab3af9cc68d89996f4bbb3c8e7df13&quid=656905&imei=863254030931603&mac=02:00:00:00:00:00")
    Observable<FootBallApiResult<List<ColdHotIndexResultBean>>> getFootBallColdHot(@Field("t") String t, @Field("c_key") String c_key);


    /**
     * 获取比赛详情
     * @param fid
     * @param c_key
     * @param c_ck
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?c_id=40006&c_type=2&c_cpid=2&suid=36ab3af9cc68d89996f4bbb3c8e7df13&quid=656905&imei=863254030931603&mac=02:00:00:00:00:00")
    Observable<FootBallApiResult<MatchDetailResultBean>> getMatchDetail(@Field("fid") String fid, @Field("c_key") String c_key, @Field("c_ck") String c_ck);

    /**
     * 获取比赛分析数据
     * @param fid
     * @param c_key
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?c_id=41101&c_type=2&c_cpid=2&suid=36ab3af9cc68d89996f4bbb3c8e7df13&quid=656905&imei=863254030931603&mac=02:00:00:00:00:00")
    Observable<FootBallApiResult<MatchAnalysisDataResultBean>> getMatchAnalysisData(@Field("fid") String fid, @Field("c_key") String c_key);

    /**
     * 获取比赛视频
     * @param fid
     * @param c_key
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?c_id=41109&c_type=2&c_cpid=2&suid=36ab3af9cc68d89996f4bbb3c8e7df13&quid=656905&imei=863254030931603&mac=02:00:00:00:00:00")
    Observable<FootBallApiResult<MatchDetailVideoResultBean>> getMatchDetailVideoHtml(@Field("fid") String fid, @Field("c_key") String c_key);


    /**
     * 获取提点数据
     * @param t
     * @param c_key
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?c_id=40033&c_type=2&c_cpid=2&suid=36ab3af9cc68d89996f4bbb3c8e7df13&quid=656905&imei=863254030931603&mac=02:00:00:00:00:00")
    Observable<FootBallApiResult<List<RemindBean>>> getRemindData(@Field("t") String t, @Field("c_key") String c_key);

    /**
     * 获取动态同赔
     * @param t
     * @param c_key
     * @return
     */
    @FormUrlEncoded
    @POST("index.php?c_id=41112&c_type=2&c_cpid=2&suid=36ab3af9cc68d89996f4bbb3c8e7df13&quid=656905&imei=863254030931603&mac=02:00:00:00:00:00")
    Observable<FootBallApiResult<List<DynamicCompensationBean>>> getDynamicCompensation(@Field("t") String t, @Field("c_key") String c_key,@Field("c_ck") String c_ck);
}
