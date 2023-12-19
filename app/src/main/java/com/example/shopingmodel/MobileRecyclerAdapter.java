package com.example.shopingmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopingmodel.Fragment.MobileFregment;

import java.util.ArrayList;
import java.util.List;

public class MobileRecyclerAdapter extends RecyclerView.Adapter<MobileRecyclerAdapter.MoboleViewHolder> {

    List<MobileDataModel> mobileDataModels,searchlist;


    public MobileRecyclerAdapter(MobileFregment mobileFregment, List<MobileDataModel> mobileDataModels){

        this.mobileDataModels=mobileDataModels;
        this.searchlist=mobileDataModels;

    }


    @NonNull
    @Override
    public MoboleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_itemdata,parent,false);
        return new MoboleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MoboleViewHolder holder, int position) {

        MobileDataModel mobileData=searchlist.get(position);
        Glide
                .with(holder.itemView.getContext())
                .load(mobileData.getImage2())
                .placeholder(R.drawable.ic_launcher_background)

                .into(holder.itemimage);

        holder.name.setText(""+mobileData.name);
        holder.price.setText(""+mobileData.price);
        holder.brand.setText(""+mobileData.brand);
        holder.location.setText(""+mobileData.location);
        holder.year.setText(""+mobileData.year);
        holder.category.setText(""+mobileData.category);

    }

    @Override
    public int getItemCount() {
        return searchlist.size();
    }


    public void search(CharSequence charSequence,  RecyclerView rcv) {
        try{
            String charString=charSequence.toString().toLowerCase().trim();
            if(charString.isEmpty()){
                searchlist=mobileDataModels;
                rcv.setVisibility(View.VISIBLE);

            }else{
                int flag=0;
                List<MobileDataModel> filterlist=new ArrayList<>();
                for(MobileDataModel row:mobileDataModels){
                    if(row.getName().toString().toLowerCase().contains(charString.toLowerCase())){
                        filterlist.add(row);
                        flag=1;
                    }
                }
                if (flag == 1) {
                    searchlist=filterlist;
                    rcv.setVisibility(View.VISIBLE);

                }
                else{

                    rcv.setVisibility(View.GONE);

                }
            }
            notifyDataSetChanged();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public class MoboleViewHolder extends RecyclerView.ViewHolder {

        TextView name,brand,price,location,year,category;
        ImageView itemimage;
        public MoboleViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            brand=itemView.findViewById(R.id.brand);
            price=itemView.findViewById(R.id.price);
            location=itemView.findViewById(R.id.location);
            year=itemView.findViewById(R.id.year);
            category=itemView.findViewById(R.id.category);
            itemimage=itemView.findViewById(R.id.itemimage);
        }
    }
}
