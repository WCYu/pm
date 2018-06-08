package com.rxjy.pm.entity;

/**
 * Created by AAA on 2018/3/8.
 */

public class Pickers {
    private String showContent;
    private int id;

    public Pickers(String showContent, int id) {
        this.showContent = showContent;
        this.id = id;
    }

    public String getShowContent() {
        return showContent;
    }

    public void setShowContent(String showContent) {
        this.showContent = showContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
