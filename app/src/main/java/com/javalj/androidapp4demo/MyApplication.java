package com.javalj.androidapp4demo;

import android.app.Application;

/**
 * Created by lijie on 2016/2/16.
 */
public class MyApplication extends Application {

    public static MyApplication getInstance;

    @Override
    public void onCreate() {
        getInstance = this;
        super.onCreate();
    }


}
