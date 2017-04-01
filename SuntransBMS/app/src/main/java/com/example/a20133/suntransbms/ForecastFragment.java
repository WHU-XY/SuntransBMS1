package com.example.a20133.suntransbms;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * Created by 20133 on 2017/3/7.
 */

public class ForecastFragment extends Fragment  {
//    private LoadingDialog dialog;
    private ImageButton imageButton;
//    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forecast, container, false);
        ((PullToRefreshLayout) view.findViewById(R.id.id_forcast_fragment))
                .setOnRefreshListener(new MyListener());
        imageButton = (ImageButton) getActivity().findViewById(R.id.query_btn);
        /*dialog =  new LoadingDialog(getActivity());
        dialog.loadDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.removeDialog();
            }
        },1000);*/
        return view;
    }



    private class MyListener implements PullToRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {

            new Handler() {
                @Override
                public void handleMessage(Message msg) {

                    pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
                }
            }.sendEmptyMessageDelayed(0, 1000);
            imageButton.performClick();
        }

        @Override
        public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {

            new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
                }
            }.sendEmptyMessageDelayed(0, 1000);
        }
    }
}