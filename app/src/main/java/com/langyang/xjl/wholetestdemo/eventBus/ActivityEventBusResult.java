package com.langyang.xjl.wholetestdemo.eventBus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.langyang.xjl.wholetestdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityEventBusResult extends AppCompatActivity {

    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.textView4)
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_result);
        ButterKnife.bind(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void stickyEventBus(StickyEvent stickyEvent){
        textView4.setText(stickyEvent.message);
    }

    @OnClick({R.id.button6, R.id.button7})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button6:
                EventBus.getDefault().post(new MessageEvent("发送主线程数据！"));
                finish();
                break;
            case R.id.button7:
                EventBus.getDefault().register(ActivityEventBusResult.this);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(ActivityEventBusResult.this);
    }
}
