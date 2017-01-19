package com.novillo.spinner;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    //ArrayAdapter para conectar el Spinner a nuestros recursos strings.xml
    protected ArrayAdapter<CharSequence> adapter;
    protected RecyclerView recyclerView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        spinner = (Spinner) findViewById(R.id.tipoSpinner);


        adapter = ArrayAdapter.createFromResource(this, R.array.Tipos,
                android.R.layout.simple_spinner_item);

        //Asignas el layout a inflar para cada elemento al momento de desplegar la lista
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Seteas el adaptador
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        //Salvar la posición y valor del item actual
        //this.position = position;
        String selection = parent.getItemAtPosition(position).toString();

        final RecyclerView recyclerViewVehiculo;
        ArrayList<Vehiculo> vehiculos;

        VehiculosSQLiteHelper helper = new VehiculosSQLiteHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        vehiculos = (ArrayList<Vehiculo>) helper.listadoVehiculos(selection);

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


        //Mostramos la selección actual del Spinner
        Toast.makeText(this,"Selección actual: "+ selection,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        
    }
}
