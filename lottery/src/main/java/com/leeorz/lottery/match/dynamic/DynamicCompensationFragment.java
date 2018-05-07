package com.leeorz.lottery.match.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.leeorz.lottery.R2;
import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lib.base.BaseFragment;
import com.leeorz.lottery.R;
import com.leeorz.lottery.api.FootBallApi;
import com.leeorz.lottery.api.FootBallApiResult;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 下午3:35
 * description:
 */
public class DynamicCompensationFragment extends BaseFragment {

    @BindView(R2.id.lv_content)
    ListView lvContent;
    Unbinder unbinder;

    private DynamicCompensationAdapter dynamicCompensationAdapter;
    private String t;
    public static DynamicCompensationFragment newInstance(String t) {

        Bundle args = new Bundle();
        args.putString("T",t);
        DynamicCompensationFragment fragment = new DynamicCompensationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(R.layout.fragment_dynamic_compensation, null);
        unbinder = ButterKnife.bind(this, contentView);
        initView();
        return contentView;
    }

    private void initView(){
        t = getArguments().getString("T");
        dynamicCompensationAdapter = new DynamicCompensationAdapter(getActivity());
        lvContent.setAdapter(dynamicCompensationAdapter);

        getDynamicCompensation();
    }

    private void getDynamicCompensation() {
        FootBallApi footBallApi = API.getInstance(FootBallApi.class, FootBallApi.HOST);
        footBallApi.getDynamicCompensation(t, FootBallApi.DYNAMIC_COMPENSATION_KEY,FootBallApi.C_CK)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<List<DynamicCompensationBean>>() {

                    @Override
                    public void onSuccess(ApiResult<List<DynamicCompensationBean>> apiResult) {
                        dynamicCompensationAdapter.setData((List<DynamicCompensationBean>) ((FootBallApiResult) apiResult).getData());
                        dynamicCompensationAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class DynamicCompensationAdapter extends BaseAdapter<DynamicCompensationBean> {

        public DynamicCompensationAdapter(Context context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            super.getView(position, convertView, parent);
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.template_dynamic_compensation_list_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            DynamicCompensationBean bean = data.get(position);
            viewHolder.tvAname.setText(bean.getAname());
            viewHolder.tvHname.setText(bean.getHname());
            viewHolder.tvDate.setText(bean.getLname() + bean.getVsdate());
            if(t.equals("1")){
                viewHolder.tvNum1.setText(bean.getWin());
                viewHolder.tvNum2.setText(bean.getDraw());
                viewHolder.tvNum3.setText(bean.getLost());
            }else if(t.equals("2")){
                viewHolder.tvNum1.setText(bean.getDraw());
//                viewHolder.tvNum2.setText(bean.getDraw());
                viewHolder.tvNum3.setText(bean.getLost());
            }else {
                viewHolder.tvNum1.setText(bean.getDraw() + " " +bean.getWin());
//                viewHolder.tvNum2.setText(bean.getDraw());
                viewHolder.tvNum3.setText(bean.getLost());
            }

            viewHolder.tvDesc.setText("盘口变化" + bean.getChange() + "次");
            return convertView;
        }
    }

    static class ViewHolder {
        @BindView(R2.id.tv_date)
        TextView tvDate;
        @BindView(R2.id.tv_hname)
        TextView tvHname;
        @BindView(R2.id.tv_aname)
        TextView tvAname;
        @BindView(R2.id.tv_num1)
        TextView tvNum1;
        @BindView(R2.id.tv_num2)
        TextView tvNum2;
        @BindView(R2.id.tv_num3)
        TextView tvNum3;
        @BindView(R2.id.tv_desc)
        TextView tvDesc;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
