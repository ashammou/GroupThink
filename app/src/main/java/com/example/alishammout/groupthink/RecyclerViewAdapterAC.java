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

    private ArrayList<AgendaItemsClass> agenda;
    private Context acContext;

    RecyclerViewAdapterAC(ArrayList<AgendaItemsClass> agenda, Context acContext) {

        this.agenda = agenda;
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

    }

    @Override
    public int getItemCount() {


        return agenda.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        EditText agendaAClocal;
        EditText agendaANlocal;

        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
       agendaAClocal = itemView.findViewById(R.id.agendaCT);
       agendaANlocal = itemView.findViewById(R.id.agendaCN);

       parentLayout = itemView.findViewById(R.id.parentLayoutagendaC);



        }
    }





}
