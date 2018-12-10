package com.example.alishammout.groupthink;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterWIG extends RecyclerView.Adapter<RecyclerViewAdapterWIG.ViewHolder> {

    private ArrayList<String> usersingroup = new ArrayList<>();
    private Context mContext;


    RecyclerViewAdapterWIG(ArrayList<String> usersingroup, Context mContext) {

        this.usersingroup = usersingroup;
        this.mContext = mContext;


    }


    @NonNull
    @Override
    public RecyclerViewAdapterWIG.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler_view_who_is_in_group, viewGroup, false);
        RecyclerViewAdapterWIG.ViewHolder viewHolder = new RecyclerViewAdapterWIG.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterWIG.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return usersingroup.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        RelativeLayout parentlayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.RCVWhoisn);
            parentlayout = itemView.findViewById(R.id.layout_recyclerview_whoisin);



        }
    }
}
