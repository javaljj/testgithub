package com.javalj.androidapp4demo.main.customwidgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.javalj.androidapp4demo.utils.Log;


public class LTCustomViewPager extends ViewPager {
    // consts
    private static final String TAG = LTCustomViewPager.class.getSimpleName();

    private GestureDetector mGestureDetector;
    OnTouchListener mGestureListener;

    public int WIDTH;
    public int HEIGHT;
    final int RIGHT = 0;
    final int LEFT = 1;
    private boolean isCanScroll = true;
    private Context mContext;
    private int previousItem = -1;

    public LTCustomViewPager(Context context) {
        super(context);
        mContext = context;
        // mGestureDetector = new GestureDetector(new XYScrollDetector());
        mGestureDetector = new GestureDetector(mContext, new XYScrollDetector());
    }

    public LTCustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        // mGestureDetector = new GestureDetector(new XYScrollDetector());
        mGestureDetector = new GestureDetector(mContext, new XYScrollDetector());
    }


    @Override
    public void setCurrentItem(int item) {
        if (item != previousItem && previousItem != -1) {
            Log.d(TAG, "leave page: " + previousItem + ", enter page: " + item);
        }

        super.setCurrentItem(item);

        previousItem = item;
    }

    /**
     * 获取屏幕长宽
     */
    public void getWidthAndHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        WIDTH = dm.widthPixels;
        HEIGHT = dm.heightPixels;
    }

    public void setScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isCanScroll == false) {
            //   return mGestureDetector.onTouchEvent(ev);
            return false;
        } else {
            return super.onInterceptTouchEvent(ev);
        }
    }

    class XYScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            // TODO Auto-generated method stub
            float x = e2.getX() - e1.getX();
            float y = e2.getY() - e1.getY();
            // 限制必须得划过屏幕的1/2才能算划过
            float x_limit = 150;
            float x_abs = Math.abs(x);
            float y_abs = Math.abs(y);
            if (x_abs >= y_abs) {
                // gesture left or right
                if (x_abs > x_limit || x_abs < -x_limit) {
                    if (x > 0) {
                        // right
                        // MainActivity.doResult(RIGHT);
                    } else if (x <= 0) {
                        // left
                        // MainActivity.doResult(LEFT);
                    }
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }
    }

}
