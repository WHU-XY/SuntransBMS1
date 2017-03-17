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

public class ChargeFragment extends Fragment implements View.OnClickListener{
    private ImageButton queryButton;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;
    private TextView textView18;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.charge,container,false);
        queryButton = (ImageButton) getActivity().findViewById(R.id.query_btn);
        textView11 = (TextView) view.findViewById(R.id.id_charge_check_TV11);
        textView12 = (TextView) view.findViewById(R.id.id_charge_check_TV12);
        textView13 = (TextView) view.findViewById(R.id.id_charge_check_TV13);
        textView14 = (TextView) view.findViewById(R.id.id_charge_check_TV14);
        textView15 = (TextView) view.findViewById(R.id.id_charge_check_TV15);
        textView16 = (TextView) view.findViewById(R.id.id_charge_check_TV16);
        textView17 = (TextView) view.findViewById(R.id.id_charge_check_TV17);
        textView18 = (TextView) view.findViewById(R.id.id_charge_check_TV18);
        queryButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int cases = ((GlobalData)getActivity().getApplication()).getCases();
        if(cases == 2){
            Chargewebservice chargeAddressTask = new Chargewebservice(textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18);
//                启动后台任务
            chargeAddressTask.execute();

        }

    }
}
