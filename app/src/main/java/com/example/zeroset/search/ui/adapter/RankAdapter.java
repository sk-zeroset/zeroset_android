package com.example.zeroset.search.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zeroset.R;

import java.util.ArrayList;

public class RankAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> list;
    private LayoutInflater inflate;


    public RankAdapter(Context context, ArrayList<String> list){
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflate.inflate(R.layout.row_ranklist, null);

        TextView ranknum = (TextView)view.findViewById(R.id.ranknum);
        TextView ranktxt = (TextView)view.findViewById(R.id.ranktxt);

        ranknum.setText(Integer.toString(position+1));
        ranktxt.setText(list.get(position));

        if(position>=3){
            ranknum.setTextColor(Color.parseColor("#8E8E93"));
            ranktxt.setTextColor(Color.parseColor("#8E8E93"));

        }

        return view;
    }

}
