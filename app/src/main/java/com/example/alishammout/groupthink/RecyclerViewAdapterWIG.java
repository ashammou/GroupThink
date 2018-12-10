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

public class RecyclerViewAdapterWIG extends RecyclerView.Adapter<RecyclerViewAdapterWIG.ViewHolderWIG> {

    private ArrayList<String> usersingroup = new ArrayList<>();
    private Context mContext;


    RecyclerViewAdapterWIG(ArrayList<String> usersingroup, Context mContext) {

        this.usersingroup = usersingroup;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolderWIG onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_recycler_view_who_is_in_group, viewGroup, false);
        RecyclerViewAdapterWIG.ViewHolderWIG viewHolderWIG= new ViewHolderWIG(view);
        return  viewHolderWIG;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderWIG viewHolderWIG, int i) {

        viewHolderWIG.textView.setText(usersingroup.get(i));

    }

    @Override
    public int getItemCount() {
        return usersingroup.size();
    }

    public class ViewHolderWIG extends RecyclerView.ViewHolder{
        TextView textView;
        RelativeLayout parentlayout;


        public ViewHolderWIG(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.RCVWhoisn);
            parentlayout = itemView.findViewById(R.id.layout_recyclerview_whoisin);



        }
    }
}
