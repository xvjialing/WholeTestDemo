package com.langyang.xjl.wholetestdemo.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.langyang.xjl.wholetestdemo.R;
import com.langyang.xjl.wholetestdemo.eventBus.ActivityEventBus;
import com.langyang.xjl.wholetestdemo.greenDao.ActivityGreenDao;
import com.langyang.xjl.wholetestdemo.json.ActivityFastJson;
import com.langyang.xjl.wholetestdemo.okhttp.ActivityOkhttp;
import com.langyang.xjl.wholetestdemo.okhttp.UploadActivity;
import com.langyang.xjl.wholetestdemo.rxAndroid.RxAndroidActivity;

import java.util.ArrayList;
import java.util.List;

public class FrameworkFragment extends Fragment implements MyAdapter.ChildClickListener {


    private RecyclerView recyclerView;
    private List<String> list;
    private String[] itemList;
    private MyAdapter myAdapter;

    private static final String TAG=FrameworkFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_framework, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        list=new ArrayList<>();
        itemList=new String[]{"OkHttp","GreenDao","RxJava","FastJson","EventBus","UploadImage"};
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
            case "OkHttp":
                startActivity(new Intent(getContext(), ActivityOkhttp.class));
                break;
            case "GreenDao":
                startActivity(new Intent(getContext(), ActivityGreenDao.class));
                break;
            case "RxJava":
                startActivity(new Intent(getContext(), RxAndroidActivity.class));
                break;
            case "FastJson":
                startActivity(new Intent(getContext(), ActivityFastJson.class));
                break;
            case "EventBus":
                startActivity(new Intent(getContext(), ActivityEventBus.class));
                break;
            case "UploadImage":
                startActivity(new Intent(getContext(), UploadActivity.class));
                break;
        }
    }
}
