package com.leeorz.lottery.ssq.analysis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lottery.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 下午6:28
 * description:
 */
public class SsqAnalysisDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    public static void gotoThis(Context context) {
        Intent intent = new Intent(context, SsqAnalysisDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssq_analysis_detail);
        ButterKnife.bind(this);
        initView();
    }
    private void initView(){
        tvTitle.setText("预测详情");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
