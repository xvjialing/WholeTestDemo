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

import java.util.ArrayList;
import java.util.List;


public class WidgetFragment extends Fragment implements MyAdapter.ChildClickListener {

    private RecyclerView recyclerView;
    private List<String> list;
    private String[] itemList;
    private MyAdapter myAdapter;

    private static final String TAG=WidgetFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_widget, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        list=new ArrayList<>();
        itemList=new String[]{"ImageSwitcher","自定义组合控件","自定义View"};
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
            case "ImageSwitcher":
                startActivity(new Intent(getContext(),ImageSwitcherActivity.class));
                break;
            case "自定义组合控件":

                break;
            case "自定义View":
                startActivity(new Intent(getContext(), com.example.xjl.customview.MainActivity.class));
                break;
        }
    }
}
