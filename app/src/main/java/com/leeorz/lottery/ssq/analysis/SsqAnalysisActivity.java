package com.leeorz.lottery.ssq.analysis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.base.BaseActivity;
import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lib.widget.loadmore.AutoLoadMoreListView;
import com.leeorz.lib.widget.loadmore.OnLoadMoreListener;
import com.leeorz.lottery.R;
import com.leeorz.lottery.WebActivity;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.api.PApi;
import com.leeorz.lottery.bean.SsqAnalysisBean;
import com.leeorz.lottery.constants.Constants;
import com.leeorz.lottery.news.NewsBean;
import com.leeorz.lottery.widget.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/25 下午2:32
 * description:
 */
public class SsqAnalysisActivity extends BaseActivity implements OnLoadMoreListener{

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_content)
    AutoLoadMoreListView lvContent;
    private AnalysisListAdapter analysisListAdapter;
    private List<SsqAnalysisBean> analysisList = new ArrayList();

    private String ssqId;
    private LoadingDialog loadingDialog;

    public static void gotoThis(Context context,String ssqId){
        Intent intent = new Intent(context,SsqAnalysisActivity.class);
        intent.putExtra(Constants.KEY_ID,ssqId);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssq_analysis);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ssqId = getIntent().getStringExtra(Constants.KEY_ID);
        if(TextUtils.isEmpty(ssqId)){
            tvTitle.setText("专家分析");
        }else{
            tvTitle.setText("第" +ssqId + "期双色球分析");
        }
        loadingDialog = new LoadingDialog(getActivity());


        analysisListAdapter = new AnalysisListAdapter(getActivity());
        analysisListAdapter.setData(analysisList);
        lvContent.setAdapter(analysisListAdapter);
        lvContent.setOnLoadMoreListener(this);

        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position != analysisListAdapter.getCount()){
//                    SsqAnalysisDetailActivity.gotoThis(getActivity(),String.valueOf(analysisListAdapter.getItem(position).getId()));
                    WebActivity.gotoThis(getActivity(),"预测详情","http://lottery.panghailong.com/api/zhuanjia/info?id="+analysisListAdapter.getItem(position).getId());
                }

            }
        });
        lvContent.reset();

//        getList("0");

    }

    private void getList(final String time){
        loadingDialog.show();
        PApi footBallApi = API.getInstance(PApi.class, PApi.HOST);
        Observable<FootBallApiResult<List<SsqAnalysisBean>>> observable;
        if(TextUtils.isEmpty(ssqId)){
            observable = footBallApi.getSsqAnalysisList(time,20);
        }else{
            observable = footBallApi.getSsqAnalysisList(time,ssqId,20);
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<List<SsqAnalysisBean>>() {

                    @Override
                    public void onSuccess(ApiResult<List<SsqAnalysisBean>> apiResult) {
                        loadingDialog.dismiss();
                        if(time.equals("0")){
                            analysisList.clear();
                        }

                        analysisList.addAll((List<SsqAnalysisBean>) ((FootBallApiResult) apiResult).getData());
                        analysisListAdapter.notifyDataSetChanged();
                        lvContent.complete( ((List<SsqAnalysisBean>) ((FootBallApiResult) apiResult).getData()).size() != 0);
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        loadingDialog.dismiss();
                    }
                }));
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onLoadMore(int i) {
        if(i == 0){
            getList("0");
        }else{
            getList(String.valueOf(analysisList.get(analysisList.size() - 1).getTime()));
        }

    }

    private class AnalysisListAdapter extends BaseAdapter<SsqAnalysisBean> {

        public AnalysisListAdapter(Context context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            super.getView(position, convertView, parent);
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.template_analysis_list_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            SsqAnalysisBean bean = data.get(position);
            viewHolder.tvTitle.setText(bean.getTitle());
            viewHolder.tvDesc.setText(bean.getDesn());
            viewHolder.tvDate.setText("时间:" + bean.getTime());
            return convertView;
        }


    }
    static class ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.tv_date)
        TextView tvDate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
