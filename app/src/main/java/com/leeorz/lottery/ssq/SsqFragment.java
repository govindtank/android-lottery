package com.leeorz.lottery.ssq;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.leeorz.lib.base.BaseFragment;
import com.leeorz.lottery.R;
import com.leeorz.lottery.ssq.analysis.SsqAnalysisActivity;
import com.leeorz.lottery.ssq.detail.SsqDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/24 下午5:30
 * description:
 */
public class SsqFragment extends BaseFragment {
    @BindView(R.id.lv_content)
    ListView lvContent;
    Unbinder unbinder;
    @BindView(R.id.tv_right)
    TextView tv_right;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private SsqAdapter ssqAdapter;

    public static SsqFragment newInstance() {

        Bundle args = new Bundle();

        SsqFragment fragment = new SsqFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(R.layout.fragment_ssq, null);
        unbinder = ButterKnife.bind(this, contentView);
        initView();
        return contentView;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tvTitle.setText("双色球");
        ssqAdapter = new SsqAdapter(getActivity());
        List<SsqBean> ssqBeanList = new ArrayList();
        ssqBeanList.add(new SsqBean());
        ssqBeanList.add(new SsqBean());
        ssqBeanList.add(new SsqBean());
        ssqBeanList.add(new SsqBean());
        ssqBeanList.add(new SsqBean());
        ssqBeanList.add(new SsqBean());
        ssqBeanList.add(new SsqBean());
        ssqBeanList.add(new SsqBean());

        ssqAdapter.setData(ssqBeanList);
        lvContent.setAdapter(ssqAdapter);
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SsqDetailActivity.gotoThis(getContext());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tv_right)
    public void onViewClicked() {
        gotoActivity(SsqAnalysisActivity.class);
    }
}
