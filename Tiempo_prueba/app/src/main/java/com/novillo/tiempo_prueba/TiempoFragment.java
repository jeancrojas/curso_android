package com.novillo.tiempo_prueba;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jesus on 04/01/2017.
 */

public class TiempoFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    TextView textViewCiudad, textViewTemperatura, textViewDescripcion, textViewHumedad, textViewViento;
    Spinner spinner;
    //Adapter adapter;
    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragmento_tiempo, container, false);
        textViewCiudad =(TextView)v.findViewById(R.id.textViewCiudad);
        textViewTemperatura =(TextView)v.findViewById(R.id.textViewTemperatura);
        textViewDescripcion =(TextView)v.findViewById(R.id.textViewDescripcion);
        textViewHumedad =(TextView)v.findViewById(R.id.textViewHumedad);
        textViewViento =(TextView)v.findViewById(R.id.textViewViento);
        spinner =(Spinner)v.findViewById(R.id.tipoSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(v.getContext(), R.array.Ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Lanzamos el listener del spinner, el objeto que se hara cargo de responder es nuestro propio FragmentConsulta (implementa la interfaz OnItemSelectedListener)
        spinner.setOnItemSelectedListener(this);



        this.v = v;
        return  v;
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String selection = parent.getItemAtPosition(position).toString();


        JsonTask jsonTask = new JsonTask(v);


        /////Comprobar la red///////
        try{


                jsonTask.execute(new URL("http://api.openweathermap.org/data/2.5/find?q=" + selection +",es&appid=db87faa1ae2eb9f5b56d2d2bd6e11ff2&units=metric&lang=es"));

        }catch (MalformedURLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
