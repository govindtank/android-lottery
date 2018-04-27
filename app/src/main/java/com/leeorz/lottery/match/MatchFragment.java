package com.leeorz.lottery.match;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leeorz.lib.app.AppConfig;
import com.leeorz.lib.base.BaseFragment;
import com.leeorz.lib.widget.refresh.OnRefreshListener;
import com.leeorz.lib.widget.refresh.RefreshListView;
import com.leeorz.lottery.R;
import com.leeorz.lottery.match.dynamic.DynamicCompensationActivity;
import com.leeorz.lottery.match.remind.RemindActivity;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

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
public class MatchFragment extends BaseFragment implements OnRefreshListener{


    Unbinder unbinder;
    @BindView(R.id.lv_content)
    RefreshListView lvContent;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

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
        return contentView;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tvTitle.setText("赛事");
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
        Banner banner = headerView.findViewById(R.id.banner);

        banner.setLayoutParams(new LinearLayout.LayoutParams(AppConfig.SCREEN_WIDTH, (int) (AppConfig.SCREEN_WIDTH * 0.5)));
        List<String> images = new ArrayList();
        images.add("http://t2.hddhhn.com/uploads/tu/201804/9999/a02d7d8d21.jpg");
        images.add("http://t2.hddhhn.com/uploads/tu/201804/9999/5c46f5f236.jpg");
        images.add("http://t2.hddhhn.com/uploads/tu/201804/9999/7076b69af7.jpg");
        banner.setImageLoader(new BannerImageLoader());
        banner.setImages(images);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER)
                .start();

        MatchAdapter matchAdapter = new MatchAdapter(getActivity());
        List<MatchBean> matchList = new ArrayList();
        matchList.add(new MatchBean());
        matchList.add(new MatchBean());
        matchList.add(new MatchBean());
        matchList.add(new MatchBean());
        matchList.add(new MatchBean());
        matchList.add(new MatchBean());
        matchAdapter.setData(matchList);

        lvContent.getRefreshListView().addHeaderView(headerView);
        lvContent.setListSelector(new BitmapDrawable());
        lvContent.setDivider(null);
        lvContent.setDividerHeight(0);
        lvContent.getRefreshListView().setAdapter(matchAdapter);
        lvContent.setOnRefreshListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        lvContent.refreshComplete();
    }

    private class BannerImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(context)
                    .load((String) path)
                    .into(imageView);
        }
    }

}
