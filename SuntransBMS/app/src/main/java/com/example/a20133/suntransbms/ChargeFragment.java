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
import android.widget.TextView;

/**
 * Created by 20133 on 2017/3/7.
 */

public class ChargeFragment extends Fragment {
    private ImageButton imageButton;
    private LoadingDialog dialog;
    private Button chargeButtonStart11;
    private Button chargeButtonStop11;
    private Button chargeButtonStart12;
    private Button chargeButtonStop12;
    private Button chargeButtonStart13;
    private Button chargeButtonStop13;
    private Button chargeButtonStart14;
    private Button chargeButtonStop14;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.charge, container, false);
        ((PullToRefreshLayout) view.findViewById(R.id.id_charge_fragment))
                .setOnRefreshListener(new MyListener());
        imageButton = (ImageButton) getActivity().findViewById(R.id.query_btn);
        chargeButtonStart11 = (Button) view.findViewById(R.id.id_charge_Start_Btn11);
        chargeButtonStop11 = (Button) view.findViewById(R.id.id_charge_stop_Btn11);
        chargeButtonStart12 = (Button) view.findViewById(R.id.id_charge_Start_Btn12);
        chargeButtonStop12 = (Button) view.findViewById(R.id.id_charge_stop_Btn12);
        chargeButtonStart13 = (Button) view.findViewById(R.id.id_charge_Start_Btn13);
        chargeButtonStop13 = (Button) view.findViewById(R.id.id_charge_stop_Btn13);
        chargeButtonStart14 = (Button) view.findViewById(R.id.id_charge_Start_Btn14);
        chargeButtonStop14 = (Button) view.findViewById(R.id.id_charge_stop_Btn14);
        dialog = new LoadingDialog(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvent();
    }

    private void initEvent() {
        chargeButtonStart11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("开始充电");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        chargeButtonStop11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("停止充电");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        chargeButtonStart12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("开始充电");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        chargeButtonStop12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("停止充电");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        chargeButtonStart13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("开始充电");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        chargeButtonStop13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("停止充电");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        chargeButtonStart14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("开始充电");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        chargeButtonStop14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("停止充电");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });

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
