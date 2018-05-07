package com.leeorz.lottery.ssq.analysis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lib.widget.h5.H5WebView;
import com.leeorz.lottery.R;
import com.leeorz.lottery.R2;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.api.PApi;
import com.leeorz.lottery.constants.Constants;
import com.leeorz.lottery.news.NewsDetailBean;
import com.leeorz.lottery.widget.LoadingDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 下午6:28
 * description:
 */
public class SsqAnalysisDetailActivity extends BaseActivity {

    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.webview)
    H5WebView webview;
    private LoadingDialog loadingDialog;

    public static void gotoThis(Context context, String id) {
        Intent intent = new Intent(context, SsqAnalysisDetailActivity.class);
        intent.putExtra(Constants.KEY_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssq_analysis_detail);
        ButterKnife.bind(this);
        initView();
        getSsqAnalysisDetail(getIntent().getStringExtra(Constants.KEY_ID));
    }

    private void initView() {
        tvTitle.setText("预测详情");
    }

    private void getSsqAnalysisDetail(String id) {
        loadingDialog.show();
        PApi footBallApi = API.getInstance(PApi.class, PApi.HOST);
        footBallApi.getSsqAnalysisDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<NewsDetailBean>() {

                    @Override
                    public void onSuccess(ApiResult<NewsDetailBean> apiResult) {
                        loadingDialog.dismiss();
                        NewsDetailBean bean = (NewsDetailBean) ((FootBallApiResult)apiResult).getData();
                        webview.loadData(bean.getContent(),"text/html","utf=8");
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        loadingDialog.dismiss();
                    }
                }));
    }

    @OnClick(R2.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
