package com.leeorz.lottery.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.flyco.banner.widget.Banner.BaseIndicatorBanner;
import com.leeorz.lib.app.AppConfig;
import com.leeorz.lottery.R;
import com.squareup.picasso.Picasso;


/**
 * Created by lee on 2017/4/17.
 */

public class IndexBannerView extends BaseIndicatorBanner<String, IndexBannerView> {
    ImageView ivBanner;


    public IndexBannerView(Context context) {
        super(context);
    }

    public IndexBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexBannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public View onCreateItemView(int position) {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.template_index_banner_image, null);
        ivBanner = (ImageView) contentView.findViewById(R.id.iv_banner);
        ivBanner.setLayoutParams(new LinearLayout.LayoutParams(AppConfig.SCREEN_WIDTH,(int) (AppConfig.SCREEN_WIDTH * 0.5)));
        Picasso.with(mContext)
                .load(mDatas.get(position))
                .fit()
                .into(ivBanner);
        return contentView;
    }

}
