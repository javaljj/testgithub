package com.javalj.androidapp4demo.utils;

import com.javalj.androidapp4demo.MyApplication;
import com.javalj.androidapp4demo.R;

import java.util.ArrayList;

/**
 * Created by lijie on 2016/2/16.
 */
public class Utils {
    public static ArrayList<String> list = new ArrayList<>();

    static {
        String[] arrays = MyApplication.getInstance.getResources().getStringArray(R.array.democase);
        for (String array : arrays) {
            list.add(array);
        }
    }

    public static ArrayList<String> getArrayData() {
        return list;
    }
}
