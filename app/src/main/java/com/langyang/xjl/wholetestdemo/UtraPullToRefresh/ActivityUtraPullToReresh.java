package com.langyang.xjl.wholetestdemo.UtraPullToRefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.langyang.xjl.wholetestdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityUtraPullToReresh extends AppCompatActivity {

    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utra_pull_to_reresh);
        ButterKnife.bind(this);


    }
}
