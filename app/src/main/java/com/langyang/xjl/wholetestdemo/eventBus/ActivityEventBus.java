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

public class ActivityEventBus extends AppCompatActivity {

    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.textView2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        EventBus.getDefault().register(ActivityEventBus.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(ActivityEventBus.this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(MessageEvent event){
        textView2.setText(event.message);
    }

    @OnClick({R.id.button4, R.id.button5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button4:
                startActivity(new Intent(ActivityEventBus.this,ActivityEventBusResult.class));
                break;
            case R.id.button5:
                EventBus.getDefault().postSticky(new StickyEvent("发送黏性数据"));
                startActivity(new Intent(ActivityEventBus.this,ActivityEventBusResult.class));
                break;
        }
    }
}
