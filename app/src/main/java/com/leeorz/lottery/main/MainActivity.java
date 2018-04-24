package com.leeorz.lottery.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lottery.R;
import com.leeorz.lottery.index.IndexFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.ll_tab1)
    LinearLayout llTab1;
    @BindView(R.id.ll_tab2)
    LinearLayout llTab2;
    @BindView(R.id.ll_tab3)
    LinearLayout llTab3;
    @BindView(R.id.fl_content)
    FrameLayout flContent;

    private Fragment indexFragment,newsFragment,personalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        llTab1.performClick();
    }


    @OnClick({R.id.ll_tab1, R.id.ll_tab2, R.id.ll_tab3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_tab1:
            case R.id.ll_tab2:
            case R.id.ll_tab3:
                getTargetFragment(view.getId());
                break;
        }
    }

    /**
     * 显示对应的fragment
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(indexFragment != null && indexFragment.isAdded())transaction.hide(indexFragment);
        if(newsFragment != null && newsFragment.isAdded())transaction.hide(newsFragment);
        if(personalFragment != null && personalFragment.isAdded())transaction.hide(personalFragment);
        if(!fragment.isAdded()){
            transaction.add(R.id.fl_content,fragment);
        }

        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
    }

    /**
     * 获取对应的fragment
     *
     * @param id
     */
    private void getTargetFragment(int id) {
        switch (id) {
            case R.id.ll_tab1:
                if(indexFragment == null)indexFragment = IndexFragment.newInstance();
                llTab1.setEnabled(false);
                llTab2.setEnabled(true);
                llTab3.setEnabled(true);
                showFragment(indexFragment);
                break;
            case R.id.ll_tab2:
                if(newsFragment == null)newsFragment = NewsFragment.newInstance();
                llTab2.setEnabled(false);
                llTab1.setEnabled(true);
                llTab3.setEnabled(true);
                showFragment(newsFragment);
                break;
            case R.id.ll_tab3:
                if(personalFragment == null)personalFragment = PersonalFragment.newInstance();
                llTab3.setEnabled(false);
                llTab2.setEnabled(true);
                llTab1.setEnabled(true);
                showFragment(personalFragment);
                break;
        }
    }

}