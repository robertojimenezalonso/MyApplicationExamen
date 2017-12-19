package com.example.roberto.myapplicationexamen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by roberto on 19/12/17.
 */


public class ListaMensajeAdapter extends RecyclerView.Adapter<MensajeViewHolder> {

    private ArrayList<String> mensaje;

    public ListaMensajeAdapter(ArrayList<String> mensaje){
        this.mensaje=mensaje;
    }

    @Override
    public MensajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_mensaje_layout, null);
    MensajeViewHolder mensajeViewHolder = new MensajeViewHolder(view);

        return mensajeViewHolder;
    }

    @Override
    public void onBindViewHolder(MensajeViewHolder holder, int position) {
        holder.textoMensaje.setText(mensaje.get(position));
    }

    @Override
    public int getItemCount() {

        return mensaje.size();
    }
}


class MensajeViewHolder extends RecyclerView.ViewHolder{

    public TextView textoMensaje;


    public MensajeViewHolder(View itemView) {
        super(itemView);
        textoMensaje=itemView.findViewById(R.id.textoMensaje);
    }
}