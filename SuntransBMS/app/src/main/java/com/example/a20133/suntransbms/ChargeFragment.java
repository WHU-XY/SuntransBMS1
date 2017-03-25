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

public class ChargeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.charge,container,false);
        ((PullToRefreshLayout) view.findViewById(R.id.id_charge_fragment))
                .setOnRefreshListener(new MyListener());
        return view;
    }

}
