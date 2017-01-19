package com.novillo.listview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;

import com.novillo.libreriascroll.Scrollable;
import com.novillo.listview.R;
import com.novillo.listview.modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 16/12/2016.
 */

public class VehiculoAdapter extends ArrayAdapter implements Scrollable {

    ArrayList<Vehiculo> vehiculos;

    Context context;


    public VehiculoAdapter(Context context, ArrayList<Vehiculo> vehiculos) {
        super(context, R.layout.activity_list_view_vehiculos, vehiculos);
        this.vehiculos = vehiculos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return vehiculos.size();
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View item = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);
        item = inflater.inflate(R.layout.item, null);

        //Para sacar el tipo de vehiculo y asociar una foto
        String tipo = (vehiculos.get(position).getTipo());

        TextView modelo =(TextView)item.findViewById(R.id.textViewModelo);
        modelo.setText(vehiculos.get(position).getModelo());

        TextView matricula = (TextView)item.findViewById(R.id.textViewMatricula);
        matricula.setText(vehiculos.get(position).getMatricula());

        ImageView foto = (ImageView)item.findViewById(R.id.imageViewFoto);

        if(tipo.equals("moto")){
            foto.setImageResource(R.drawable.moto);
        }else if(tipo.equals("coche")){
            foto.setImageResource(R.drawable.coche);
        }else{
            foto.setImageResource(R.drawable.furgo);
        }

        return item;
    }



    @Nullable
    @Override
    public Vehiculo getItem(int position) {
        return vehiculos.get(position);
    }

    @Override
    public String getIndicatorForPosition(int childposition, int groupposition) {
        return vehiculos.get(childposition).getMatricula().substring(0,1);
    }

    @Override
    public int getScrollPosition(int childposition, int groupposition) {
        return 0;
    }
}





































