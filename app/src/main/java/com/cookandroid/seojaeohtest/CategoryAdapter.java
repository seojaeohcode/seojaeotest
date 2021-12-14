package com.cookandroid.seojaeohtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains)
    {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //카테고리 뷰홀더를 뷰객체로 변환
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cat,parent,false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl = "";
        //position값에 따라 배경과 아이콘변경
        switch (position)
        {
            case 0:{
                picUrl = "gicon";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background1));
                break;
            }
            case 1:{
                picUrl = "aicon";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background2));
                break;
            }
            case 2:{
                picUrl = "wicon";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background3));
                break;
            }
            case 3:{
                picUrl = "dicon";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background4));
                break;
            }
            case 4:{
                picUrl = "micon";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background5));
                break;
            }
        }
        //getIdentifier - 리소스 이름으로 바로 리소스ID itemview=리사이클러뷰의 아이템
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());

        //글라이드를 통해 뷰에 이미지로드
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public Viewholder(@NonNull View itemView){
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
