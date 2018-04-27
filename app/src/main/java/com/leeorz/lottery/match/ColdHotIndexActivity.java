package com.leeorz.lottery.match;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lib.utils.StrUtil;
import com.leeorz.lib.utils.ToastUtil;
import com.leeorz.lottery.R;
import com.leeorz.lottery.api.FootBallApi;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.bean.ColdHotIndexResultBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/26 下午4:51
 * description:冷热指数
 */
public class ColdHotIndexActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_content)
    ListView lvContent;

    private ColdHotIndexResultAdapter coldHotIndexResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_hot_index);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvTitle.setText("冷热指数");

        coldHotIndexResultAdapter = new ColdHotIndexResultAdapter(getActivity());
        lvContent.setAdapter(coldHotIndexResultAdapter);
        getColdHotIndexData();

        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ColdHotIndexResultBean bean = coldHotIndexResultAdapter.getItem(position);
                MatchDetailActivity.gotoThis(getActivity(),bean.getFixtureid());
            }
        });
    }


    /**
     * 获取冷热指数
     */
    private void getColdHotIndexData() {
        FootBallApi footBallApi = API.getInstance(FootBallApi.class, FootBallApi.HOST);
        footBallApi.getFootBallColdHot(FootBallApi.T, FootBallApi.C_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<List<ColdHotIndexResultBean>>() {

                    @Override
                    public void onSuccess(ApiResult<List<ColdHotIndexResultBean>> apiResult) {
//                        ToastUtil.showShort(getActivity(), ((FootBallApiResult) apiResult).getMsg());
                        coldHotIndexResultAdapter.setData((List<ColdHotIndexResultBean>) ((FootBallApiResult) apiResult).getData());
                        coldHotIndexResultAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                }));


    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    private class ColdHotIndexResultAdapter extends BaseAdapter<ColdHotIndexResultBean> {

        public ColdHotIndexResultAdapter(Context context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            super.getView(position, convertView, parent);
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.template_cold_hot_index_list_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            ColdHotIndexResultBean bean = data.get(position);
            viewHolder.tvDate.setText(bean.getLeaguename() + bean.getMatchdatetime());
            viewHolder.tvColumn11.setText(bean.getHomesxname());
            viewHolder.tvColumn21.setText(bean.getHomescore() + ":" + bean.getAwayscore());
            viewHolder.tvColumn31.setText(bean.getAwaysxname());

            viewHolder.tvColumn12.setText(bean.getWin());
            viewHolder.tvColumn22.setText(bean.getDraw());
            viewHolder.tvColumn32.setText(bean.getLost());

            viewHolder.tvColumn13.setText(StrUtil.getPrice(Double.valueOf(bean.getWinamount())));
            viewHolder.tvColumn23.setText(StrUtil.getPrice(Double.valueOf(bean.getDrawamount())));
            viewHolder.tvColumn33.setText(StrUtil.getPrice(Double.valueOf(bean.getLostamount())));

            viewHolder.tvColumn14.setText(bean.getWinrate());
            viewHolder.tvColumn24.setText(bean.getDrawrate());
            viewHolder.tvColumn34.setText(bean.getLostrate());

            return convertView;
        }
    }

    static class ViewHolder {
        @BindView(R.id.tv_column_1_1)
        TextView tvColumn11;
        @BindView(R.id.tv_column_1_2)
        TextView tvColumn12;
        @BindView(R.id.tv_column_1_3)
        TextView tvColumn13;
        @BindView(R.id.tv_column_1_4)
        TextView tvColumn14;
        @BindView(R.id.tv_column_2_1)
        TextView tvColumn21;
        @BindView(R.id.tv_column_2_2)
        TextView tvColumn22;
        @BindView(R.id.tv_column_2_3)
        TextView tvColumn23;
        @BindView(R.id.tv_column_2_4)
        TextView tvColumn24;
        @BindView(R.id.tv_column_3_1)
        TextView tvColumn31;
        @BindView(R.id.tv_column_3_2)
        TextView tvColumn32;
        @BindView(R.id.tv_column_3_3)
        TextView tvColumn33;
        @BindView(R.id.tv_column_3_4)
        TextView tvColumn34;
        @BindView(R.id.tv_date)
        TextView tvDate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
