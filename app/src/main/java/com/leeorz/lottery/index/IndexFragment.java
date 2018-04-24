package com.leeorz.lottery.index;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.leeorz.lib.app.AppConfig;
import com.leeorz.lib.base.BaseFragment;
import com.leeorz.lottery.R;
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
public class IndexFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.lv_content)
    ListView lvContent;

    public static IndexFragment newInstance() {

        Bundle args = new Bundle();

        IndexFragment fragment = new IndexFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(R.layout.fragment_index, null);
        unbinder = ButterKnife.bind(this, contentView);
        initView();
        return contentView;
    }

    /**
     * 初始化控件
     */
    private void initView() {
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
        List<Match> matchList = new ArrayList();
        matchList.add(new Match());
        matchList.add(new Match());
        matchList.add(new Match());
        matchList.add(new Match());
        matchAdapter.setData(matchList);
        lvContent.setAdapter(matchAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
