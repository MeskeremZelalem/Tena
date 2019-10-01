package com.example.tena.com.example.tena.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.tena.R;

public class BankAdapter extends BaseAdapter {

    Context context;
    int flags[];
    String[] bankNames;
    LayoutInflater inflater;


    public BankAdapter(Context applicationContext, int[] flags) {
        this.context = applicationContext;
        this.flags = flags;
        inflater = (LayoutInflater.from(applicationContext));
    }




    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int position) {
        return flags[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.spinner_item,null);
        ImageView icon =  convertView.findViewById(R.id.imageView);
        icon.setImageResource(flags[position]);

        return convertView;
    }
}
