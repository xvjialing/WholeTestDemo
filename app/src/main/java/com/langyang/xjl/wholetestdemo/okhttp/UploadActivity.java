package com.langyang.xjl.wholetestdemo.okhttp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.langyang.xjl.wholetestdemo.R;
import com.langyang.xjl.wholetestdemo.utils.UnicodeDecode;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UploadActivity extends AppCompatActivity {

    private static final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/jpg");
    private static final String url_uploadAvater= "http://121.196.194.14/langyang/Home/User/uploadAvater";
    private static final String TAG= UploadActivity.class.getSimpleName();
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        new Thread(new Runnable() {
            @Override
            public void run() {
                okHttpClient = new OkHttpClient();
                MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                File f=new File(Environment.getExternalStorageDirectory(),"temp_crop.jpg");
                if (f!=null){
                    builder.addFormDataPart("id","1");
                    builder.addFormDataPart("avater",f.getName(), RequestBody.create(MEDIA_TYPE_JPG,f));
                }
                MultipartBody requestBody = builder.build();
                Request request=new Request.Builder()
                        .url(url_uploadAvater)
                        .post(requestBody)
                        .build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG,e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String code= UnicodeDecode.decode(response.body().string());
                        Log.i(TAG,code);
                        Log.d(TAG,"上传成功");
                    }
                });
            }
        }).start();
    }
}
