package com.leeorz.lottery.index;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lottery.R;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/24 下午9:44
 * description:
 */
public class MatchAdapter extends BaseAdapter<Match> {
    public MatchAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.template_match_item,null);
            viewHolder = new ViewHolder();
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    private class ViewHolder{

    }
}
