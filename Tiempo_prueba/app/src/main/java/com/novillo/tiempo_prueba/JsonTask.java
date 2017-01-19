package com.novillo.tiempo_prueba;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.novillo.tiempo_prueba.pojos.Previsiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jesus on 05/01/2017.
 */



public class JsonTask extends AsyncTask<URL, Void, Previsiones> {


    private View v;

    public JsonTask(View v ) {
        this.v = v;
    }

    @Override
    protected Previsiones doInBackground(URL... urls) {


        Previsiones previsiones = null;


        String pagina = "";

        URL url;

        url = urls[0]; //new URL(urls[0]);


        try {
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

                String linea = reader.readLine();

                while (linea != null) {

                    pagina += linea;
                    linea = reader.readLine();
                }

                reader.close();
            }

            conexion.disconnect();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
            return null;
        }

        Gson gson = new Gson();
        previsiones = gson.fromJson(pagina, Previsiones.class);

        return previsiones;


    }

    @Override
    protected void onPostExecute (Previsiones previsiones){
        if(previsiones!=null){
            TextView textviewCiudad = (TextView)v.findViewById(R.id.textViewCiudad);
            textviewCiudad.setText(previsiones.getList().get(0).getName());

            TextView textviewDescripcion = (TextView)v.findViewById(R.id.textViewDescripcion);
            textviewDescripcion.setText(previsiones.getList().get(0).getWeather().get(0).getDescription());

            TextView textviewTemperatura = (TextView)v.findViewById(R.id.textViewTemperatura);
            textviewTemperatura.setText(previsiones.getList().get(0).getMain().getTemp().toString());

            TextView textViewHumedad = (TextView) v.findViewById(R.id.textViewHumedad);
            textViewHumedad.setText(previsiones.getList().get(0).getMain().getHumidity().toString());

            TextView textViewViento = (TextView)v.findViewById(R.id.textViewViento);
            textViewViento.setText(previsiones.getList().get(0).getWind().getSpeed().toString());

        }else{
            //Toast.makeText(getBaseContext(), "Ocurrió un error de Parsing Json", Toast.LENGTH_SHORT).show();
        }
    }
}