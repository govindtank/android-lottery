package com.leeorz.lottery.ssq.analysis;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lottery.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 下午2:32
 * description:
 */
public class SsqAnalysisActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssq_analysis);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        tvTitle.setText("专家分析");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
