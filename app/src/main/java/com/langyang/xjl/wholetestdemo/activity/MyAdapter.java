package com.langyang.xjl.wholetestdemo.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.langyang.xjl.wholetestdemo.R;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by xjl on 2017/1/4.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<String> list;

    private ChildClickListener childClickListener;
    private RecyclerView recyclerView;

    public interface ChildClickListener {
        public void itemClick(RecyclerView parent, View view, int position, String data); //最后的参数是list中的泛型
    }

    public void setOnChildClickListener(ChildClickListener listener){
        this.childClickListener=listener;
    }

    public MyAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView=null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.textView.setText(list.get(position));
//            holder.textView.setText(new String(list.get(position).getBytes("GBK"),"UTF-8"));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (recyclerView!=null&&childClickListener!=null) {
            int position=recyclerView.getChildAdapterPosition(v);
            childClickListener.itemClick(recyclerView,v,position,list.get(position));
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.item_text);
        }
    }

    public void remove(int position){
        list.remove(position);
//        notifyDataSetChanged();
        notifyItemRemoved(position);
    }
}
