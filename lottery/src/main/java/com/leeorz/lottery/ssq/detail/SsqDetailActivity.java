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

import com.leeorz.lottery.R2;
import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lib.utils.UnitUtil;
import com.leeorz.lottery.R;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.api.PApi;
import com.leeorz.lottery.bean.SsqDetailResultBean;
import com.leeorz.lottery.constants.Constants;
import com.leeorz.lottery.ssq.analysis.SsqAnalysisActivity;
import com.leeorz.lottery.widget.LoadingDialog;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 下午5:06
 * description:
 */
public class SsqDetailActivity extends BaseActivity {

    @BindView(R2.id.iv_back)
    ImageView ivBack;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.llBall)
    LinearLayout llBall;
    @BindView(R2.id.lvDetail)
    ListView lvDetail;
    @BindView(R2.id.tv_id)
    TextView tvId;
    @BindView(R2.id.tv_date)
    TextView tvDate;
    @BindView(R2.id.tv_sale_count)
    TextView tvSaleCount;
    @BindView(R2.id.tv_money_total)
    TextView tvMoneyTotal;
    private LoadingDialog loadingDialog;
    private String id = "";

    public static void gotoThis(Context context, String id) {
        Intent intent = new Intent(context, SsqDetailActivity.class);
        intent.putExtra(Constants.KEY_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssq_detail);
        ButterKnife.bind(this);

        initView();
        id = getIntent().getStringExtra(Constants.KEY_ID);
        getSsqDetail(id);
    }

    public static String formatNumber(Integer val) {
        if (val == null) {
            return "";
        } else {
            DecimalFormat df = new DecimalFormat("#,###,##0");
            return df.format(val);
        }
    }

    private void getSsqDetail(String id) {
        loadingDialog.show();
        PApi footBallApi = API.getInstance(PApi.class, PApi.HOST);
        footBallApi.getSsqDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<SsqDetailResultBean>() {

                    @Override
                    public void onSuccess(ApiResult<SsqDetailResultBean> apiResult) {
                        loadingDialog.dismiss();
                        SsqDetailResultBean bean = (SsqDetailResultBean) ((FootBallApiResult) apiResult).getData();
                        addBall(bean.getRed().split(","), true);
                        addBall(bean.getBlue().split(","), false);

                        tvId.setText("第" + bean.getId() + "期");
                        tvDate.setText("开奖时间:" + bean.getOpen_date());
                        tvSaleCount.setText(formatNumber(bean.getTz_money()));
                        tvMoneyTotal.setText(formatNumber(bean.getJc_money()));

                        DetailAdapter detailAdapter = new DetailAdapter(getActivity());
                        List<DetailBean> detailBeanList = new ArrayList();
                        detailBeanList.add(new DetailBean("一等奖", bean.getZ_1(), bean.getJ_1()));
                        detailBeanList.add(new DetailBean("二等奖", bean.getZ_2(), bean.getJ_2()));
                        detailBeanList.add(new DetailBean("三等奖", bean.getZ_3(), bean.getJ_3()));
                        detailBeanList.add(new DetailBean("四等奖", bean.getZ_4(), bean.getJ_4()));
                        detailBeanList.add(new DetailBean("五等奖", bean.getZ_5(), bean.getJ_5()));
                        detailBeanList.add(new DetailBean("六等奖", bean.getZ_6(), bean.getJ_6()));
                        detailAdapter.setData(detailBeanList);
                        lvDetail.setAdapter(detailAdapter);
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        loadingDialog.dismiss();
                    }
                }));
    }

    private void initView() {
        tvTitle.setText("双色球中奖详情");
        loadingDialog = LoadingDialog.newInstance(getActivity());
        lvDetail.addHeaderView(View.inflate(getActivity(), R.layout.header_ssq_detail, null));
    }

    private void addBall(String[] data, boolean isRed) {
        int width = UnitUtil.dp2px(getActivity(), 30);
        for (String ball : data) {
            TextView textView = new TextView(getActivity());
            textView.setBackgroundResource(isRed ? R.mipmap.ic_ssqredq : R.mipmap.ic_ssqblueq);

            ViewGroup.MarginLayoutParams lp = new LinearLayout.MarginLayoutParams(width, width);
            lp.setMargins(UnitUtil.dp2px(getActivity(), 5), 0, 0, 0);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(0, 0, 0, UnitUtil.dp2px(getActivity(), 5));
            textView.setTextColor(getResources().getColor(R.color.app_white));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            textView.setText(ball);
            llBall.addView(textView);
        }


    }

    @OnClick(R2.id.iv_back)
    public void onIvBackClicked() {
        finish();
    }

    @OnClick(R2.id.tv_analysis)
    public void onTvAnalysisClicked() {
//        SsqAnalysisDetailActivity.gotoThis(getActivity(),id);
        SsqAnalysisActivity.gotoThis(getActivity(),id);
    }


    static class DetailBean {
        private String desc = "";
        private int count = 0;
        private int money = 0;

        public DetailBean(String desc, int count, int money) {
            this.desc = desc;
            this.count = count;
            this.money = money;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
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
            DetailBean bean = data.get(position);
            viewHolder.llContent.setBackgroundColor(position % 2 == 1 ? 0x000000 : 0xffffff);
            viewHolder.tvDesc.setText(bean.getDesc());
            viewHolder.tvZ.setText(formatNumber(bean.getCount()));
            viewHolder.tvJ.setText(formatNumber(bean.getMoney()));
            return convertView;
        }
    }

    static class ViewHolder {
        @BindView(R2.id.tv_desc)
        TextView tvDesc;
        @BindView(R2.id.tv_z)
        TextView tvZ;
        @BindView(R2.id.tv_j)
        TextView tvJ;
        @BindView(R2.id.ll_content)
        LinearLayout llContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
