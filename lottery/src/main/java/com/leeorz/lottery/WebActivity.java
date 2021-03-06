package com.leeorz.lottery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lib.widget.h5.H5WebView;
import com.leeorz.lottery.constants.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 下午4:14
 * description:
 */
public class WebActivity extends BaseActivity {


    @BindView(R2.id.iv_back)
    ImageView ivBack;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.webview)
    H5WebView webview;

    public static void gotoThis(Context context, String title, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(Constants.KEY_TITLE, title);
        intent.putExtra(Constants.KEY_URL, url);
        context.startActivity(intent);
    }

    public static void gotoThisWithContent(Context context, String title, String content) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(Constants.KEY_TITLE, title);
        intent.putExtra(Constants.KEY_CONTENT, content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        String title = getIntent().getStringExtra(Constants.KEY_TITLE);
        if(!TextUtils.isEmpty(title)){
            tvTitle.setText(title);
        }

        String url = getIntent().getStringExtra(Constants.KEY_URL);
        String content = getIntent().getStringExtra(Constants.KEY_CONTENT);
        if(!TextUtils.isEmpty(url)){
            webview.loadUrl(url);
        }

        if(!TextUtils.isEmpty(content)){
            webview.loadData(content,"text/html","utf-8");
        }



    }

    @OnClick(R2.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
