package com.example.a20133.suntrans1xy;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<View> mView = new ArrayList<View>();

    private LinearLayout mTabyuche;
    private LinearLayout mTabCD;
    private LinearLayout mTabFD;
    private LinearLayout mTabSetting;

    private ImageButton myucheimg;
    private ImageButton mCDimg;
    private ImageButton mFDimg;
    private ImageButton mSettingimg;

    private TextView myuchetv;
    private TextView mcdtv;
    private TextView mfdtv;
    private TextView msettingtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    private void initEvent() {

        mTabyuche.setOnClickListener(this);
        mTabCD.setOnClickListener(this);
        mTabFD.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                int currentItem = mViewPager.getCurrentItem();
                ressetlinearl();
                switch(currentItem){
                    case 0:
                        myucheimg.setImageResource(R.drawable.whuxy6);
                        myuchetv.setTextColor(0xff11c8a7);
                        break;
                    case 1:
                        mCDimg.setImageResource(R.drawable.whuxy6);
                        mcdtv.setTextColor(0xff11c8a7);
                        break;
                    case 2:
                        mFDimg.setImageResource(R.drawable.whuxy6);
                        mfdtv.setTextColor(0xff11c8a7);
                        break;
                    case 3:
                        mSettingimg.setImageResource(R.drawable.whuxy6);
                        msettingtv.setTextColor(0xff11c8a7);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabyuche = (LinearLayout)findViewById(R.id.btm_tab1);
        mTabCD = (LinearLayout)findViewById(R.id.btm_tab2);
        mTabFD = (LinearLayout)findViewById(R.id.btm_tab3);
        mTabSetting = (LinearLayout)findViewById(R.id.btm_tab4);

        myucheimg = (ImageButton) findViewById(R.id.myucheIB);
        mCDimg = (ImageButton) findViewById(R.id.mcdIB);
        mFDimg = (ImageButton) findViewById(R.id.mfdIB);
        mSettingimg = (ImageButton) findViewById(R.id.msettingIB);

        myuchetv = (TextView) findViewById(R.id.myucheTV);
        mcdtv = (TextView) findViewById(R.id.mcdTV);
        mfdtv = (TextView) findViewById(R.id.mfdTV);
        msettingtv = (TextView) findViewById(R.id.msettingTV);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.yuche,null);
        View tab02 = mInflater.inflate(R.layout.charge,null);
        View tab03 = mInflater.inflate(R.layout.release,null);
        View tab04 = mInflater.inflate(R.layout.setting,null);

        mView.add(tab01);
        mView.add(tab02);
        mView.add(tab03);
        mView.add(tab04);

        mAdapter = new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
               container.removeView(mView.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mView.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mView.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

        };

        mViewPager.setAdapter(mAdapter);




    }

    @Override
    public void onClick(View v) {

        ressetlinearl();

        switch (v.getId()){
            case R.id.btm_tab1:
                mViewPager.setCurrentItem(0);
                myucheimg.setImageResource(R.drawable.whuxy6);
                myuchetv.setTextColor(0xff11c8a7);
                break;
            case R.id.btm_tab2:
                mViewPager.setCurrentItem(1);
                mCDimg.setImageResource(R.drawable.whuxy6);
                mcdtv.setTextColor(0xff11c8a7);
                break;
            case R.id.btm_tab3:
                mViewPager.setCurrentItem(2);
                mFDimg.setImageResource(R.drawable.whuxy6);
                mfdtv.setTextColor(0xff11c8a7);
                break;
            case R.id.btm_tab4:
                mViewPager.setCurrentItem(3);
                mSettingimg.setImageResource(R.drawable.whuxy6);
                msettingtv.setTextColor(0xff11c8a7);
                break;
            default:
                break;
        }

    }

    private void ressetlinearl() {



        myucheimg.setImageResource(R.drawable.whu_xy1);
        mCDimg.setImageResource(R.drawable.whu_xy1);
        mFDimg.setImageResource(R.drawable.whu_xy1);
        mSettingimg.setImageResource(R.drawable.whu_xy1);


        myuchetv.setTextColor(0xff646565);
        mcdtv.setTextColor(0xff646565);
        mfdtv.setTextColor(0xff646565);
        msettingtv.setTextColor(0xff646565);
    }
}
