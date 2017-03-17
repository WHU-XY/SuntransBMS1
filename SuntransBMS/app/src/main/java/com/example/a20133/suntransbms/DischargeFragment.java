package com.example.a20133.suntransbms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by 20133 on 2017/3/7.
 */

public class DischargeFragment extends Fragment implements View.OnClickListener {
    private ImageButton queryButton;
    private TextView textView11;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.discharge,container,false);
        queryButton = (ImageButton) getActivity().findViewById(R.id.query_btn);
        queryButton.setOnClickListener(this);
        textView11 = (TextView)view.findViewById(R.id.id_discharge_parameter_TV11);
        return view;
    }

    @Override
    public void onClick(View v) {
        int cases = ((GlobalData)getActivity().getApplication()).getCases();
        if(cases == 3){
            Dischargewebservice dischargeAddressTask = new Dischargewebservice(textView11);
//                启动后台任务
            dischargeAddressTask.execute();
        }
    }
}
