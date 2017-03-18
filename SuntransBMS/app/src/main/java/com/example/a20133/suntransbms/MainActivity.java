package com.example.a20133.suntransbms;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Subtrans.slidingmenu.view.SlidingMenu;



public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private  LinearLayout mTabforecast;
    private  LinearLayout mTabcharge;
    private  LinearLayout mTabdischarge;
    private  LinearLayout mTabsetting;

    private ImageButton mImgforecast;
    private ImageButton mImgcharge;
    private ImageButton mImgdischarge;
    private ImageButton mImgsetting;

    private TextView mTvforecast;
    private TextView mTvcharge;
    private TextView mTvdischarge;
    private TextView mTvsetting;

    public Fragment mFgforecast;
    public Fragment mFgcharge;
    public Fragment mFgdischarge;
    public Fragment mFgsetting;

    /*
    * 以下是侧滑菜单定义属性*/
    private SlidingMenu mLeftMenu;

    private Button btn_show;
    private Context mContext;

    /*webservice*/
    private ImageButton queryButton;

    private TextView resultView11;
    private TextView resultView12;
    private TextView resultView13;
    private TextView resultView14;
    private TextView resultView15;
    private TextView resultView16;
    private TextView resultView17;
    private TextView resultView18;
    private TextView resultView19;
    private TextView resultView10;
    private TextView resultView21;
    private TextView resultView22;
    private TextView resultView23;
    private TextView resultView24;
    private TextView resultView25;
    private TextView resultView26;
    private TextView resultView27;
    private TextView resultView28;
    private TextView resultView29;
    private TextView resultView20;
    private TextView resultView31;
    private TextView resultView32;
    private TextView resultView33;
    private TextView resultView34;
    private TextView resultView35;
    private TextView resultView36;
    private TextView resultView37;
    private TextView resultView38;
    private TextView resultView39;
    private TextView resultView30;
    private TextView resultView41;
    private TextView resultView42;
    private TextView resultView43;
    private TextView resultView44;
    private TextView resultView45;
    private TextView resultView46;
    private TextView resultView47;
    private TextView resultView48;
    private TextView resultView49;
    private TextView resultView40;

    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;
    private TextView textView18;

    private TextView dischargetestview11;

    private TextView settingtestview11;
    private TextView settingtestview12;
    private TextView settingtestview13;

    ArrayList<String> list5 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((GlobalData)getApplication()).setCases(0);
        ((GlobalData)getApplication()).setCases2(1);
        initView();

        initEvent();

        setSelect(0);
//        mContext = MainActivity.this;
//        btn_show = (Button) findViewById(R.id.id_mTvtopBtn);
//       btn_show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                initPopWindow(v);
//            }
//        });
//        mLeftMenu = (SlidingMenu) findViewById(R.id.id_menu);

    }

    @Override
    protected void onStart() {
        super.onStart();
        resultView11 =(TextView)findViewById(R.id.id_forcast_TV11);
        resultView12 =(TextView)findViewById(R.id.id_forcast_TV12);
        resultView13 =(TextView)findViewById(R.id.id_forcast_TV13);
        resultView14 =(TextView)findViewById(R.id.id_forcast_TV14);
        resultView15 =(TextView)findViewById(R.id.id_forcast_TV15);
        resultView16 =(TextView)findViewById(R.id.id_forcast_TV16);
        resultView17 =(TextView)findViewById(R.id.id_forcast_TV17);
        resultView21 =(TextView)findViewById(R.id.id_forcast_TV21);
        resultView22 =(TextView)findViewById(R.id.id_forcast_TV22);
        resultView23 =(TextView)findViewById(R.id.id_forcast_TV23);
        resultView24 =(TextView)findViewById(R.id.id_forcast_TV24);
        resultView25 =(TextView)findViewById(R.id.id_forcast_TV25);
        resultView26 =(TextView)findViewById(R.id.id_forcast_TV26);
        resultView27 =(TextView)findViewById(R.id.id_forcast_TV27);
        resultView31 =(TextView)findViewById(R.id.id_forcast_TV31);
        resultView32 =(TextView)findViewById(R.id.id_forcast_TV32);
        resultView33 =(TextView)findViewById(R.id.id_forcast_TV33);
        resultView34 =(TextView)findViewById(R.id.id_forcast_TV34);
        resultView35 =(TextView)findViewById(R.id.id_forcast_TV35);
        resultView36 =(TextView)findViewById(R.id.id_forcast_TV36);
        resultView37 =(TextView)findViewById(R.id.id_forcast_TV37);
        resultView41 =(TextView)findViewById(R.id.id_forcast_TV41);
        resultView42 =(TextView)findViewById(R.id.id_forcast_TV42);
        resultView43 =(TextView)findViewById(R.id.id_forcast_TV43);
        resultView44 =(TextView)findViewById(R.id.id_forcast_TV44);
        resultView45 =(TextView)findViewById(R.id.id_forcast_TV45);
        resultView46 =(TextView)findViewById(R.id.id_forcast_TV46);
        resultView47 =(TextView)findViewById(R.id.id_forcast_TV47);

        textView11 =(TextView)findViewById(R.id.id_charge_check_TV11);
        textView12 =(TextView)findViewById(R.id.id_charge_check_TV12);
        textView13 =(TextView)findViewById(R.id.id_charge_check_TV13);
        textView14 =(TextView)findViewById(R.id.id_charge_check_TV14);
        textView15 =(TextView)findViewById(R.id.id_charge_check_TV15);
        textView16 =(TextView)findViewById(R.id.id_charge_check_TV16);
        textView17 =(TextView)findViewById(R.id.id_charge_check_TV17);
        textView18 =(TextView)findViewById(R.id.id_charge_check_TV18);

        resultView18=(TextView)findViewById(R.id.id_charge_TV11);
        resultView19=(TextView)findViewById(R.id.id_charge_TV12);
        resultView10=(TextView)findViewById(R.id.id_charge_TV13);

        resultView28=(TextView)findViewById(R.id.id_charge_TV21);
        resultView29=(TextView)findViewById(R.id.id_charge_TV22);
        resultView20=(TextView)findViewById(R.id.id_charge_TV23);

        resultView38=(TextView)findViewById(R.id.id_charge_TV31);
        resultView39=(TextView)findViewById(R.id.id_charge_TV32);
        resultView30=(TextView)findViewById(R.id.id_charge_TV33);

        resultView48=(TextView)findViewById(R.id.id_charge_TV41);
        resultView49=(TextView)findViewById(R.id.id_charge_TV42);
        resultView40=(TextView)findViewById(R.id.id_charge_TV43);

        dischargetestview11 =(TextView)findViewById(R.id.id_discharge_parameter_TV11);

        settingtestview11 = (TextView)findViewById(R.id.id_setting_TV11);
        settingtestview12 = (TextView)findViewById(R.id.id_setting_TV12);
        settingtestview13 = (TextView)findViewById(R.id.id_setting_TV13);

    }

    private void initEvent() {

        mTabforecast.setOnClickListener(this);
        mTabcharge.setOnClickListener(this);
        mTabdischarge.setOnClickListener(this);
        mTabsetting.setOnClickListener(this);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindow(v);
            }
        });

       queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cases2 = ((GlobalData)getApplication()).getCases2();
                if(cases2 == 1){
                    Forcastwebservice1 forecastAddressTask1 = new Forcastwebservice1(resultView11, resultView12, resultView13, resultView14, resultView15, resultView16, resultView17,resultView18,resultView19,resultView10,
                            resultView21, resultView22, resultView23, resultView24, resultView25, resultView26, resultView27, resultView28, resultView29, resultView20,
                            resultView31, resultView32, resultView33, resultView34, resultView35, resultView36, resultView37,resultView38,resultView39,resultView30,
                            resultView41, resultView42, resultView43, resultView44, resultView45, resultView46, resultView47, resultView48, resultView49, resultView40);
                    forecastAddressTask1.execute();

                    Chargewebservice1 chargeAddressTask1 = new Chargewebservice1(textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18);
                    chargeAddressTask1.execute();
                }else if(cases2 == 2){
                    Forcastwebservice2 forecastAddressTask2 = new Forcastwebservice2(resultView11, resultView12, resultView13, resultView14, resultView15, resultView16, resultView17,resultView18,resultView19,resultView10,
                            resultView21, resultView22, resultView23, resultView24, resultView25, resultView26, resultView27, resultView28, resultView29, resultView20,
                            resultView31, resultView32, resultView33, resultView34, resultView35, resultView36, resultView37,resultView38,resultView39,resultView30,
                            resultView41, resultView42, resultView43, resultView44, resultView45, resultView46, resultView47, resultView48, resultView49, resultView40);
                    forecastAddressTask2.execute();

                    Chargewebservice2 chargeAddressTask2 = new Chargewebservice2(textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18);
                    chargeAddressTask2.execute();

                }


                   // Dischargewebservice dischargeAddressTask = new Dischargewebservice(dischargetestview11);
                   // dischargeAddressTask.execute();

                    settingtestview11.setText("100");
                    settingtestview12.setText("12");
                    settingtestview13.setText("10.8");
               // }

            }
        });

    }

    private void initView() {

        mTabforecast = (LinearLayout) findViewById(R.id.id_mTabforecast);
        mTabcharge = (LinearLayout) findViewById(R.id.id_mTabcharge);
        mTabdischarge = (LinearLayout) findViewById(R.id.id_mTabdischarge);
        mTabsetting = (LinearLayout) findViewById(R.id.id_mTabsetting);

        mImgforecast = (ImageButton) findViewById(R.id.id_mImgforecast);
        mImgcharge = (ImageButton) findViewById(R.id.id_mImgcharge);
        mImgdischarge = (ImageButton) findViewById(R.id.id_mImgdischarge);
        mImgsetting = (ImageButton) findViewById(R.id.id_mImgsetting);

        mTvforecast = (TextView)findViewById(R.id.id_mTvforcast);
        mTvcharge = (TextView)findViewById(R.id.id_mTvcharge);
        mTvdischarge = (TextView)findViewById(R.id.id_mTvdischarge);
        mTvsetting = (TextView)findViewById(R.id.id_mTvsetting);

        mContext = MainActivity.this;
        btn_show = (Button) findViewById(R.id.id_mTvtopBtn);
        mLeftMenu = (SlidingMenu) findViewById(R.id.id_menu);
        queryButton = (ImageButton)findViewById(R.id.query_btn);

        mFgforecast = new ForecastFragment();
        mFgcharge = new ChargeFragment();
        mFgdischarge = new DischargeFragment();
        mFgsetting = new SettingFragment();
        list5 = ((GlobalData)getApplication()).getList1();
    }


    private void setSelect(int i){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if(((GlobalData)getApplication()).getCases()==0){
            transaction.add(R.id.id_Flcontent,mFgforecast);
            transaction.add(R.id.id_Flcontent,mFgcharge);
            transaction.add(R.id.id_Flcontent,mFgdischarge);
            transaction.add(R.id.id_Flcontent,mFgsetting);
        }
        ((GlobalData)getApplication()).setCases(1);
        hideFragment(transaction);

        switch (i) {
            case 0:
                   transaction.show(mFgforecast);
                mImgforecast.setImageResource(R.drawable.eyegreen);
                mTvforecast.setTextColor(0xff11c8a7);
                ((GlobalData)getApplication()).setCases(1);
                break;
            case 1:
                    transaction.show(mFgcharge);
                mImgcharge.setImageResource(R.drawable.charge);
                mTvcharge.setTextColor(0xff11c8a7);
                ((GlobalData)getApplication()).setCases(1);
                break;
            case 2:
                    transaction.show(mFgdischarge);
                mImgdischarge.setImageResource(R.drawable.discharge);
                mTvdischarge.setTextColor(0xff11c8a7);
                ((GlobalData)getApplication()).setCases(1);
                break;
            case 3:
                    transaction.show(mFgsetting);
                mImgsetting.setImageResource(R.drawable.settinggreen);
                mTvsetting.setTextColor(0xff11c8a7);
                ((GlobalData)getApplication()).setCases(1);
                break;


        }
        transaction.commit();


    }

    private void hideFragment(FragmentTransaction transaction) {

        if(mFgforecast!=null){
            transaction.hide(mFgforecast);
        }
        if(mFgcharge!=null){
            transaction.hide(mFgcharge);
        }
        if(mFgdischarge!=null){
            transaction.hide(mFgdischarge);
        }
        if(mFgsetting!=null){
            transaction.hide(mFgsetting);
        }
    }


    @Override
    public void onClick(View v) {

        resetAllTab();

        switch (v.getId()){

            case R.id.id_mTabforecast:
                setSelect(0);

              break;
            case R.id.id_mTabcharge:
                setSelect(1);

              break;
            case R.id.id_mTabdischarge:
                setSelect(2);

               break;
            case R.id.id_mTabsetting:
                setSelect(3);

              break;

        }

    }

    private void resetAllTab() {

        mImgforecast.setImageResource(R.drawable.eyegray);
        mImgcharge.setImageResource(R.drawable.chargegray);
        mImgdischarge.setImageResource(R.drawable.dischargegray);
        mImgsetting.setImageResource(R.drawable.settinggray);


        mTvforecast.setTextColor(0xff646565);
        mTvcharge.setTextColor(0xff646565);
        mTvdischarge.setTextColor(0xff646565);
        mTvsetting.setTextColor(0xff646565);
    }
    public void toggleMenu(View view){

        mLeftMenu.toggle();
    }
    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    private void initPopWindow(View v) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_popup, null, false);
        Button btn_xixi = (Button) view.findViewById(R.id.btn_xixi);
        Button btn_hehe = (Button) view.findViewById(R.id.btn_hehe);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        final PopupWindow popWindow = new PopupWindow(view,
                560, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popWindow.setAnimationStyle(R.anim.anim_pop);  //设置加载动画

        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popWindow.setTouchable(true);
        popWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindow.setBackgroundDrawable(new ColorDrawable(0x00999999));    //要为popWindow设置一个背景才有效


        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量

        int xx = v.getWidth()/2-popWindow.getWidth()/2;
        popWindow.showAsDropDown(v, xx, 0);
        //设置popupWindow里的按钮的事件
        btn_xixi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_show.setText("武汉大学体育馆基站");
                Toast.makeText(MainActivity.this, "你点击了嘻嘻~", Toast.LENGTH_SHORT).show();
                ((GlobalData)getApplication()).setCases2(1);
                popWindow.dismiss();
            }
        });
        btn_hehe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_show.setText("武汉大学图书馆基站");
                Toast.makeText(MainActivity.this, "你点击了呵呵~", Toast.LENGTH_SHORT).show();
                ((GlobalData)getApplication()).setCases2(2);
                popWindow.dismiss();
            }
        });
    }
}
