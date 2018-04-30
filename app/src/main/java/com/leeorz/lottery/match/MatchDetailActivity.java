package com.leeorz.lottery.match;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lib.utils.ToastUtil;
import com.leeorz.lottery.R;
import com.leeorz.lottery.WebActivity;
import com.leeorz.lottery.api.FootBallApi;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.bean.MatchAnalysisDataResultBean;
import com.leeorz.lottery.bean.MatchDetailResultBean;
import com.leeorz.lottery.bean.MatchDetailVideoResultBean;
import com.leeorz.lottery.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/26 下午5:58
 * description:
 */
public class MatchDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.tv_detail_date)
    TextView tvDetailDate;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.iv_aways)
    ImageView ivAways;
    @BindView(R.id.tv_aways)
    TextView tvAways;
    @BindView(R.id.ll_detail)
    LinearLayout llDetail;
    @BindView(R.id.iv_video)
    ImageView ivVideo;

    public static void gotoThis(Context context, String fid) {
        Intent intent = new Intent(context, MatchDetailActivity.class);
        intent.putExtra(Constants.KEY_FID, fid);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void showDetail(MatchDetailResultBean matchDetailResultBean) {
        tvTitle.setText(matchDetailResultBean.getSeasonyear() + matchDetailResultBean.getLname());
        Picasso.with(getActivity()).load(matchDetailResultBean.getHimg()).into(ivHome);
        Picasso.with(getActivity()).load(matchDetailResultBean.getAimg()).into(ivAways);
        tvHome.setText(matchDetailResultBean.getHname());
        tvAways.setText(matchDetailResultBean.getAname());
        tvDetailDate.setText(matchDetailResultBean.getHalfstarttime());
        switch (matchDetailResultBean.getStatus()) {
            case "0":
                tvStatus.setText("未开始");
                break;
            case "1":
                tvStatus.setText("上半场");
                break;
            case "2":
                tvStatus.setText("中场");
                break;
            case "3":
                tvStatus.setText("下半场");
                break;
            case "4":
                tvStatus.setText("完场");
                break;
        }
    }

    private void showAnalysisData(MatchAnalysisDataResultBean matchAnalysisDataResultBean) {
        //显示排名数据
        View leagueView = getLayoutInflater().inflate(R.layout.template_match_detail_league, null);
        LinearLayout leagueContentLayout = (LinearLayout) leagueView.findViewById(R.id.ll_detail);

        for (MatchAnalysisDataResultBean.RanksBean bean : matchAnalysisDataResultBean.getRanks()) {

            leagueContentLayout.addView(getRankView(bean.getHomestanding()));
            leagueContentLayout.addView(getRankView(bean.getAwaystanding()));
        }

        llDetail.addView(leagueView);

        showHistory(matchAnalysisDataResultBean.getHname(), matchAnalysisDataResultBean.getFuck_datatotal(), matchAnalysisDataResultBean.getFuck_datadetail());
        showHistory(matchAnalysisDataResultBean.getHname(), matchAnalysisDataResultBean.getHome_datatotal(), matchAnalysisDataResultBean.getHome_datadetail());
        showHistory(matchAnalysisDataResultBean.getAname(), matchAnalysisDataResultBean.getAway_datatotal(), matchAnalysisDataResultBean.getAway_datadetail());

        showNote(matchAnalysisDataResultBean);
    }

    private View getRankView(MatchAnalysisDataResultBean.RanksBean.RanksDetailBean bean) {
        View childView = getLayoutInflater().inflate(R.layout.template_match_detail_league_item, null);
        TextView tv1, tv2, tv3, tv4, tv5, tv6;
        tv1 = (TextView) childView.findViewById(R.id.tv1);
        tv2 = (TextView) childView.findViewById(R.id.tv2);
        tv3 = (TextView) childView.findViewById(R.id.tv3);
        tv4 = (TextView) childView.findViewById(R.id.tv4);
        tv5 = (TextView) childView.findViewById(R.id.tv5);
        tv6 = (TextView) childView.findViewById(R.id.tv6);
        tv1.setText(bean.getStanding());
        tv2.setText(bean.getName());
        tv3.setText(bean.getLname());
        tv4.setText(bean.getWin() + "/" + bean.getDraw() + "/" + bean.getLost());
        tv5.setText(bean.getInnum() + "/" + bean.getLostnum());
        tv6.setText(bean.getScore());
        return childView;
    }

    /**
     * 显示历史交战数据
     */
    private void showHistory(String name, MatchAnalysisDataResultBean.TotalBean totalBean, List<MatchAnalysisDataResultBean.HistoryDetailBean> historyDetailBeanList) {
        View historyView = getLayoutInflater().inflate(R.layout.template_match_history, null);
        LinearLayout contentLayout = (LinearLayout) historyView.findViewById(R.id.ll_detail);
        TextView tvHistoryTitle = (TextView) historyView.findViewById(R.id.tv_history_title);
        tvHistoryTitle.setText(name + "历史交战");
        TextView tvTotal = (TextView) historyView.findViewById(R.id.tv_total);
        tvTotal.setText(totalBean.getWin() + "胜 " + totalBean.getDraw() + "平 " + totalBean.getLost() + "负");
        for (MatchAnalysisDataResultBean.HistoryDetailBean bean : historyDetailBeanList) {
            contentLayout.addView(getHistoryItemView(name, bean));
        }

        llDetail.addView(historyView);
    }

    private View getHistoryItemView(String name, MatchAnalysisDataResultBean.HistoryDetailBean bean) {
        View childView = getLayoutInflater().inflate(R.layout.template_match_history_item, null);
        TextView tv1, tv2, tvh, tv4, tva, tvs;
        tv1 = (TextView) childView.findViewById(R.id.tv1);
        tv2 = (TextView) childView.findViewById(R.id.tv2);
        tvh = (TextView) childView.findViewById(R.id.tvh);
        tvs = (TextView) childView.findViewById(R.id.tvs);
        tva = (TextView) childView.findViewById(R.id.tva);
        tv4 = (TextView) childView.findViewById(R.id.tv4);
        tv1.setText(bean.getDate());
        tv2.setText(bean.getLeague());
        tvh.setText(bean.getHome());

        tvs.setText(bean.getScore());
        tva.setText(bean.getAway());
        tv4.setText(bean.getResult());

        if (tvh.getText().toString().replace(" ", "").equals(name)) {
            tvh.setTextColor(getResources().getColor(R.color.app_main_color));
        }
        if (tva.getText().toString().replace(" ", "").equals(name)) {
            tva.setTextColor(getResources().getColor(R.color.app_main_color));
        }

        if (bean.getResult().equals("平")) {
            tv4.setBackgroundColor(getResources().getColor(R.color.app_gray));
        } else if (bean.getResult().equals("负")) {
            tv4.setBackgroundColor(getResources().getColor(R.color.app_green));
        } else {
            tv4.setBackgroundColor(getResources().getColor(R.color.app_main_color));
        }
        return childView;
    }

    private void showNote(MatchAnalysisDataResultBean bean) {
        View noteView = getLayoutInflater().inflate(R.layout.template_match_detail_note, null);
        LinearLayout contentLayout = (LinearLayout) noteView.findViewById(R.id.ll_detail);
        for (String note : bean.getContent()) {
            View childView = getLayoutInflater().inflate(R.layout.template_match_detail_note_item, null);
            TextView tvNote = (TextView) childView.findViewById(R.id.tv_note);
            tvNote.setText(note);
            contentLayout.addView(childView);
        }

        llDetail.addView(noteView);
    }

    private void showVideoBtn(final MatchDetailVideoResultBean bean){
        ivVideo.setVisibility(View.VISIBLE);
        ivVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebActivity.gotoThis(getActivity(),bean.getName(),bean.getLink());
            }
        });
    }

    private void initView() {
        String fid = getIntent().getStringExtra(Constants.KEY_FID);


        FootBallApi footBallApi = API.getInstance(FootBallApi.class, FootBallApi.HOST);
        footBallApi.getMatchDetail(fid, FootBallApi.MATCH_DETAIL_KEY, FootBallApi.C_CK)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<MatchDetailResultBean>() {

                    @Override
                    public void onSuccess(ApiResult<MatchDetailResultBean> apiResult) {
//                        ToastUtil.showShort(getActivity(), ((FootBallApiResult) apiResult).getMsg());

                        showDetail((MatchDetailResultBean) ((FootBallApiResult) apiResult).getData());

                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                }));

        /**
         * 获取比赛分析数据
         */
        footBallApi.getMatchAnalysisData(fid, FootBallApi.MATCH_ANALYSIS_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<MatchAnalysisDataResultBean>() {

                    @Override
                    public void onSuccess(ApiResult<MatchAnalysisDataResultBean> apiResult) {
//                        ToastUtil.showShort(getActivity(), ((FootBallApiResult) apiResult).getMsg());
                        showAnalysisData((MatchAnalysisDataResultBean) ((FootBallApiResult) apiResult).getData());

                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                }));

        /**
         * 获取比赛视频
         */
        footBallApi.getMatchDetailVideoHtml(fid, FootBallApi.MATCH_VIDEO_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<MatchDetailVideoResultBean>() {

                    @Override
                    public void onSuccess(ApiResult<MatchDetailVideoResultBean> apiResult) {
                        showVideoBtn((MatchDetailVideoResultBean) ((FootBallApiResult) apiResult).getData());

                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                }));
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
