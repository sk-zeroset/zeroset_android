package com.example.zeroset.search.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zeroset.R;
import com.example.zeroset.login.ui.registerActivity;
import com.example.zeroset.search.model.Keyword;
import com.example.zeroset.search.ui.searchActivity;
import com.example.zeroset.search.ui.searchBarActivity;

import java.util.ArrayList;

public class KeywordAdapter extends RecyclerView.Adapter<KeywordAdapter.ViewHolder> {
        ArrayList<Keyword> items = new ArrayList<Keyword>();
        public Boolean section = false;
        public String keyword;


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

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                section = true;
                delItem(position);
                int pos = holder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    if (mListener != null) { mListener.onItemClick(v, pos) ; } }
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                section = false;
                keyword = item.getKeyword();
                int pos = holder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    if (mListener != null) { mListener.onItemClick(v, pos) ; } }
            }
        });
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
    public TextView textView;
    public ImageButton btn_delete;


    public ViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.keyword);
        btn_delete = itemView.findViewById(R.id.delete);

    }

    public void setItem(Keyword item){
        textView.setText(item.getKeyword());
    }


}

    // 리스너 객체 참조를 저장하는 변수
    private OnItemClickListener mListener = null ;

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }


}

