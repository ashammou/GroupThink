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

public class RecyclerViewAdapterMeetingSelection extends RecyclerView.Adapter<RecyclerViewAdapterMeetingSelection.ViewHolder> {

    private ArrayList<String> groupMeetings;
    private Context mContext;
    private String grouptopass;

    RecyclerViewAdapterMeetingSelection(String grouptopass, ArrayList<String> groupMeetings, Context mContext) {
        this.grouptopass = grouptopass;
        this.groupMeetings = groupMeetings;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_meeting_selection, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(groupMeetings.get(i));
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MeetingLayout.class);
                intent.putExtra("passed_meeting", groupMeetings.get(i));
                intent.putExtra("passed_group_from_meeting_selection", grouptopass);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return groupMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView5);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
