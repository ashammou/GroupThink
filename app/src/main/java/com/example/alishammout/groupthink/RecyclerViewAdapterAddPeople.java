package com.example.alishammout.groupthink;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterAddPeople extends RecyclerView.Adapter<RecyclerViewAdapterAddPeople.ViewHolder> {

    private ArrayList<UserClass> groupMembers;
    private Context mContext;

    RecyclerViewAdapterAddPeople(ArrayList<UserClass> groupMembers, Context mContext) {
        this.groupMembers = groupMembers;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view = LayoutInflater .from(viewGroup.getContext()).inflate(R.layout.recycler_view_add_people, viewGroup, false);
         ViewHolder viewHolder = new ViewHolder(view);
         return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(groupMembers.get(i).usernameL);
    }

    @Override
    public int getItemCount() {
        return groupMembers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         ImageView imageView;
         TextView textView;
         RelativeLayout parentLayout;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             itemView = itemView.findViewById(R.id.imageView);
             textView = itemView.findViewById(R.id.textView);
             parentLayout = itemView.findViewById(R.id.parent_layout);
         }
     }
}
