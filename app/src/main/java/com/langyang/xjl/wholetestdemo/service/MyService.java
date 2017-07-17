package com.langyang.xjl.wholetestdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private int count = 0;
    private boolean threadDisable=false;

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!threadDisable) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    Log.v("CountService", "Count is " + count);

                    //发送广播
                    Intent intent=new Intent();
                    intent.putExtra("count", count);
                    intent.setAction("com.langyang.xjl.wholetestdemo.service.MyService");
                    sendBroadcast(intent);
                }
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
