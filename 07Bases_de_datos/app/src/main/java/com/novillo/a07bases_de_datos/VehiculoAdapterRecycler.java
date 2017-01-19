package com.novillo.a07bases_de_datos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cice on 16/12/16.
 */

public class VehiculoAdapterRecycler extends RecyclerView.Adapter<VehiculoAdapterRecycler.VehiculoViewHolder> implements View.OnClickListener {
    private ArrayList<Vehiculo> items;
    private View.OnClickListener listener;

    public static class VehiculoViewHolder extends RecyclerView.ViewHolder {

        public TextView tipo;
        public TextView matricula;
        public TextView modelo;
        public ImageView foto;

        public VehiculoViewHolder(View v) {
            super(v);
            foto = (ImageView) v.findViewById(R.id.imageViewFoto);
            modelo = (TextView) v.findViewById(R.id.textViewModelo);
            matricula = (TextView) v.findViewById(R.id.textViewMatricula);
        }
    }

    public  VehiculoAdapterRecycler (ArrayList<Vehiculo> items) {this.items = items;}

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public VehiculoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        v.setOnClickListener(this);
        return  new VehiculoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VehiculoViewHolder viewHolder, int posicion) {

        String tipo = items.get(posicion).getTipo();



        if(tipo.equals("Furgoneta")){
            viewHolder.foto.setImageResource(R.drawable.furgo);
        }else if(tipo.equals("Coche")){
            viewHolder.foto.setImageResource(R.drawable.coche);
        }
        else {
            viewHolder.foto.setImageResource(R.drawable.moto);
        }


        viewHolder.modelo.setText(items.get(posicion).getModelo());
        viewHolder.matricula.setText(items.get(posicion).getMatricula());
    }

    public void setOnclickListener(View.OnClickListener listener) {

        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}