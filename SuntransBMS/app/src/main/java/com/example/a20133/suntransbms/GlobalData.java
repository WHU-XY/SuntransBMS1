package com.example.a20133.suntransbms;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by 20133 on 2017/3/16.
 */

public class GlobalData extends Application {
    private int cases;
    private int cases2;

    ArrayList<String> list1 = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        setCases(cases);
        setCases2(cases2);
        setList1(list1);
    }

    public int getCases(){
        return cases;
    }
    public void setCases(int cases){
        this.cases = cases;
    }
    public int getCases2(){
        return cases2;
    }
    public void setCases2(int cases2){
        this.cases2 = cases2;
    }
    public void setList1(ArrayList<String> list1) {
        this.list1 = list1;
    }

    public ArrayList<String> getList1() {
        return list1;
    }


}
