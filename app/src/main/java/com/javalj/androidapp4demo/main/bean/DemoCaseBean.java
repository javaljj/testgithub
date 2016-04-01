package com.javalj.androidapp4demo.main.bean;

import com.javalj.androidapp4demo.main.base.Basebean;

/**
 * Created by lijie on 2016/2/18.
 */
public class DemoCaseBean extends Basebean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoCaseBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
