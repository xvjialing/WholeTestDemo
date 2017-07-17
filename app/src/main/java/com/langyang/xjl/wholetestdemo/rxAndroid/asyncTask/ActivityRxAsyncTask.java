package com.langyang.xjl.wholetestdemo.rxAndroid.asyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.langyang.xjl.wholetestdemo.R;
import com.langyang.xjl.wholetestdemo.rxAndroid.RxUtils;
import com.langyang.xjl.wholetestdemo.rxAndroid.asyncTask.utlis.DownLoadUtils;
import com.langyang.xjl.wholetestdemo.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 在实际开发中activity充当的角色太多了
 * 1、UI主线程负责绘制UI
 * 2、开启子线程获取网络数据
 * 3、赋值到控件中
 * 4、逻辑判断等等
 * */
public class ActivityRxAsyncTask extends AppCompatActivity {

    private static final String TAG = RxUtils.class.getSimpleName();

    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.imageView)
    ImageView imageView;

    private String urlPath="http://192.168.1.105/phone.png";

    private DownLoadUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_async_task);
        ButterKnife.bind(this);

        utils=new DownLoadUtils();
    }

    @OnClick({R.id.button3})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button3:
                ToastUtils.showToast(ActivityRxAsyncTask.this,"下载图片");
                utils.downLoadImage(urlPath).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG,"onCompeleted");//一般用在对话框消失
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG,e.getMessage());
                    }

                    @Override
                    public void onNext(byte[] bytes) {
                        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                        imageView.setImageBitmap(bitmap);
                    }
                });
                break;
        }
    }
}
