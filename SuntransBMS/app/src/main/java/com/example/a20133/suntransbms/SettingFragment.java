package com.example.a20133.suntransbms;

import android.os.Bundle;
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

public class SettingFragment extends Fragment {

//   private ImageButton queryButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.setting,container,false);
//        queryButton = (ImageButton) getActivity().findViewById(R.id.query_btn);
        ((PullToRefreshLayout) view.findViewById(R.id.id_setting_fragment))
                .setOnRefreshListener(new MyListener());
//        queryButton.performClick();
        return view;
    }
}
