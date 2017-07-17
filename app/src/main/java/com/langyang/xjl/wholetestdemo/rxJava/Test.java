package com.langyang.xjl.wholetestdemo.rxJava;

/**
 * @Author : xjl
 * @Created : 2016-12-13
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Watched xioaming=new CreatWached();

        Watcher watcher1=new CreatWatcher();
        Watcher watcher2=new CreatWatcher();
        Watcher watcher3=new CreatWatcher();
        Watcher watcher4=new CreatWatcher();

        xioaming.addWatcher(watcher1);
        xioaming.addWatcher(watcher2);
        xioaming.addWatcher(watcher3);
        xioaming.addWatcher(watcher4);

        xioaming.notifyWachers("bdajdbhiwdqowui");

    }
}
