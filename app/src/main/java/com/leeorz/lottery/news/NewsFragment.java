package com.leeorz.lottery.news;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.leeorz.lib.base.BaseFragment;
import com.leeorz.lib.utils.UnitUtil;
import com.leeorz.lib.widget.refresh.RefreshListView;
import com.leeorz.lottery.R;
import com.leeorz.lottery.WebActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/24 下午4:25
 * description:
 */
public class NewsFragment extends BaseFragment {
    @BindView(R.id.lv_content)
    RefreshListView lvContent;
    Unbinder unbinder;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private NewsAdapter newsAdapter;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(R.layout.fragment_news, null);
        unbinder = ButterKnife.bind(this, contentView);
        initView();
        return contentView;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tvTitle.setText("新闻");
        ivBack.setVisibility(View.GONE);
        newsAdapter = new NewsAdapter(getActivity());
        List<NewsBean> newsBeanList = new ArrayList();
        newsBeanList.add(new NewsBean());
        newsBeanList.add(new NewsBean());
        newsBeanList.add(new NewsBean());
        newsBeanList.add(new NewsBean());
        newsBeanList.add(new NewsBean());
        newsBeanList.add(new NewsBean());
        newsBeanList.add(new NewsBean());
        newsBeanList.add(new NewsBean());

        newsAdapter.setData(newsBeanList);
        lvContent.setListSelector(new BitmapDrawable());
        lvContent.setDivider(null);
        lvContent.setDividerHeight(UnitUtil.dp2px(getActivity(),2));
        lvContent.getRefreshListView().setAdapter(newsAdapter);
        lvContent.getRefreshListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                WebActivity.gotoThis(getContext(),"百度","https://www.baidu.com");
                if(position != newsAdapter.getCount()){
                    WebActivity.gotoThis(getContext(),"百度","http://sports.sina.com.cn/l/tubiao/ssqhongqiuzoushi.html?from=wap");
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
