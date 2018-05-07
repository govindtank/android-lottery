package com.leeorz.lottery.match.remind;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lottery.R;
import com.leeorz.lottery.R2;
import com.leeorz.lottery.api.FootBallApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 上午10:56
 * description:
 */
public class RemindActivity extends BaseActivity {

    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.tv_module1)
    TextView tvModule1;
    @BindView(R2.id.tv_module2)
    TextView tvModule2;
    @BindView(R2.id.tv_module3)
    TextView tvModule3;
    @BindView(R2.id.iv_back)
    ImageView ivBack;
    @BindView(R2.id.fl_content)
    FrameLayout flContent;

    private RemindFragment remindFragment1,remindFragment2,remindFragment3;
    private String TAG_REMIND_FRAGMENT1 = "TAG_REMIND_FRAGMENT1";
    private String TAG_REMIND_FRAGMENT2 = "TAG_REMIND_FRAGMENT2";
    private String TAG_REMIND_FRAGMENT3 = "TAG_REMIND_FRAGMENT3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            remindFragment1 = (RemindFragment) getSupportFragmentManager().findFragmentByTag(TAG_REMIND_FRAGMENT1);
            remindFragment2 = (RemindFragment) getSupportFragmentManager().findFragmentByTag(TAG_REMIND_FRAGMENT2);
            remindFragment3 = (RemindFragment) getSupportFragmentManager().findFragmentByTag(TAG_REMIND_FRAGMENT3);
        }
        setContentView(R.layout.activity_remind);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("极限提点");
        tvModule1.performClick();
    }

    @OnClick(R2.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @OnClick({R2.id.tv_module1, R2.id.tv_module2, R2.id.tv_module3})
    public void onViewClicked(View view) {
        tvModule1.setTextColor(getResources().getColor(R.color.app_black));
        tvModule2.setTextColor(getResources().getColor(R.color.app_black));
        tvModule3.setTextColor(getResources().getColor(R.color.app_black));
        int id = view.getId();
        if(id == R.id.tv_module1) {
            tvModule1.setTextColor(getResources().getColor(R.color.app_main_color));
            showTargetFragment(getTargetFragment(id), TAG_REMIND_FRAGMENT1);
        }else if(id == R.id.tv_module2) {
            tvModule2.setTextColor(getResources().getColor(R.color.app_main_color));
            showTargetFragment(getTargetFragment(id),TAG_REMIND_FRAGMENT2);
        }else if(id == R.id.tv_module3) {
            tvModule3.setTextColor(getResources().getColor(R.color.app_main_color));
            showTargetFragment(getTargetFragment(id),TAG_REMIND_FRAGMENT3);
        }
    }

    private void showTargetFragment(Fragment fragment,String tag){
        if(fragment == null)return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(remindFragment1 != null && remindFragment1.isAdded())transaction.hide(remindFragment1);
        if(remindFragment2 != null && remindFragment2.isAdded())transaction.hide(remindFragment2);
        if(remindFragment3 != null && remindFragment3.isAdded())transaction.hide(remindFragment3);

        if(!fragment.isAdded()){
            transaction.add(R.id.fl_content,fragment,tag);
        }

        transaction.show(fragment);
        transaction.commitAllowingStateLoss();

    }

    private Fragment getTargetFragment(int id){
        if(id == R.id.tv_module1) {
            if (remindFragment1 == null)
                remindFragment1 = RemindFragment.newInstance(FootBallApi.REMIND_T1);
            return remindFragment1;
        }else if(id == R.id.tv_module2){
                if(remindFragment2 == null)remindFragment2 = RemindFragment.newInstance(FootBallApi.REMIND_T2);
                return remindFragment2;
        } else if(id ==  R.id.tv_module3){
            if(remindFragment3 == null)remindFragment3 = RemindFragment.newInstance(FootBallApi.REMIND_T3);
            return remindFragment3;

        }
        return null;
    }
}
