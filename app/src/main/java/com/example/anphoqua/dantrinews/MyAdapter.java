package com.example.anphoqua.dantrinews;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context c;
    ArrayList<Item> ds;

    public MyAdapter(Context c, ArrayList<Item> ds) {
        this.c = c;
        this.ds = ds;
    }

    @Override
    public int getCount() {
        return ds.size();
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
        LayoutInflater inf=(LayoutInflater)
                c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview=inf.inflate(R.layout.one_item, viewGroup, false);
        TextView tv_title=(TextView)rowview.findViewById(R.id.title);

        tv_title.setText(ds.get(i).title.toString());

        return rowview;

    }
}
