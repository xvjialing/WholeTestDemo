package com.langyang.xjl.wholetestdemo.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.langyang.xjl.wholetestdemo.Mqtt.ActivityMqtt;
import com.langyang.xjl.wholetestdemo.R;
import com.langyang.xjl.wholetestdemo.eventBus.ActivityEventBus;
import com.langyang.xjl.wholetestdemo.greenDao.ActivityGreenDao;
import com.langyang.xjl.wholetestdemo.json.ActivityFastJson;
import com.langyang.xjl.wholetestdemo.okhttp.ActivityOkhttp;
import com.langyang.xjl.wholetestdemo.rxAndroid.RxAndroidActivity;

import java.util.ArrayList;
import java.util.List;

public class OtherFragment extends Fragment implements MyAdapter.ChildClickListener {
    private RecyclerView recyclerView;
    private List<String> list;
    private String[] itemList;
    private MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_other, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        list=new ArrayList<>();
        itemList=new String[]{"MQTT","ServiceSendToActivity"};
        for (String item:itemList) {
            list.add(item);
        }
        myAdapter = new MyAdapter(getContext(),list);
        myAdapter.setOnChildClickListener(this);
        recyclerView.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void itemClick(RecyclerView parent, View view, int position, String data) {
        switch (data){
            case "MQTT":
                startActivity(new Intent(getContext(), ActivityMqtt.class));
                break;
            case "ServiceSendToActivity":
                startActivity(new Intent(getContext(), ActivityMessageWithService.class));
                break;
        }
    }
}
