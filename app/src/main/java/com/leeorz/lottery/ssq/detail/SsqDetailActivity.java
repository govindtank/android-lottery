package com.leeorz.lottery.ssq.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lib.utils.ToastUtil;
import com.leeorz.lib.utils.UnitUtil;
import com.leeorz.lottery.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 下午5:06
 * description:
 */
public class SsqDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.llBall)
    LinearLayout llBall;
    @BindView(R.id.lvDetail)
    ListView lvDetail;

    public static void gotoThis(Context context) {
        Intent intent = new Intent(context, SsqDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssq_detail);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        tvTitle.setText("双色球中奖详情");
        List<Ball> ballList = new ArrayList();
        ballList.add(new Ball(true, "01"));
        ballList.add(new Ball(true, "02"));
        ballList.add(new Ball(true, "03"));
        ballList.add(new Ball(true, "04"));
        ballList.add(new Ball(true, "05"));
        ballList.add(new Ball(true, "16"));
        ballList.add(new Ball(false, "12"));

        addBall(ballList);

        lvDetail.addHeaderView(View.inflate(getActivity(), R.layout.header_ssq_detail, null));

        DetailAdapter detailAdapter = new DetailAdapter(getActivity());
        List<DetailBean> detailBeanList = new ArrayList();
        detailBeanList.add(new DetailBean());
        detailBeanList.add(new DetailBean());
        detailBeanList.add(new DetailBean());
        detailBeanList.add(new DetailBean());
        detailBeanList.add(new DetailBean());
        detailBeanList.add(new DetailBean());
        detailBeanList.add(new DetailBean());
        detailBeanList.add(new DetailBean());
        detailAdapter.setData(detailBeanList);
        lvDetail.setAdapter(detailAdapter);
    }

    private void addBall(List<Ball> data) {
        int width = UnitUtil.dp2px(getActivity(), 30);
        for (Ball ball : data) {
            TextView textView = new TextView(getActivity());
            textView.setBackgroundResource(ball.isRed ? R.mipmap.ic_ssqredq : R.mipmap.ic_ssqblueq);

            ViewGroup.MarginLayoutParams lp = new LinearLayout.MarginLayoutParams(width, width);
            lp.setMargins(UnitUtil.dp2px(getActivity(), 5), 0, 0, 0);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(0, 0, 0, UnitUtil.dp2px(getActivity(), 5));
            textView.setTextColor(getResources().getColor(R.color.app_white));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            textView.setText(ball.getNumber());
            llBall.addView(textView);
        }


    }

    @OnClick(R.id.iv_back)
    public void onIvBackClicked() {
        finish();
    }

    @OnClick(R.id.tv_analysis)
    public void onTvAnalysisClicked() {

        ToastUtil.showShort(getActivity(),"点击跳转到专家分析详情界面");
    }


//    @OnClick(R.id.iv_back)
//    public void onViewClicked() {
//        finish();
//    }
//
//    @OnClick(R.id.tv_analysis)
//    public void onViewClicked() {
//    }


    static class Ball {

        public Ball(boolean isRed, String number) {
            this.isRed = isRed;
            this.number = number;
        }

        private boolean isRed = true;
        private String number = "";

        public boolean isRed() {
            return isRed;
        }

        public void setRed(boolean red) {
            isRed = red;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    static class DetailBean {
        private String desc = "";
        private String count = "";
        private String money = "";

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }

    private class DetailAdapter extends BaseAdapter<DetailBean> {

        public DetailAdapter(Context context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            super.getView(position, convertView, parent);
            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.template_ssq_detail_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.llContent.setBackgroundColor(position % 2 == 1 ? 0x000000 : 0xffffff);
            return convertView;
        }


    }

    static class ViewHolder {
        @BindView(R.id.ll_content)
        LinearLayout llContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
