package com.langyang.xjl.wholetestdemo.rxJava;

/**
 * @Author : xjl
 * @Created : 2016-12-13
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
public class CreatWatcher implements Watcher{
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
