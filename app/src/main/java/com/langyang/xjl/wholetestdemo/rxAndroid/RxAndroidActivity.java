package com.langyang.xjl.wholetestdemo.rxAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.langyang.xjl.wholetestdemo.R;
import com.langyang.xjl.wholetestdemo.rxAndroid.asyncTask.ActivityRxAsyncTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxAndroidActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button_from)
    Button buttonFrom;
    @BindView(R.id.button_interval)
    Button buttonInterval;
    @BindView(R.id.button_just)
    Button buttonJust;
    @BindView(R.id.button_range)
    Button buttonRange;
    @BindView(R.id.button_filter)
    Button buttonFilter;
    @BindView(R.id.button_AsyncTask)
    Button buttonAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_android);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button2, R.id.button_from, R.id.button_interval, R.id.button_just, R.id.button_range,
            R.id.button_filter,R.id.button_AsyncTask})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                RxUtils.createObserable();
                break;
            case R.id.button2:
                RxUtils.creatPrint();
                break;
            case R.id.button_from:
                RxUtils.from();
                break;
            case R.id.button_interval:
                RxUtils.interval();
                break;
            case R.id.button_just:
                RxUtils.just();
                break;
            case R.id.button_range:
                RxUtils.range();
                break;
            case R.id.button_filter:
                RxUtils.filter();
                break;
            case R.id.button_AsyncTask:
                startActivity(new Intent(RxAndroidActivity.this, ActivityRxAsyncTask.class));
                break;
        }

    }
}
