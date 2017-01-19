package com.example.jesus.a02login.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesus.a02login.R;
import com.example.jesus.a02login.Vehiculo;

import java.util.ArrayList;

/**
 * Created by cice on 12/12/16.
 */

public class VehiculoAdapter extends ArrayAdapter <Vehiculo> {

    ArrayList<Vehiculo> vehiculos;
    Context context;

    public VehiculoAdapter(Context context, ArrayList<Vehiculo> vehiculos) {
        super(context, R.layout.item, vehiculos);
        this.vehiculos = vehiculos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return vehiculos.size();
    }

    @Nullable
    @Override
    public Vehiculo getItem(int position) {
        return vehiculos.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;

        LayoutInflater inflater = LayoutInflater.from(context);
        item = inflater.inflate(R.layout.item, null);


        String tipo = (vehiculos.get(position).getTipo());

        TextView modelo = (TextView)item.findViewById(R.id.textViewModelo);
        modelo.setText(vehiculos.get(position).getModelo());

        TextView matricula = (TextView)item.findViewById(R.id.textViewMatricula);
        matricula.setText(vehiculos.get(position).getMatricula());

        ImageView foto =(ImageView)item.findViewById((R.id.imageViewFoto));

        if(tipo.equals("moto")){
            foto.setImageResource(R.drawable.moto);
        }else if(tipo.equals("coche")){
            foto.setImageResource(R.drawable.coche);
        }
        else {
            foto.setImageResource(R.drawable.furgo);
        }


        return item;
    }
}
































