package com.javalj.androidapp4demo.main.bean;

import java.io.Serializable;

/**
 * Created by lijie on 2016/2/18.
 */
public class MkBean implements Serializable {

    private String xxxx;
    private String oooo;
    private int type;

    public MkBean(String xxxx, String oooo, int type) {
        this.xxxx = xxxx;
        this.oooo = oooo;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getXxxx() {
        return xxxx;
    }

    public void setXxxx(String xxxx) {
        this.xxxx = xxxx;
    }

    public String getOooo() {
        return oooo;
    }

    public void setOooo(String oooo) {
        this.oooo = oooo;
    }
}
