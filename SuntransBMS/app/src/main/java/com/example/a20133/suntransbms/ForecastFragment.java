package com.example.a20133.suntransbms;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

/**
 * Created by 20133 on 2017/3/7.
 */

public class ForecastFragment extends Fragment implements View.OnClickListener {


    private TextView resultView11;
    private TextView resultView12;
    private TextView resultView13;
    private TextView resultView14;
    private TextView resultView15;
    private TextView resultView16;
    private TextView resultView17;
    private TextView resultView21;
    private TextView resultView22;
    private TextView resultView23;
    private TextView resultView24;
    private TextView resultView25;
    private TextView resultView26;
    private TextView resultView27;
    private TextView resultView31;
    private TextView resultView32;
    private TextView resultView33;
    private TextView resultView34;
    private TextView resultView35;
    private TextView resultView36;
    private TextView resultView37;
    private TextView resultView41;
    private TextView resultView42;
    private TextView resultView43;
    private TextView resultView44;
    private TextView resultView45;
    private TextView resultView46;
    private TextView resultView47;
    private ImageButton queryButton;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.forecast, container, false);
        queryButton = (ImageButton) getActivity().findViewById(R.id.query_btn);
        resultView11 = (TextView) view.findViewById(R.id.id_forcast_TV11);
        resultView12 = (TextView) view.findViewById(R.id.id_forcast_TV12);
        resultView13 = (TextView) view.findViewById(R.id.id_forcast_TV13);
        resultView14 = (TextView) view.findViewById(R.id.id_forcast_TV14);
        resultView15 = (TextView) view.findViewById(R.id.id_forcast_TV15);
        resultView16 = (TextView) view.findViewById(R.id.id_forcast_TV16);
        resultView17 = (TextView) view.findViewById(R.id.id_forcast_TV17);
        resultView21 = (TextView) view.findViewById(R.id.id_forcast_TV21);
        resultView22 = (TextView) view.findViewById(R.id.id_forcast_TV22);
        resultView23 = (TextView) view.findViewById(R.id.id_forcast_TV23);
        resultView24 = (TextView) view.findViewById(R.id.id_forcast_TV24);
        resultView25 = (TextView) view.findViewById(R.id.id_forcast_TV25);
        resultView26 = (TextView) view.findViewById(R.id.id_forcast_TV26);
        resultView27 = (TextView) view.findViewById(R.id.id_forcast_TV27);
        resultView31 = (TextView) view.findViewById(R.id.id_forcast_TV31);
        resultView32 = (TextView) view.findViewById(R.id.id_forcast_TV32);
        resultView33 = (TextView) view.findViewById(R.id.id_forcast_TV33);
        resultView34 = (TextView) view.findViewById(R.id.id_forcast_TV34);
        resultView35 = (TextView) view.findViewById(R.id.id_forcast_TV35);
        resultView36 = (TextView) view.findViewById(R.id.id_forcast_TV36);
        resultView37 = (TextView) view.findViewById(R.id.id_forcast_TV37);
        resultView41 = (TextView) view.findViewById(R.id.id_forcast_TV41);
        resultView42 = (TextView) view.findViewById(R.id.id_forcast_TV42);
        resultView43 = (TextView) view.findViewById(R.id.id_forcast_TV43);
        resultView44 = (TextView) view.findViewById(R.id.id_forcast_TV44);
        resultView45 = (TextView) view.findViewById(R.id.id_forcast_TV45);
        resultView46 = (TextView) view.findViewById(R.id.id_forcast_TV46);
        resultView47 = (TextView) view.findViewById(R.id.id_forcast_TV47);

       queryButton.setOnClickListener(this);
 /*      queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cases = ((GlobalData)getActivity().getApplication()).getCases();
                  if(cases == 1){
//                启动后台异步线程进行连接webService操作，并且根据返回结果在主线程中改变UI
                    Forcastwebservice queryAddressTask = new Forcastwebservice(resultView11, resultView12, resultView13, resultView14, resultView15, resultView16, resultView17,
                            resultView21, resultView22, resultView23, resultView24, resultView25, resultView26, resultView27,
                            resultView31, resultView32, resultView33, resultView34, resultView35, resultView36, resultView37,
                            resultView41, resultView42, resultView43, resultView44, resultView45, resultView46, resultView47);
//                启动后台任务
                    queryAddressTask.execute();}
                }
        });*/
        return view;
    }

    @Override
    public void onClick(View v) {
        int cases = ((GlobalData)getActivity().getApplication()).getCases();
        if(cases == 1){
//                启动后台异步线程进行连接webService操作，并且根据返回结果在主线程中改变UI
            Forcastwebservice forecastAddressTask = new Forcastwebservice(resultView11, resultView12, resultView13, resultView14, resultView15, resultView16, resultView17,
                    resultView21, resultView22, resultView23, resultView24, resultView25, resultView26, resultView27,
                    resultView31, resultView32, resultView33, resultView34, resultView35, resultView36, resultView37,
                    resultView41, resultView42, resultView43, resultView44, resultView45, resultView46, resultView47);
//                启动后台任务
            forecastAddressTask.execute();}
    }
}