package com.leeorz.lottery.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lib.utils.ToastUtil;
import com.leeorz.lottery.R;
import com.leeorz.lottery.R2;
import com.leeorz.lottery.match.MatchFragment;
import com.leeorz.lottery.news.NewsFragment;
import com.leeorz.lottery.ssq.SsqFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R2.id.ll_tab1)
    LinearLayout llTab1;
    @BindView(R2.id.ll_tab2)
    LinearLayout llTab2;
    @BindView(R2.id.ll_tab3)
    LinearLayout llTab3;
    @BindView(R2.id.fl_content)
    FrameLayout flContent;

    private Fragment matchFragment,newsFragment,ssqFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(null != savedInstanceState){
            matchFragment = getSupportFragmentManager().findFragmentByTag(MatchFragment.class.getSimpleName());
            newsFragment = getSupportFragmentManager().findFragmentByTag(NewsFragment.class.getSimpleName());
            ssqFragment = getSupportFragmentManager().findFragmentByTag(SsqFragment.class.getSimpleName());
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        llTab1.performClick();
    }


    @OnClick({R2.id.ll_tab1, R2.id.ll_tab2, R2.id.ll_tab3})
    public void onViewClicked(View view) {
        getTargetFragment(view.getId());
    }

    /**
     * 显示对应的fragment
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(matchFragment != null && matchFragment.isAdded())transaction.hide(matchFragment);
        if(newsFragment != null && newsFragment.isAdded())transaction.hide(newsFragment);
        if(ssqFragment != null && ssqFragment.isAdded())transaction.hide(ssqFragment);
        if(!fragment.isAdded()){
            transaction.add(R.id.fl_content,fragment,fragment.getClass().getSimpleName());
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

        if(id == R.id.ll_tab1){
            if(matchFragment == null)matchFragment = MatchFragment.newInstance();
            llTab1.setEnabled(false);
            llTab2.setEnabled(true);
            llTab3.setEnabled(true);
            showFragment(matchFragment);
        }else if(id == R.id.ll_tab2){
            if(newsFragment == null)newsFragment = NewsFragment.newInstance();
            llTab2.setEnabled(false);
            llTab1.setEnabled(true);
            llTab3.setEnabled(true);
            showFragment(newsFragment);
        }else if(id == R.id.ll_tab3) {
            if (ssqFragment == null) ssqFragment = SsqFragment.newInstance();
            llTab3.setEnabled(false);
            llTab2.setEnabled(true);
            llTab1.setEnabled(true);
            showFragment(ssqFragment);
        }
    }


    private Long lastClickBackTime = 0l;
    private Long clickBackTime = 0l;

    @Override
    public void onBackPressed() {
        clickBackTime = System.currentTimeMillis();
        if (clickBackTime - lastClickBackTime > 2000) {
            ToastUtil.showShort(getActivity(), "再点一下退出");
        } else {
            super.onBackPressed();
        }
        lastClickBackTime = clickBackTime;
    }

}
