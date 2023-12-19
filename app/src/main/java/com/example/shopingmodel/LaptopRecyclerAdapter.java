package com.example.shopingmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopingmodel.Fragment.LaptopFregment;

import java.util.ArrayList;
import java.util.List;

public class LaptopRecyclerAdapter extends RecyclerView.Adapter<LaptopRecyclerAdapter.LaptopViewHorlder> {

    List<LaptopDatamodel>laptopDatamodels,searchlist;




    public LaptopRecyclerAdapter(LaptopFregment laptopFregment, List<LaptopDatamodel>laptopDatamodels){
        this.laptopDatamodels=laptopDatamodels;

        this.searchlist=laptopDatamodels;
    }




    @NonNull
    @Override
    public LaptopViewHorlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.laptop_itemdata,parent,false);
        return new LaptopViewHorlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopViewHorlder holder, int position) {
        LaptopDatamodel laptopDatamodel=searchlist.get(position);


        Glide
                 .with(holder.itemView.getContext())
                .load(laptopDatamodel.getImage())
                .placeholder(R.drawable.ic_launcher_background)

                .into(holder.itemimage);


        holder.name.setText(""+laptopDatamodel.name);
        holder.price.setText(""+laptopDatamodel.price);
        holder.brand.setText(""+laptopDatamodel.brand);
        holder.location.setText(""+laptopDatamodel.location);
        holder.year.setText(""+laptopDatamodel.year);
        holder.category.setText(""+laptopDatamodel.category);


    }

    @Override
    public int getItemCount() {
        return searchlist.size();
    }

    public void search(CharSequence charSequence,  RecyclerView rcv) {
        try{
            String charString=charSequence.toString().toLowerCase().trim();
            if(charString.isEmpty()){
                searchlist=laptopDatamodels;
                rcv.setVisibility(View.VISIBLE);

            }else{
                int flag=0;
                List<LaptopDatamodel> filterlist=new ArrayList<>();
                for(LaptopDatamodel row:laptopDatamodels){
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

    public class LaptopViewHorlder extends RecyclerView.ViewHolder {

        TextView name,brand,price,location,year,category;
        ImageView itemimage;
        public LaptopViewHorlder(@NonNull View itemView) {
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
