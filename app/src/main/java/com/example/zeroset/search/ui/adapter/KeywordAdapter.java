package com.example.zeroset.search.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.search.model.Keyword;

import java.util.ArrayList;

public class KeywordAdapter extends RecyclerView.Adapter<KeywordAdapter.ViewHolder> {
        ArrayList<Keyword> items = new ArrayList<Keyword>();


@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_keyword, viewGroup, false);

        return new ViewHolder(itemView);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Keyword item = items.get(position);
        holder.setItem(item);

        }


public void addItem(Keyword item){
        items.add(item);
        }
public void delItem(int position){
        items.remove(position);
        }
public void setItems(ArrayList<Keyword> items){
        this.items = items;
        }
public Keyword getItem(int position){
        return items.get(position);
        }
public void setItem(int position, Keyword item){
        items.set(position, item);
        }


@Override
public int getItemCount() {
        return items.size();
        }



public class ViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    ImageButton btn_delete;


    public ViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.keyword);
        btn_delete = itemView.findViewById(R.id.delete);

    }

    public void setItem(Keyword item){
        textView.setText(item.getKeyword());
    }


}


    }

