package com.example.a20133.suntransbms;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.DisplayMetrics;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initEvent();

        setSelect(0);
        mContext = MainActivity.this;
        btn_show = (Button) findViewById(R.id.id_mTvtopBtn);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindow(v);
            }
        });
        mLeftMenu = (SlidingMenu) findViewById(R.id.id_menu);


    }

    private void initEvent() {

        mTabforecast.setOnClickListener(this);
        mTabcharge.setOnClickListener(this);
        mTabdischarge.setOnClickListener(this);
        mTabsetting.setOnClickListener(this);

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



    }


    private void setSelect(int i){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        hideFragment(transaction);

        switch (i) {

            case 0:
                if(mFgforecast==null){
                    mFgforecast = new ForecastFragment();
                    transaction.add(R.id.id_Flcontent,mFgforecast);
                }else {
                    transaction.show(mFgforecast);
                }
                mImgforecast.setImageResource(R.drawable.whuxy6);
                mTvforecast.setTextColor(0xff11c8a7);
                break;
            case 1:
               if(mFgcharge==null){
                    mFgcharge = new ChargeFragment();
                    transaction.add(R.id.id_Flcontent,mFgcharge);
                }else {
                    transaction.show(mFgcharge);
                }
                mImgcharge.setImageResource(R.drawable.whuxy6);
                mTvcharge.setTextColor(0xff11c8a7);
                break;
            case 2:
                if(mFgdischarge==null){
                    mFgdischarge = new DischargeFragment();
                    transaction.add(R.id.id_Flcontent,mFgdischarge);
                }else {
                    transaction.show(mFgdischarge);
                }
                mImgdischarge.setImageResource(R.drawable.whuxy6);
                mTvdischarge.setTextColor(0xff11c8a7);
                break;
            case 3:
                if(mFgsetting==null){
                    mFgsetting = new SettingFragment();
                    transaction.add(R.id.id_Flcontent,mFgsetting);
                }else {
                    transaction.show(mFgsetting);
                }
                mImgsetting.setImageResource(R.drawable.whuxy6);
                mTvsetting.setTextColor(0xff11c8a7);
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

        mImgforecast.setImageResource(R.drawable.whuxy1);
        mImgcharge.setImageResource(R.drawable.whuxy1);
        mImgdischarge.setImageResource(R.drawable.whuxy1);
        mImgsetting.setImageResource(R.drawable.whuxy1);


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
                480, ViewGroup.LayoutParams.WRAP_CONTENT, true);

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
        popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效


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
