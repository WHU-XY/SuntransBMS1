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

public class DischargeFragment extends Fragment  {

    private ImageButton imageButton;
    private LoadingDialog dialog;
    private Button dischargeButtonStart11;
    private Button dischargeButtonStop11;
    private Button dischargeButtonStart12;
    private Button dischargeButtonStop12;
    private Button dischargeButtonStart13;
    private Button dischargeButtonStop13;
    private Button dischargeButtonStart14;
    private Button dischargeButtonStop14;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.discharge,container,false);
        ((PullToRefreshLayout) view.findViewById(R.id.id_discharge_fragment))
                .setOnRefreshListener(new MyListener());
        imageButton = (ImageButton) getActivity().findViewById(R.id.query_btn);
        dischargeButtonStart11 = (Button) view.findViewById(R.id.id_discharge_Start_Btn11);
        dischargeButtonStop11 = (Button) view.findViewById(R.id.id_discharge_stop_Btn11);
        dischargeButtonStart12 = (Button) view.findViewById(R.id.id_discharge_Start_Btn12);
        dischargeButtonStop12 = (Button) view.findViewById(R.id.id_discharge_stop_Btn12);
        dischargeButtonStart13 = (Button) view.findViewById(R.id.id_discharge_Start_Btn13);
        dischargeButtonStop13 = (Button) view.findViewById(R.id.id_discharge_stop_Btn13);
        dischargeButtonStart14 = (Button) view.findViewById(R.id.id_discharge_Start_Btn14);
        dischargeButtonStop14 = (Button) view.findViewById(R.id.id_discharge_stop_Btn14);
        dialog = new LoadingDialog(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvent();
    }

    private void initEvent() {
        dischargeButtonStart11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("开始放电-电池#1");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        dischargeButtonStop11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("停止放电-电池#1");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        dischargeButtonStart12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("开始放电-电池#2");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        dischargeButtonStop12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("停止放电-电池#2");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        dischargeButtonStart13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("开始放电-电池#3");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        dischargeButtonStop13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("停止放电-电池#3");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        dischargeButtonStart14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("开始放电-电池#4");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.removeDialog();
                    }
                },1000);
            }
        });
        dischargeButtonStop14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.loadDialog("停止放电-电池#4");
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
