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

import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.base.BaseFragment;
import com.leeorz.lib.utils.UnitUtil;
import com.leeorz.lib.widget.loadmore.OnLoadMoreListener;
import com.leeorz.lib.widget.refresh.OnRefreshListener;
import com.leeorz.lib.widget.refresh.RefreshListView;
import com.leeorz.lottery.R;
import com.leeorz.lottery.WebActivity;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.api.PApi;
import com.leeorz.lottery.ssq.SsqBean;
import com.leeorz.lottery.widget.RefreshHeader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/24 下午4:25
 * description:
 */
public class NewsFragment extends BaseFragment implements OnLoadMoreListener,OnRefreshListener{
    @BindView(R.id.lv_content)
    RefreshListView lvContent;
    Unbinder unbinder;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private NewsAdapter newsAdapter;

    private List<NewsBean> newsBeanList = new ArrayList();

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
        tvTitle.setText("资讯");
        ivBack.setVisibility(View.GONE);
        newsAdapter = new NewsAdapter(getActivity());
        newsAdapter.setData(newsBeanList);
        lvContent.setRefreshHeader(new RefreshHeader(getActivity()));
        lvContent.setOnRefreshListener(this);
        lvContent.getRefreshListView().setOnLoadMoreListener(this);
        lvContent.setListSelector(new BitmapDrawable());
        lvContent.setDivider(null);
        lvContent.setDividerHeight(UnitUtil.dp2px(getActivity(),2));
        lvContent.getRefreshListView().setAdapter(newsAdapter);
        lvContent.getRefreshListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position != newsAdapter.getCount()){
//                    NewsDetailActivity.gotoThis(getActivity(),newsAdapter.getItem(position).getId());
                    WebActivity.gotoThis(getActivity(),"详情","http://lottery.panghailong.com/api/news/info?id=" + newsAdapter.getItem(position).getId());
                }

            }
        });

        lvContent.autoRefresh();
    }

    private void getNewsList(final String id){
        PApi footBallApi = API.getInstance(PApi.class, PApi.HOST);
        footBallApi.getNewsList(id,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<List<NewsBean>>() {

                    @Override
                    public void onSuccess(ApiResult<List<NewsBean>> apiResult) {
                        if(id.equals("0")){
                            lvContent.refreshComplete();
                            newsBeanList.clear();
                        }

                        newsBeanList.addAll((List<NewsBean>) ((FootBallApiResult) apiResult).getData());
                        newsAdapter.notifyDataSetChanged();
                        lvContent.getRefreshListView().complete( ((List<NewsBean>) ((FootBallApiResult) apiResult).getData()).size() != 0);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoadMore(int i) {
        getNewsList(newsBeanList.get(newsBeanList.size() - 1).getId());
    }

    @Override
    public void onRefresh() {
        getNewsList("0");
    }
}
