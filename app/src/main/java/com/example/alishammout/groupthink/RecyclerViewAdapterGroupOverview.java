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

    private UserClass user;
    private Context nContext;

    RecyclerViewAdapterGroupOverview(UserClass user, Context nContext) {
        this.user = user;
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
        viewHolderGroupOverview.textViewSelectGroup.setText(user.getGroupsInL().get(i));
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
        return user.getGroupsInL().size();
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
