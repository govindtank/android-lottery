package com.leeorz.lottery.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.leeorz.lottery.R;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/5/2 上午10:15
 * description:
 */
public class LoadingDialog extends Dialog {
    private View contentView;
    private ImageView loadingView;
    private RotateAnimation rotateAnimation;
    private static LoadingDialog loadingDialog;

    public static LoadingDialog newInstance(Activity activity){
        return new LoadingDialog(activity);

    }

    public LoadingDialog(Context context) {
        super(context, com.leeorz.lib.R.style.LoadingDialogTheme);
        initView();
    }

    private void initView() {

        contentView = getLayoutInflater().inflate(R.layout.dialog_loading, null);
        setContentView(contentView);
        loadingView = (ImageView) contentView.findViewById(R.id.loadingView);
        setCancelable(false);

        this.rotateAnimation = new RotateAnimation(0.0F,360.0F, 1, 0.5F, 1, 0.5F);
        this.rotateAnimation.setRepeatCount(-1);
        this.rotateAnimation.setInterpolator(new LinearInterpolator());
        this.rotateAnimation.setDuration(1000L);
    }

    @Override
    public void show() {
        super.show();
        loadingView.startAnimation(this.rotateAnimation);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        loadingView.clearAnimation();

    }
}
