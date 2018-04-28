package com.leeorz.lottery.ssq;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lottery.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 上午11:34
 * description:
 */
public class SsqAdapter extends BaseAdapter<SsqBean> {
    public SsqAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.template_ssq_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SsqBean bean = data.get(position);
        viewHolder.showBall(viewHolder.tvBlueBall1,bean.getBlue(),0);
        viewHolder.showBall(viewHolder.tvBlueBall2,bean.getBlue(),1);
        viewHolder.showBall(viewHolder.tvRedBall1,bean.getRed(),0);
        viewHolder.showBall(viewHolder.tvRedBall2,bean.getRed(),1);
        viewHolder.showBall(viewHolder.tvRedBall3,bean.getRed(),2);
        viewHolder.showBall(viewHolder.tvRedBall4,bean.getRed(),3);
        viewHolder.showBall(viewHolder.tvRedBall5,bean.getRed(),4);
        viewHolder.showBall(viewHolder.tvRedBall6,bean.getRed(),5);
        viewHolder.tvId.setText("第" + bean.getId() + "期");
        viewHolder.tvDate.setText("开奖时间:" + bean.getOpen_time());
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.tv_red_ball1)
        TextView tvRedBall1;
        @BindView(R.id.tv_red_ball2)
        TextView tvRedBall2;
        @BindView(R.id.tv_red_ball3)
        TextView tvRedBall3;
        @BindView(R.id.tv_red_ball4)
        TextView tvRedBall4;
        @BindView(R.id.tv_red_ball5)
        TextView tvRedBall5;
        @BindView(R.id.tv_red_ball6)
        TextView tvRedBall6;
        @BindView(R.id.tv_blue_ball1)
        TextView tvBlueBall1;
        @BindView(R.id.tv_blue_ball2)
        TextView tvBlueBall2;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_id)
        TextView tvId;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void showBall(TextView textView,String[] ball,int index){
            if(ball.length > index){
                textView.setVisibility(View.VISIBLE);
                textView.setText(ball[index]);
            }else{
                textView.setVisibility(View.GONE);
            }
        }
    }
}
