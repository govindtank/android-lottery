package com.leeorz.lottery.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leeorz.lib.utils.UnitUtil;
import com.leeorz.lib.widget.refresh.header.BaseRefreshHeader;
import com.leeorz.lottery.R;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 下午8:58
 * description:
 */
public class RefreshHeader extends BaseRefreshHeader {
    private ImageView ivFootBall;
    private TextView tvRefresh;
    private LinearLayout llContent;
    private RotateAnimation rotateAnimation;

    public RefreshHeader(Context context) {
        super(context);
        initView();
    }

    public RefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        setContentView(R.layout.template_refresh_header);
        tvRefresh = (TextView) contentView.findViewById(R.id.tv_refresh);
        llContent = (LinearLayout) contentView.findViewById(R.id.ll_content);
        ivFootBall = (ImageView) contentView.findViewById(R.id.iv_football);

        this.rotateAnimation = new RotateAnimation(0.0F,360.0F, 1, 0.5F, 1, 0.5F);
        this.rotateAnimation.setRepeatCount(-1);
        this.rotateAnimation.setInterpolator(new LinearInterpolator());
        this.rotateAnimation.setDuration(1000L);

        setContainerHeight(UnitUtil.dp2px(getContext(),60));
    }

    int oldAngle = 0;
    @Override
    public void onProgress(int progress) {
        super.onProgress(progress);
        llContent.setVisibility(VISIBLE);
        int nowAngle = (int) (360 * (progress / 100.0));
        ivFootBall.animate().rotationBy(nowAngle - oldAngle).setDuration(0).setInterpolator(new LinearInterpolator()).start();
        oldAngle = nowAngle;
        tvRefresh.setText("下拉刷新");
        if(progress == 100){
            tvRefresh.setText("松开刷新");
        }
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        ivFootBall.startAnimation(this.rotateAnimation);
        tvRefresh.setText("刷新中...");
    }

    @Override
    public void onRefreshComplete() {
        super.onRefreshComplete();
        tvRefresh.setText("刷新完毕");
        llContent.setVisibility(GONE);
        ivFootBall.clearAnimation();
    }
}
