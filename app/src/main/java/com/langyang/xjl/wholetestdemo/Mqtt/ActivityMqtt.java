package com.langyang.xjl.wholetestdemo.Mqtt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.langyang.xjl.wholetestdemo.R;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.concurrent.ScheduledExecutorService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityMqtt extends AppCompatActivity {

    private String host="tcp://120.27.33.73:61613";
    private String userName="admin";
    private String password="password";
    private String[] subscribeTopic={"test/subscribe"};
    private int[] subscribeQos={1};
    private String[] publishTopic={"test/publish"};
    private int[] publishQos={1};
    private String clientID="client1";
    private MqttClient mqttClient;
    private MqttConnectOptions options;
    private ScheduledExecutorService scheduler;

    @BindView(R.id.et_SubscribeTopic)
    EditText etSubscribeTopic;
    @BindView(R.id.btn_subscribe)
    Button btnSubscribe;
    @BindView(R.id.et_publishTopic)
    EditText etPublishTopic;
    @BindView(R.id.et_publishMessage)
    EditText etPublishMessage;
    @BindView(R.id.btn_publish)
    Button btnPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt);
        ButterKnife.bind(this);

    }




    @OnClick({R.id.btn_subscribe, R.id.btn_publish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_subscribe:

                break;
            case R.id.btn_publish:

                break;
        }
    }
}
