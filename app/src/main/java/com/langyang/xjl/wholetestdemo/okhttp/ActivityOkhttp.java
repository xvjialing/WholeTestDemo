package com.langyang.xjl.wholetestdemo.okhttp;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.langyang.xjl.wholetestdemo.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ActivityOkhttp extends AppCompatActivity {

    private OkHttpClient client;
    private static final String TAG=ActivityOkhttp.class.getSimpleName();
//    private static final String downloadurl="http://192.168.31.139/app.apk";
//    private static final String downloadurl="http://192.168.0.104/app.apk";
    private static final String downloadurl="http://59.110.136.153/app.apk";

    public ActivityOkhttp() {
        client=new OkHttpClient();
    }

    private Handler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.fromFile(new File(Environment
                                        .getExternalStorageDirectory(), "app.apk")),
                                "application/vnd.android.package-archive");
                        startActivity(intent);
                        break;
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request=new Request.Builder()
                        .url(downloadurl)
                        .header("Accept-Encoding", "identity")
                        .build();
                Call call=client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
//                        System.out.println("failed"+e.getMessage());
                        Log.d(TAG,"filed"+e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        long total=response.body().contentLength();
                        Log.d(TAG,Long.toString(total));
                        long sum=0L;


                        InputStream is=response.body().byteStream();
                        int len=0;
                        File file= null;
                        try {
                            file = new File(Environment.getExternalStorageDirectory(),"app.apk");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        byte[] buffer=new byte[128];
                        FileOutputStream fos;
                        try {
                            fos = new FileOutputStream(file);
                        } finally {

                        }

                        while ((len=is.read(buffer))!=-1){
                            fos.write(buffer,0,len);
                            sum+=len;
                            Log.d(TAG,String.valueOf(sum/total));
                        }

                        try {
                            fos.flush();
                            fos.close();
                            is.close();
                        } finally {

                        }

                        Log.d(TAG,"succed");

                        Message message=new Message();
                        message.what=1;
                        handler.sendMessage(message);
                    }
                });
            }
        }).start();
    }
}
