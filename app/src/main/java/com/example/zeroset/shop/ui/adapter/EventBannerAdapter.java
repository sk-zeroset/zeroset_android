package com.example.zeroset.shop.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zeroset.R;
import com.example.zeroset.databinding.FragmentIntoCategoryBinding;
import com.example.zeroset.shop.model.eventBanner;
import com.example.zeroset.shop.ui.IntoCategoryFragment;

import java.util.ArrayList;

public class EventBannerAdapter extends RecyclerView.Adapter<EventBannerAdapter.ViewHolder> {

    private ArrayList<eventBanner> items;
    private TextView textView;
    private ImageView imageView;
    private Context context;
    private ConstraintLayout layout;
    private FragmentIntoCategoryBinding binding;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.imageView2);
            layout = itemView.findViewById(R.id.itemLayout);
        }
    }
    public EventBannerAdapter(ArrayList<eventBanner> list, Context context) {
        this.context = context;
        this.items = list;
        binding = null;
       // Log.d("0617:",binding.toString());
    }
    public EventBannerAdapter(ArrayList<eventBanner> list, Context context, IntoCategoryFragment fragment) {
        this.context = context;
        this.items = list;
        this.binding = fragment.binding;
        Log.d("0617:",binding.toString());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_banner, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        textView.setText(items.get(position).getTitle());
        Glide.with(context).load(items.get(position).getThumbnail()).into(imageView);
        System.out.printf(items.get(position).getThumbnail());
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding != null){ // 생활페이지 > 메뉴버튼 펼쳐져 있을 때
                    Log.d("0617:",binding.toString());
                    if(IntoCategoryFragment.count){
                        //binding.spin1.setFocusableInTouchMode(false);
                        binding.btnAddNext.setImageResource(R.drawable.btn_arrow_down);
                        binding.spin1.setVisibility(View.GONE);
                        IntoCategoryFragment.count = false;
                        binding.spin1.setFocusable(false);
                    }
                    else{ // 생활페이지 > 메뉴버튼 닫혀있을 때

                    }
                }
                else{ // 생활 제외 페이지

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size() ;
    }

}