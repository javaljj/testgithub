package com.javalj.androidapp4demo.utils;

/**
 * Created by lijie on 2015/11/9.
 */
public class Log {
    public static final boolean enabled = true;

    public static final String LOG_TAG = "javalj/";

    public static void i(String tag, String msg) {
        if (enabled) {
            android.util.Log.i(LOG_TAG + tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (enabled) {
            android.util.Log.d(LOG_TAG + tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable e) {
        if (enabled) {
            android.util.Log.d(LOG_TAG + tag, msg, e);
        }
    }

    public static void e(String tag, String msg) {
        android.util.Log.e(LOG_TAG + tag, msg);
    }

    public static void e(String tag, String msg, Throwable e) {
        android.util.Log.e(LOG_TAG + tag, msg, e);
    }

    public static void v(String tag, String msg) {
        if (enabled) {
            android.util.Log.v(LOG_TAG + tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        android.util.Log.w(LOG_TAG + tag, msg);
    }

    public static void w(String tag, String msg, Throwable e) {
        android.util.Log.w(LOG_TAG + tag, msg, e);
    }
}
