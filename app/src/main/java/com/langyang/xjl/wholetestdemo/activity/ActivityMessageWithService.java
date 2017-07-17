package com.langyang.xjl.wholetestdemo.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

import com.langyang.xjl.wholetestdemo.R;
import com.langyang.xjl.wholetestdemo.service.MyService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMessageWithService extends AppCompatActivity {


    private MyReceiver receiver=null;
    private int count;

    @BindView(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_message_with_service);
        ButterKnife.bind(this);

        //启动服务
        startService(new Intent(ActivityMessageWithService.this, MyService.class));

        //注册广播接收器
        receiver=new MyReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.langyang.xjl.wholetestdemo.service.MyService");
        ActivityMessageWithService.this.registerReceiver(receiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束服务
        stopService(new Intent(ActivityMessageWithService.this, MyService.class));
    }

    /**
     * 获取广播数据
     *
     */
    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle=intent.getExtras();
            count=bundle.getInt("count");
//            tvTest.setText(count);
            Log.d("----count--------", String.valueOf(count));
            tvTest.setText(String.valueOf(count));

        }
    }
}
