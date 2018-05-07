package com.leeorz.lottery.match.dynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.leeorz.lottery.R2;
import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lottery.R;
import com.leeorz.lottery.api.FootBallApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 下午3:17
 * description:
 */
public class DynamicCompensationActivity extends BaseActivity {

    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.tv_module1)
    TextView tvModule1;
    @BindView(R2.id.tv_module2)
    TextView tvModule2;
    @BindView(R2.id.tv_module3)
    TextView tvModule3;

    private DynamicCompensationFragment dynamicCompensationFragment1,dynamicCompensationFragment2,dynamicCompensationFragment3;
    private String TAG_FRAGMENT1 = "dynamicCompensationFragment1";
    private String TAG_FRAGMENT2 = "dynamicCompensationFragment2";
    private String TAG_FRAGMENT3 = "dynamicCompensationFragment3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            dynamicCompensationFragment1 = (DynamicCompensationFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT1);
            dynamicCompensationFragment2 = (DynamicCompensationFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT2);
            dynamicCompensationFragment3 = (DynamicCompensationFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT3);
        }
        setContentView(R.layout.activity_dynamic_compensation);
        ButterKnife.bind(this);

        initView();
    }

    private void initView(){
        tvTitle.setText("动态同赔");
        tvModule1.performClick();
    }

    @OnClick({R2.id.tv_module1, R2.id.tv_module2, R2.id.tv_module3})
    public void onViewClicked(View view) {
        tvModule1.setTextColor(getResources().getColor(R.color.app_black));
        tvModule2.setTextColor(getResources().getColor(R.color.app_black));
        tvModule3.setTextColor(getResources().getColor(R.color.app_black));
        int id = view.getId();
        if(id == R.id.tv_module1){
            tvModule1.setTextColor(getResources().getColor(R.color.app_main_color));
            showTargetFragment(getTargetFragment(id),TAG_FRAGMENT1);
        }else if(id == R.id.tv_module2){
            tvModule2.setTextColor(getResources().getColor(R.color.app_main_color));
            showTargetFragment(getTargetFragment(id),TAG_FRAGMENT2);
        }else if(id == R.id.tv_module3){
            tvModule3.setTextColor(getResources().getColor(R.color.app_main_color));
            showTargetFragment(getTargetFragment(id),TAG_FRAGMENT3);
        }
    }

    private void showTargetFragment(Fragment fragment, String tag){
        if(fragment == null)return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(dynamicCompensationFragment1 != null && dynamicCompensationFragment1.isAdded())transaction.hide(dynamicCompensationFragment1);
        if(dynamicCompensationFragment2 != null && dynamicCompensationFragment2.isAdded())transaction.hide(dynamicCompensationFragment2);
        if(dynamicCompensationFragment3 != null && dynamicCompensationFragment3.isAdded())transaction.hide(dynamicCompensationFragment3);

        if(!fragment.isAdded()){
            transaction.add(R.id.fl_content,fragment,tag);
        }

        transaction.show(fragment);
        transaction.commitAllowingStateLoss();

    }

    private Fragment getTargetFragment(int id){

        if(id == R.id.tv_module1){
            if(dynamicCompensationFragment1 == null)dynamicCompensationFragment1 = DynamicCompensationFragment.newInstance(FootBallApi.REMIND_T1);
            return dynamicCompensationFragment1;
        }else if(id == R.id.tv_module2){
            if(dynamicCompensationFragment2 == null)dynamicCompensationFragment2 = DynamicCompensationFragment.newInstance(FootBallApi.REMIND_T2);
            return dynamicCompensationFragment2;
        }else if(id == R.id.tv_module3){
            if(dynamicCompensationFragment3 == null)dynamicCompensationFragment3 = DynamicCompensationFragment.newInstance(FootBallApi.REMIND_T3);
            return dynamicCompensationFragment3;
        }
        return null;
    }

    @OnClick(R2.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
