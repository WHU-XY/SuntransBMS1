package com.example.a20133.suntransbms;

import android.app.Application;

/**
 * Created by 20133 on 2017/3/16.
 */

public class GlobalData extends Application {
    private int cases;

    @Override
    public void onCreate() {
        super.onCreate();
        setCases(cases);
    }

    public int getCases(){
        return cases;
    }
    public void setCases(int cases){
        this.cases = cases;
    }

}
