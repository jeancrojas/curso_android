package com.novillo.listview.modelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.novillo.libreriascroll.QuickScroll;
import com.novillo.listview.R;
import com.novillo.listview.adapter.VehiculoAdapter;

import java.util.ArrayList;


public class ListViewVehiculos extends AppCompatActivity {

    ListView listViewVehiculo;
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    VehiculoAdapter vehiculoAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_vehiculos);
        
        crearVehiculos();

        listViewVehiculo = (ListView)findViewById(R.id.listViewVehiculo);
        vehiculoAdapter = new VehiculoAdapter(this, vehiculos);
        listViewVehiculo.setAdapter(vehiculoAdapter);

        final QuickScroll quickscroll = (QuickScroll) findViewById(R.id.quickscroll);
        quickscroll.init(QuickScroll.TYPE_INDICATOR, listViewVehiculo, vehiculoAdapter, QuickScroll.STYLE_HOLO);
    }

    private void crearVehiculos() {

        vehiculos.add(new Vehiculo("furgoneta", "1111 DSA", "Citroen", R.drawable.furgo));
        vehiculos.add(new Vehiculo("moto", "4578 GBC", "Honda", R.drawable.moto));
        vehiculos.add(new Vehiculo("moto", "6582 BVZ", "Yamaha", R.drawable.moto));
        vehiculos.add(new Vehiculo("coche", "5581 JHL", "Mercedes", R.drawable.coche));
        vehiculos.add(new Vehiculo("furgoneta", "5600 HHM", "Fiat", R.drawable.furgo));
        vehiculos.add(new Vehiculo("coche", "7633 DDM", "Opel", R.drawable.coche));
        vehiculos.add(new Vehiculo("moto", "0547 CCP", "Ducati", R.drawable.moto));
        vehiculos.add(new Vehiculo("coche", "5581 JHL", "Mercedes", R.drawable.coche));
        vehiculos.add(new Vehiculo("furgoneta", "5600 HHM", "Fiat", R.drawable.furgo));
        vehiculos.add(new Vehiculo("coche", "7633 DDM", "Opel", R.drawable.coche));
        vehiculos.add(new Vehiculo("moto", "0547 CCP", "Ducati", R.drawable.moto));
        vehiculos.add(new Vehiculo("furgoneta", "1111 DSA", "Citroen", R.drawable.furgo));
        vehiculos.add(new Vehiculo("moto", "4578 GBC", "Honda", R.drawable.moto));
        vehiculos.add(new Vehiculo("moto", "6582 BVZ", "Yamaha", R.drawable.moto));
        vehiculos.add(new Vehiculo("coche", "5581 JHL", "Mercedes", R.drawable.coche));
        vehiculos.add(new Vehiculo("furgoneta", "5600 HHM", "Fiat", R.drawable.furgo));
        vehiculos.add(new Vehiculo("coche", "7633 DDM", "Opel", R.drawable.coche));
        vehiculos.add(new Vehiculo("moto", "0547 CCP", "Ducati", R.drawable.moto));
        vehiculos.add(new Vehiculo("coche", "5581 JHL", "Mercedes", R.drawable.coche));
        vehiculos.add(new Vehiculo("furgoneta", "5600 HHM", "Fiat", R.drawable.furgo));
        vehiculos.add(new Vehiculo("coche", "7633 DDM", "Opel", R.drawable.coche));
        vehiculos.add(new Vehiculo("moto", "0547 CCP", "Ducati", R.drawable.moto));
    }
}
