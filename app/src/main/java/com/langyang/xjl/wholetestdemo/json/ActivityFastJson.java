package com.langyang.xjl.wholetestdemo.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.langyang.xjl.wholetestdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityFastJson extends AppCompatActivity {
    private String TAG=ActivityFastJson.class.getSimpleName();

    private String json="{\"firstName\":\"Brett\",\"lastName\":\"McLaughlin\",\"email\":\"aaaa\"}";

    private List<User> users=new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_json);

        User user= JSON.parseObject(json,User.class);
        Log.d(TAG,user.getFirstName());
        Log.d(TAG,user.getLastName());
        Log.d(TAG,user.getEmail());

        String jsonStr= JSON.toJSONString(user);
        Log.d(TAG,jsonStr);
    }
}
