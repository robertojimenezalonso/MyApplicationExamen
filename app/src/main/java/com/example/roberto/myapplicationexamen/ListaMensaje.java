package com.example.roberto.myapplicationexamen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMensaje extends Fragment {

    public RecyclerView recyclerView;


    public ListaMensaje() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_mensaje, container, false);
        recyclerView=v.findViewById(R.id.listamensaje);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        // Seteo Noticias

        ArrayList<String> mdatos= new ArrayList<>();
        mdatos.add("Noticia 1");
        mdatos.add("Noticia 2");
        mdatos.add("Noticia 3");
        mdatos.add("Noticia 4");

        ListaMensajeAdapter listaMensajeAdapter = new ListaMensajeAdapter(mdatos);
        recyclerView.setAdapter(listaMensajeAdapter);
        return v;
    }

}
