package com.example.jesus.a02login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.jesus.a02login.adapters.VehiculoAdapter;
import com.example.jesus.a02login.adapters.VehiculoAdapterRecycler;

import java.util.ArrayList;

/**
 * Created by cice on 13/12/16.
 */

public class RecyclerViewVehiculos extends AppCompatActivity {

    RecyclerView recyclerViewVehiculo;
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_vehiculos);

        crearVehiculos();

        recyclerViewVehiculo = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewVehiculo.setHasFixedSize(true);

        final VehiculoAdapterRecycler adaptador = new VehiculoAdapterRecycler(vehiculos);

        adaptador.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecView de Vehculos", "Pulsado el elemento" + recyclerViewVehiculo.getChildAdapterPosition(v));
            }
        });

        recyclerViewVehiculo.setAdapter(adaptador);
        recyclerViewVehiculo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

    }

    private void crearVehiculos() {

        vehiculos.add(new Vehiculo("furgoneta", "1111 DSA", "Citroen", R.drawable.furgo));
        vehiculos.add(new Vehiculo("moto", "4578 GBC", "Honda", R.drawable.moto));
        vehiculos.add(new Vehiculo("moto", "6582 BVZ", "Yamaha", R.drawable.moto));
        vehiculos.add(new Vehiculo("coche", "5581 JHL", "Mercedes", R.drawable.coche));
        vehiculos.add(new Vehiculo("furgoneta", "5600 HHM", "Fiat", R.drawable.furgo));
        vehiculos.add(new Vehiculo("coche", "7633 DDM", "Opel", R.drawable.coche));
        vehiculos.add(new Vehiculo("moto", "0547 CCP", "Ducati", R.drawable.moto));
    }
}
