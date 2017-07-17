package com.langyang.xjl.wholetestdemo.rxJava;

/**
 * @Author : xjl
 * @Created : 2016-12-13
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
public interface Watched {

    public void addWatcher(Watcher watcher);

    public void RemoveWatcher(Watcher watcher);

    public void notifyWachers(String str);
}
