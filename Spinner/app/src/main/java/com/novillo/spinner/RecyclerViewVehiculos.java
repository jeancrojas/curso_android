package com.novillo.spinner;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class RecyclerViewVehiculos extends AppCompatActivity {

    RecyclerView recyclerViewVehiculo;
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_vehiculos);

        //Abrimos la BBDD
        VehiculosSQLiteHelper helper = new VehiculosSQLiteHelper(this);

        SQLiteDatabase db = helper.getReadableDatabase();

        vehiculos = (ArrayList<Vehiculo>) helper.listadoVehiculos("Furgoneta");

        VehiculoAdapterRecycler adaptador = new VehiculoAdapterRecycler(vehiculos);


        recyclerViewVehiculo = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewVehiculo.setHasFixedSize(true);




        adaptador.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecView de Vehiculos", "Pulsado el elemento" + recyclerViewVehiculo.getChildAdapterPosition(v));
            }
        });

        recyclerViewVehiculo.setAdapter(adaptador);
        recyclerViewVehiculo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }
}
