package com.example.alishammout.groupthink;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterAC extends RecyclerView.Adapter<RecyclerViewAdapterAC.ViewHolder>{

    private ArrayList<AgendaItemsClass> agendaItem;
    private Context acContext;

    RecyclerViewAdapterAC(ArrayList<AgendaItemsClass> agendaItem, Context acContext) {

        this.agendaItem = agendaItem;
        this.acContext = acContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.layout_recyclervagendacreation, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textViewTitle.setText(agendaItem.get(i).getDescriptionL());
        viewHolder.textViewAgendaNotes.setText(agendaItem.get(i).getNotesL());
        viewHolder.editTextNewTime.setText(agendaItem.get(i).getTimeL());
    }

    @Override
    public int getItemCount() {
        return agendaItem.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewAgendaNotes;
        EditText editTextNewTime;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAgendaNotes = itemView.findViewById(R.id.textViewAgendaNotes);
            editTextNewTime = itemView.findViewById(R.id.editTextNewTime);

            parentLayout = itemView.findViewById(R.id.parentLayoutagendaC);
        }
    }

}
