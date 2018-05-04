package com.leeorz.lottery.match;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.flyco.banner.widget.Banner.base.BaseBanner;
import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.app.AppConfig;
import com.leeorz.lib.base.BaseFragment;
import com.leeorz.lottery.R;
import com.leeorz.lottery.WebActivity;
import com.leeorz.lottery.api.FootBallApi;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.bean.MatchListResultBean;
import com.leeorz.lottery.match.dynamic.DynamicCompensationActivity;
import com.leeorz.lottery.match.remind.RemindActivity;
import com.leeorz.lottery.widget.IndexBannerView;
import com.leeorz.lottery.widget.LoadingDialog;

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
public class MatchFragment extends BaseFragment{


    Unbinder unbinder;
    @BindView(R.id.lv_content)
    ListView lvContent;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private MatchAdapter matchAdapter;
    private List<MatchBean> matchList = new ArrayList();
    private LoadingDialog loadingDialog;

    public static MatchFragment newInstance() {

        Bundle args = new Bundle();

        MatchFragment fragment = new MatchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(R.layout.fragment_match, null);
        unbinder = ButterKnife.bind(this, contentView);
        initView();
        getMatchList();
        return contentView;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tvTitle.setText("赛事");
        loadingDialog = LoadingDialog.newInstance(getActivity());
        ivBack.setVisibility(View.GONE);

        View headerView = mInflater.inflate(R.layout.header_match_banner,null);
        headerView.findViewById(R.id.ll_cold_hot_index).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivity(ColdHotIndexActivity.class);
            }
        });
        headerView.findViewById(R.id.ll_remind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivity(RemindActivity.class);
            }
        });
        headerView.findViewById(R.id.ll_dynamic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivity(DynamicCompensationActivity.class);
            }
        });
        IndexBannerView banner = (IndexBannerView) headerView.findViewById(R.id.banner);

        banner.setLayoutParams(new LinearLayout.LayoutParams(AppConfig.SCREEN_WIDTH, (int) (AppConfig.SCREEN_WIDTH * 0.5)));
        List<String> images = new ArrayList();
        images.add("http://res.tuiqiucai.com/template/20180427/db84228e5ae740d9ab807dd7d01434a4.jpg");
        images.add("http://res.tuiqiucai.com/template/20180427/3d319547df97462c8932a57ca991aa47.jpg");
        images.add("http://res.tuiqiucai.com/template/20180427/d873032d59624227bf08aba9f5c88d11.jpg");
        banner.setSource(images);
        banner.setOnItemClickL(new BaseBanner.OnItemClickL() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0:
                        WebActivity.gotoThis(getActivity(),"咨询详情","file:///android_asset/banner1.html");
                        break;
                    case 1:
                        WebActivity.gotoThis(getActivity(),"咨询详情","file:///android_asset/banner2.html");
                        break;
                    case 2:
                        WebActivity.gotoThis(getActivity(),"咨询详情","file:///android_asset/banner3.html");
                        break;

                }
            }
        });
        banner.setAutoScrollEnable(true);
        banner.startScroll();

        matchAdapter = new MatchAdapter(getActivity());
        matchAdapter.setData(matchList);
        lvContent.addHeaderView(headerView);
        lvContent.setAdapter(matchAdapter);
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position = position - 1;
                MatchDetailActivity.gotoThis(getActivity(),matchAdapter.getItem(position).getFid());
            }
        });
    }

    private void getMatchList(){
        loadingDialog.show();
        FootBallApi footBallApi = API.getInstance(FootBallApi.class, FootBallApi.HOST);
        footBallApi.getMatchList("1",FootBallApi.MATCH_LIST_KEY,String.valueOf(System.currentTimeMillis()),"3","1",FootBallApi.C_CK)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<MatchListResultBean>() {

                    @Override
                    public void onSuccess(ApiResult<MatchListResultBean> apiResult) {
                        loadingDialog.dismiss();
                        matchList.addAll(((MatchListResultBean) ((FootBallApiResult) apiResult).getData()).getList());
                        matchAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        loadingDialog.dismiss();
                    }
                }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
