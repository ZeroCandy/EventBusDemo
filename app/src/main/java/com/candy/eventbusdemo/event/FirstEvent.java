package com.candy.eventbusdemo.event;

/**
 * Created by 帅阳 on 2015/5/26.
 */
public class FirstEvent {
    private String msg;

    public FirstEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
