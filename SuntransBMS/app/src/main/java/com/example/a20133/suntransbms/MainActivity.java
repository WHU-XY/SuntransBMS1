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

    private Fragment mFgforecast;
    private Fragment mFgcharge;
    private Fragment mFgdischarge;
    private Fragment mFgsetting;

    /*
    * 以下是侧滑菜单定义属性*/
    private SlidingMenu mLeftMenu;

    private Button btn_show;
    private Context mContext;
    private ImageButton queryButton;
//    /*webservice*/
//    /*private ImageButton queryButton;

//    private TextView resultView11;
//    private TextView resultView12;
//    private TextView resultView13;
//    private TextView resultView14;
//    private TextView resultView15;
//    private TextView resultView16;
//    private TextView resultView17;
//    private TextView resultView21;
//    private TextView resultView22;
//    private TextView resultView23;
//    private TextView resultView24;
//    private TextView resultView25;
//    private TextView resultView26;
//    private TextView resultView27;
//    private TextView resultView31;
//    private TextView resultView32;
//    private TextView resultView33;
//    private TextView resultView34;
//    private TextView resultView35;
//    private TextView resultView36;
//    private TextView resultView37;
//    private TextView resultView41;
//    private TextView resultView42;
//    private TextView resultView43;
//    private TextView resultView44;
//    private TextView resultView45;
//    private TextView resultView46;
//    private TextView resultView47;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((GlobalData)getApplication()).setCases(1);
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
//        /*queryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                启动后台异步线程进行连接webService操作，并且根据返回结果在主线程中改变UI
//                Forcastwebservice queryAddressTask = new Forcastwebservice(resultView11, resultView12, resultView13, resultView14, resultView15, resultView16, resultView17,
//                        resultView21, resultView22, resultView23, resultView24, resultView25, resultView26, resultView27,
//                        resultView31, resultView32, resultView33, resultView34, resultView35, resultView36, resultView37,
//                        resultView41, resultView42, resultView43, resultView44, resultView45, resultView46, resultView47);
//               启动后台任务
//                queryAddressTask.execute();
//            }
//        });*/

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
//       /* queryButton = (ImageButton)findViewById(R.id.query_btn);
//
//        resultView11 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV11);
//        resultView12 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV12);
//        resultView13 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV13);
//        resultView14 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV14);
//        resultView15 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV15);
//        resultView16 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV16);
//        resultView17 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV17);
//        resultView21 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV21);
//        resultView22 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV22);
//        resultView23 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV23);
//        resultView24 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV24);
//        resultView25 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV25);
//        resultView26 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV26);
//        resultView27 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV27);
//        resultView31 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV31);
//        resultView32 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV32);
//        resultView33 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV33);
//        resultView34 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV34);
//        resultView35 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV35);
//        resultView36 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV36);
//        resultView37 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV37);
//        resultView41 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV41);
//        resultView42 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV42);
//        resultView43 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV43);
//        resultView44 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV44);
//        resultView45 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV45);
//        resultView46 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV46);
//        resultView47 = (TextView) getFragmentManager().findFragmentById(R.id.id_Flcontent).getView().findViewById(R.id.id_forcast_TV47);*/








    }


    private void setSelect(int i){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        hideFragment(transaction);

        switch (i) {

            case 0:
                //if(mFgforecast==null){
                    mFgforecast = new ForecastFragment();
                    transaction.add(R.id.id_Flcontent,mFgforecast);
              //  }else {
                   transaction.show(mFgforecast);
             //   }
                mImgforecast.setImageResource(R.drawable.eyegreen);
                mTvforecast.setTextColor(0xff11c8a7);
                ((GlobalData)getApplication()).setCases(1);
                break;
            case 1:
              // if(mFgcharge==null){
                    mFgcharge = new ChargeFragment();
                    transaction.add(R.id.id_Flcontent,mFgcharge);
               // }else {
                    transaction.show(mFgcharge);
               // }
                mImgcharge.setImageResource(R.drawable.charge);
                mTvcharge.setTextColor(0xff11c8a7);
                ((GlobalData)getApplication()).setCases(2);
                break;
            case 2:
                //if(mFgdischarge==null){
                    mFgdischarge = new DischargeFragment();
                    transaction.add(R.id.id_Flcontent,mFgdischarge);
                //}else {
                    transaction.show(mFgdischarge);
                //}
                mImgdischarge.setImageResource(R.drawable.discharge);
                mTvdischarge.setTextColor(0xff11c8a7);
                ((GlobalData)getApplication()).setCases(3);
                break;
            case 3:
                //if(mFgsetting==null){
                    mFgsetting = new SettingFragment();
                    transaction.add(R.id.id_Flcontent,mFgsetting);
                //}else {
                    transaction.show(mFgsetting);
                //}
                mImgsetting.setImageResource(R.drawable.settinggreen);
                mTvsetting.setTextColor(0xff11c8a7);
                ((GlobalData)getApplication()).setCases(4);
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
                ((GlobalData)getApplication()).setCases(1);
              break;
            case R.id.id_mTabcharge:
                setSelect(1);
                ((GlobalData)getApplication()).setCases(2);
              break;
            case R.id.id_mTabdischarge:
                setSelect(2);
                ((GlobalData)getApplication()).setCases(3);
               break;
            case R.id.id_mTabsetting:
                setSelect(3);
                ((GlobalData)getApplication()).setCases(4);
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
                popWindow.dismiss();
            }
        });
        btn_hehe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_show.setText("武汉大学图书馆基站");
                Toast.makeText(MainActivity.this, "你点击了呵呵~", Toast.LENGTH_SHORT).show();
                popWindow.dismiss();
            }
        });
    }
}
