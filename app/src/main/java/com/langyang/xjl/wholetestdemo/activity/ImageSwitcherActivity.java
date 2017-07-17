package com.langyang.xjl.wholetestdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ViewSwitcher;

import com.langyang.xjl.wholetestdemo.R;

public class ImageSwitcherActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

    }

    @Override
    public View makeView() {
        return null;
    }
}
