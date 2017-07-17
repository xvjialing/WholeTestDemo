package com.langyang.xjl.wholetestdemo.utils;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by xjl on 17-2-13.
 */

public class UpLoadsUtils {
    private static final String TAG=RequestUtils.class.getSimpleName();
    private OkHttpClient client;

    public UpLoadsUtils() {
        client=new OkHttpClient();
    }

    public Observable<String> upLoads(Map<String, String> params, String url, MediaType mediaType, String filePanth){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });
    }
}
