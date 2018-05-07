package com.leeorz.lottery.news;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lottery.R;
import com.leeorz.lottery.R2;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 上午10:24
 * description:
 */
public class NewsAdapter extends BaseAdapter<NewsBean> {
    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.template_new_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        NewsBean bean = data.get(position);
        if(!TextUtils.isEmpty(bean.getImg())){
            Picasso.with(mContext).load(bean.getImg()).resize(300,300).into(viewHolder.ivImage);
        }

        viewHolder.tvTitle.setText(bean.getTitle());
        viewHolder.tvDate.setText("时间:" + bean.getTime());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R2.id.iv_image)
        ImageView ivImage;
        @BindView(R2.id.tv_title)
        TextView tvTitle;
        @BindView(R2.id.tv_date)
        TextView tvDate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
