package com.example.a20133.suntransbms;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageButton;

/**
 * Created by 20133 on 2017/3/23.
 */

public class MyListener implements PullToRefreshLayout.OnRefreshListener {

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {

        new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {

                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
            }
        }.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {

        new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
            }
        }.sendEmptyMessageDelayed(0, 1000);
    }
}
