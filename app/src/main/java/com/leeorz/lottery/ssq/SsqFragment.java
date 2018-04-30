package com.leeorz.lottery.ssq;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.leeorz.lottery.api.FootBallApi;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.api.PApi;
import com.leeorz.lottery.match.remind.RemindBean;
import com.leeorz.lottery.ssq.analysis.SsqAnalysisActivity;
import com.leeorz.lottery.ssq.detail.SsqDetailActivity;
import com.leeorz.lottery.widget.RefreshHeader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/24 下午5:30
 * description:
 */
public class SsqFragment extends BaseFragment implements OnRefreshListener,OnLoadMoreListener{
    @BindView(R.id.lv_content)
    RefreshListView lvContent;
    Unbinder unbinder;
    @BindView(R.id.tv_right)
    TextView tv_right;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private SsqAdapter ssqAdapter;
    private List<SsqBean> ssqBeanList = new ArrayList();

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
        ssqAdapter.setData(ssqBeanList);

        lvContent.setRefreshHeader(new RefreshHeader(getActivity()));
        lvContent.setListSelector(new BitmapDrawable());
        lvContent.setDivider(null);
        lvContent.setDividerHeight(UnitUtil.dp2px(getActivity(),2));
        lvContent.getRefreshListView().setAdapter(ssqAdapter);
        lvContent.setOnRefreshListener(this);
        lvContent.getRefreshListView().setOnLoadMoreListener(this);
        lvContent.getRefreshListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position != ssqAdapter.getCount()) {
                    SsqDetailActivity.gotoThis(getActivity(),ssqAdapter.getItem(position).getId());
                }
            }
        });

        lvContent.autoRefresh();
    }

    private void getSsq(final String id){
        PApi footBallApi = API.getInstance(PApi.class, PApi.HOST);
        footBallApi.getSsqList(id,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<List<SsqBean>>() {

                    @Override
                    public void onSuccess(ApiResult<List<SsqBean>> apiResult) {


                        if(id.equals("0")){
                            lvContent.refreshComplete();
                            ssqBeanList.clear();
                        }

                        ssqBeanList.addAll((List<SsqBean>) ((FootBallApiResult) apiResult).getData());
                        ssqAdapter.notifyDataSetChanged();
                        lvContent.getRefreshListView().complete( ((List<SsqBean>) ((FootBallApiResult) apiResult).getData()).size() != 0);
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

    @OnClick(R.id.tv_right)
    public void onViewClicked() {
        gotoActivity(SsqAnalysisActivity.class);
    }

    @Override
    public void onLoadMore(int i) {
        getSsq(ssqAdapter.getData().get(ssqAdapter.getCount() - 1).getId());
    }

    @Override
    public void onRefresh() {
        getSsq("0");
    }
}
