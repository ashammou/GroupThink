package com.example.alishammout.groupthink;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterGroupOverview extends RecyclerView.Adapter<RecyclerViewAdapterGroupOverview.ViewHolderGroupOverview> {

    private ArrayList<String> groupsForUser2;
    private Context nContext;

    RecyclerViewAdapterGroupOverview(ArrayList<String> groupsForUser2, Context nContext) {
        this.groupsForUser2 = groupsForUser2;
        this.nContext = nContext;
    }

    @NonNull
    @Override
    public ViewHolderGroupOverview onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_recycler_groupoverview, viewGroup, false);
        ViewHolderGroupOverview viewHolderGroupOverview = new ViewHolderGroupOverview(view);
        return  viewHolderGroupOverview;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGroupOverview viewHolderGroupOverview, final int i) {
        viewHolderGroupOverview.textViewSelectGroup.setText(groupsForUser2.get(i));
        viewHolderGroupOverview.parentLayoutGroupOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        nContext, MeetingSelection.class);
                nContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return groupsForUser2.size();
    }

    public class ViewHolderGroupOverview extends RecyclerView.ViewHolder {

        TextView textViewSelectGroup;
        RelativeLayout parentLayoutGroupOverview;
        public ViewHolderGroupOverview(@NonNull View itemView) {
            super(itemView);

            textViewSelectGroup = itemView.findViewById(R.id.textViewSelectGroup);
            parentLayoutGroupOverview = itemView.findViewById(R.id.parentLayoutGroupOverview);
        }
    }
}
