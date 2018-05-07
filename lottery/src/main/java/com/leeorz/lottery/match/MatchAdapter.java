package com.leeorz.lottery.match;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lottery.R;
import com.leeorz.lottery.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/24 下午9:44
 * description:
 */
public class MatchAdapter extends BaseAdapter<MatchBean> {
    public MatchAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.template_match_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MatchBean bean = data.get(position);
        viewHolder.tvLname.setText(bean.getLname());
        viewHolder.tvHname.setText(bean.getHname());
        viewHolder.tvAname.setText(bean.getAname());
        viewHolder.tvDate.setText(bean.getVsdate());
        viewHolder.tvHscore.setText(bean.getHscore());
        viewHolder.tvAscore.setText(bean.getAscore());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R2.id.tv_lname)
        TextView tvLname;
        @BindView(R2.id.tv_date)
        TextView tvDate;
        @BindView(R2.id.tv_hname)
        TextView tvHname;
        @BindView(R2.id.tv_aname)
        TextView tvAname;
        @BindView(R2.id.tv_hscore)
        TextView tvHscore;
        @BindView(R2.id.tv_ascore)
        TextView tvAscore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
