package Subtrans.slidingmenu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;


public class SlidingMenu extends HorizontalScrollView {

    private LinearLayout mWapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;
    private int mScreenWidth;
    private int mMenuWidth;
    private int mMenuHeight;
    private int mMenuRightPadding = 50;
    private boolean once;
    private boolean isOpen;

    private float pulldownY;
    private float lastdownY;
   /*
   * 未使用自定义属性时*/

    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);

       WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        mScreenWidth = outMetrics.widthPixels;

        mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,context.getResources().getDisplayMetrics());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if(!once){
            mWapper = (LinearLayout) getChildAt(0);
            mMenu = (ViewGroup) mWapper.getChildAt(0);
            mContent = (ViewGroup) mWapper.getChildAt(1);
            mMenuWidth =  mMenu.getLayoutParams().width = mScreenWidth*3/4;
            mMenuHeight = mMenu.getLayoutParams().height;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    /*
    * 通过设置偏移量，将menu隐藏*/
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
       if(changed){
           this.scrollTo(mMenuWidth,0);
       }

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch(ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                pulldownY=ev.getX();
                lastdownY=pulldownY;
                break;
            case MotionEvent.ACTION_MOVE:
                pulldownY=ev.getX();
                int scrollX = (int) Math.abs(pulldownY-lastdownY);
                if(scrollX>mMenuWidth/4){
                     return   true;
                } else return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (scrollX >= mMenuWidth / 2) {
                    isOpen = false;
                    this.smoothScrollTo(mMenuWidth, 0);
                } else {
                    isOpen = true;
                    this.smoothScrollTo(0, 0);
                }
               return true;
        }
        return super.onTouchEvent(ev);
    }
    public void openMenu(){
        if (isOpen)return;
        this.smoothScrollTo(0,0);
        isOpen = true;
    }
    public void closeMenu(){
        if (!isOpen)return;
        this.smoothScrollTo(mMenuWidth,0);
        isOpen = false;
    }
    public void toggle(){
        if(isOpen){
            closeMenu();
        }else {
            openMenu();
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        float scale = l*1.0f/mMenuWidth;
        ViewHelper.setTranslationX(mMenu,mMenuWidth*scale);

    }
}
