package com.langyang.xjl.wholetestdemo.rxAndroid;

import android.content.Intent;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @Author : xjl
 * @Created : 2016-12-13
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
public class RxUtils {
    private static final String TAG = RxUtils.class.getSimpleName();


    /**
     * 使用create方式
     */
    public static void createObserable() {
        //定义被观察者，
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("hello");
                    subscriber.onNext("hi");
                    subscriber.onNext(downLoadJson());
                    subscriber.onNext("world");
                    subscriber.onCompleted();
                }
            }
        });

        Subscriber<String> showsub = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "result-->>" + s);
            }
        };
        observable.subscribe(showsub);//关联被观察者

    }

    /**
     * 调用下载方法
     *
     * @return
     */
    public static String downLoadJson() {
        return "json data";
    }

    /**
     * create 第二种方式
     */
    public static void creatPrint(){
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i=0;i<10;i++){
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG,integer.toString());
            }
        });
    }

    /***
     * 使用在被观察者，返回的对象一般都是数值类型
     */
    public static void from(){
        Integer[] items={1,2,3,4,5,6,7,8,9};

        Observable observable=Observable.from(items);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.d(TAG,o.toString());
            }
        });
    }

    /**
     * 指定某一时刻进行数据发送
     */
    public static void interval() {
        Integer[] items = {1, 2, 3, 4, 5};
        Observable observable = Observable.interval(1, 1, TimeUnit.SECONDS);//每一个发送数据
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG, o.toString());
            }
        });
    }

    /**
     * 处理数组集合
     */
    public static void just(){
        Integer[] items={1,2,3,4,5};
        Integer[] items2={6,7,8,9,10};

        Observable observable=Observable.just(items,items2);
        observable.subscribe(new Subscriber<Integer[]>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,e.getMessage());
            }

            @Override
            public void onNext(Integer[] integers) {
                for (Integer o:integers
                     ) {
                    Log.d(TAG,o+"");
                }
            }
        });
    }


    /**
     * 使用范围数据，指定输出数据的范围
     */
    public static void range(){
        Observable.range(1, 40)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG,"onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG,integer+"");
                    }
                });

    }

    /**
     * 使用过滤功能
     */
    public static void filter(){
        Observable observable=Observable.just(1,2,3,4,5,6,7,8,9,10);
        observable.filter(new Func1<Integer,Boolean>() {
            @Override
            public Boolean call(Integer o) {
                return o<5;
            }
        }).observeOn(Schedulers.io()).subscribe(new Subscriber() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,e.getMessage());
            }

            @Override
            public void onNext(Object o) {
                Log.d(TAG,o+"");
            }
        });
    }

}
