package com.example.jesus.a02login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.example.jesus.a02login.adapters.VehiculoAdapter;

import java.util.ArrayList;

public class ListViewVehiculos extends AppCompatActivity {

    ListView listViewVehiculo;
    GridView gridViewVehiculo;
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_vehiculos);

        crearVehiculos();

        /*Para listView
        listViewVehiculo = (ListView)findViewById(R.id.listViewVehiculo);
        listViewVehiculo.setAdapter(new VehiculoAdapter(this, vehiculos));*/

        /*Para gridView
        gridViewVehiculo = (GridView)findViewById(R.id.gridViewVehiculo);
        gridViewVehiculo.setAdapter(new VehiculoAdapter(this, vehiculos));*/

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






















