package com.langyang.xjl.wholetestdemo.eventBus;

/**
 * @Author : xjl
 * @Created : 2016-12-16
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
//创建一个黏性事件类
public class StickyEvent {
    public String message;

    public StickyEvent(String message) {
        this.message = message;
    }
}
