package com.langyang.xjl.wholetestdemo.greenDao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.langyang.xjl.wholetestdemo.R;

import java.util.List;

/**
 * @Author : xjl
 * @Created : 2016-12-12
 * @E-mail : xvjialing@outlook.com
 * @Version : 1.0
 */
public class DeviceAdapter extends BaseAdapter {

    private Context context;            //运行上下文
    private LayoutInflater inflater;  //视图容器
    private List<Mac> macList;   //商品信息集合

    //自定义控件集合
    public class ViewHolder{
        public TextView tv_mac;
    }

    public DeviceAdapter(Context context, List<Mac> macList) {
        this.context = context;
        inflater=LayoutInflater.from(context);    //创建视图容器并设置上下文
        this.macList = macList;
    }

    @Override
    public int getCount() {
        return macList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //自定义视图
        ViewHolder viewHolder=null;
        if (view==null){

            viewHolder=new ViewHolder();
            //获取list_item布局文件的视图
            view=inflater.inflate(R.layout.item_device,null);

            viewHolder.tv_mac= (TextView) view.findViewById(R.id.tv_mac);

            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }

        viewHolder.tv_mac.setText((String) macList.get(i).getMac());

        return view;
    }
}
