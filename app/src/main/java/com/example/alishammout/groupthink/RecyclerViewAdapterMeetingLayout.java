package com.example.alishammout.groupthink;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterMeetingLayout extends RecyclerView.Adapter<RecyclerViewAdapterMeetingLayout.ViewHolderMeeting>{


    private ArrayList<AgendaItemsClass> wholeAgenda = new ArrayList<>();
    private Context jContext;

    RecyclerViewAdapterMeetingLayout (ArrayList<AgendaItemsClass> wholeAgenda, Context jContext) {
        this.wholeAgenda = wholeAgenda;
        this.jContext = jContext;
    }

    @NonNull
    @Override
    public ViewHolderMeeting onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_recyclervagendacreation, viewGroup, false);
        RecyclerViewAdapterMeetingLayout.ViewHolderMeeting viewHolderMeeting = new ViewHolderMeeting(view);
        return  viewHolderMeeting;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMeeting viewHolderMeeting, int i) {

    }


    @Override
    public int getItemCount() {
        return wholeAgenda.size();
    }

    public class ViewHolderMeeting extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewAgendaNotes;
        EditText editTextNewTime;
        RelativeLayout parentLayoutagendaC;


        public ViewHolderMeeting(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAgendaNotes = itemView.findViewById(R.id.textViewAgendaNotes);
            editTextNewTime = itemView.findViewById(R.id.editTextNewTime);
            parentLayoutagendaC = itemView.findViewById(R.id.parentLayoutagendaC);
        }
    }
}
