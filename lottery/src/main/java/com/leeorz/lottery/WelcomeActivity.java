package com.leeorz.lottery;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lottery.main.MainActivity;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/28 下午5:53
 * description:
 */
public class WelcomeActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        CountDownTimer timer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                gotoActivity(MainActivity.class);
                finish();
            }
        };
        timer.start();
    }
}
