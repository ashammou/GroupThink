package com.example.alishammout.groupthink;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterAddGroup extends RecyclerView.Adapter<RecyclerViewAdapterAddGroup.ViewHolder>{

    private ArrayList<String> addGUsers;
    private Context addGContext;

    RecyclerViewAdapterAddGroup(ArrayList<String> addGUsers, Context addGContext) {

        this.addGUsers = addGUsers;
        this.addGContext = addGContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.layout_recyclervaddgroup, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.agrvu.setText(addGUsers.get(i));

    }

    @Override
    public int getItemCount() {
        return addGUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView agrvu;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            agrvu = itemView.findViewById(R.id.addGroupRVuser);
            parentLayout = itemView.findViewById(R.id.parentLayoutaddG);


        }
    }


}
