package com.langyang.xjl.wholetestdemo.rxJava;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : xjl
 * @Created : 2016-12-13
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
public class CreatWached implements Watched{

    private List<Watcher> list=new ArrayList<Watcher>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void RemoveWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWachers(String str) {
        for (Watcher watcher:list){
            watcher.update(str);
        }
    }
}
