package com.example.alishammout.groupthink;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

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
        //needs fixing
        viewHolderGroupOverview.buttonSelectGroup.setText(user.getGroupsInL().get(i));
        viewHolderGroupOverview.parentLayoutGroupOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return user.getGroupsInL().size();
    }

    public class ViewHolderGroupOverview extends RecyclerView.ViewHolder {

        Button buttonSelectGroup;
        RelativeLayout parentLayoutGroupOverview;
        public ViewHolderGroupOverview(@NonNull View itemView) {
            super(itemView);

            buttonSelectGroup = itemView.findViewById(R.id.buttonSelectGroup);
            parentLayoutGroupOverview = itemView.findViewById(R.id.parentLayoutGroupOverview);
        }
    }
}
