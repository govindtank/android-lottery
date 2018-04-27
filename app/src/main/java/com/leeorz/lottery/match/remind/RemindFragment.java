package com.leeorz.lottery.match.remind;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.leeorz.lib.api.API;
import com.leeorz.lib.api.ApiCallback;
import com.leeorz.lib.api.ApiObserver;
import com.leeorz.lib.api.ApiResult;
import com.leeorz.lib.base.BaseAdapter;
import com.leeorz.lib.base.BaseFragment;
import com.leeorz.lottery.R;
import com.leeorz.lottery.api.FootBallApi;
import com.leeorz.lottery.api.FootBallApiResult;
import com.leeorz.lottery.bean.ColdHotIndexResultBean;
import com.leeorz.lottery.match.MatchDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author: leeorz
 * email:378229364@qq.com
 * created on: 2018/4/27 上午11:04
 * description:
 */
public class RemindFragment extends BaseFragment {

    @BindView(R.id.lv_content)
    ListView lvContent;
    Unbinder unbinder;

    private String t;
    private RemindAdapter remindAdapter;

    public static RemindFragment newInstance(String t) {

        Bundle args = new Bundle();
        args.putString("T", t);

        RemindFragment fragment = new RemindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        contentView = inflater.inflate(R.layout.fragment_remind, null);
        unbinder = ButterKnife.bind(this, contentView);
        initView();
        return contentView;
    }

    private void initView() {
        t = getArguments().getString("T");
        remindAdapter = new RemindAdapter(getActivity());
        lvContent.setAdapter(remindAdapter);
        getRemindData();

        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MatchDetailActivity.gotoThis(getActivity(),remindAdapter.getItem(position).getFid());
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void getRemindData() {
        FootBallApi footBallApi = API.getInstance(FootBallApi.class, FootBallApi.HOST);
        footBallApi.getRemindData(t, FootBallApi.REMIND_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver(new ApiCallback<List<RemindBean>>() {

                    @Override
                    public void onSuccess(ApiResult<List<RemindBean>> apiResult) {
                        remindAdapter.setData((List<RemindBean>) ((FootBallApiResult) apiResult).getData());
                        remindAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                }));
    }

    private class RemindAdapter extends BaseAdapter<RemindBean> {

        public RemindAdapter(Context context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            super.getView(position, convertView, parent);
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.template_remind_list_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            RemindBean bean = data.get(position);
            viewHolder.tvName.setText(bean.getTeam());
            viewHolder.tvDesc1.setText(bean.getLname() + " " + bean.getVsdate());
            viewHolder.tvDesc2.setText(bean.getHname() + " " + bean.getAname());
            viewHolder.tvRight.setText(bean.getMaxplate());
            viewHolder.tvRightBottom.setText("近期连" + bean.getPlatetype());

            viewHolder.tvHistory.setText(bean.getHistory());
            return convertView;
        }
    }
    static class ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_flag)
        TextView tvFlag;
        @BindView(R.id.tv_desc1)
        TextView tvDesc1;
        @BindView(R.id.tv_desc2)
        TextView tvDesc2;
        @BindView(R.id.tv_right)
        TextView tvRight;
        @BindView(R.id.tv_right_bottom)
        TextView tvRightBottom;
        @BindView(R.id.tv_history)
        TextView tvHistory;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
