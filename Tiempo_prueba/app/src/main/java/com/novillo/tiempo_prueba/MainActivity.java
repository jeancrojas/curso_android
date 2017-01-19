package com.novillo.tiempo_prueba;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayoutTiempo, frameLayoutTiempo2, frameLayoutFragment;
    TiempoFragment tiempoFragment;
    Boolean segundoFragmentActivo = false;
    protected ArrayAdapter<CharSequence> adapter;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////FRAGMENT/////////////////////

        frameLayoutTiempo = (FrameLayout) findViewById(R.id.frameLayoutTiempo);
        frameLayoutTiempo2 = (FrameLayout) findViewById(R.id.frameLayoutTiempo2);
        frameLayoutFragment = (FrameLayout) findViewById(R.id.frameLayoutFragment);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        tiempoFragment = new TiempoFragment();

        if (frameLayoutFragment == null) {
            fragmentTransaction.replace(R.id.frameLayoutTiempo, new TiempoFragment());
            fragmentTransaction.replace(R.id.frameLayoutTiempo2,  new TiempoFragment());
        } else {
            fragmentTransaction.replace(R.id.frameLayoutFragment,  new TiempoFragment());
        }
        fragmentTransaction.commit();
    }
/*

////////////////////////   CONEXION, DEVOLUCION JSON Y PARSEO DE DATOS    /////////////////////////////
    public class JsonTask extends AsyncTask<URL, Void, Previsiones> {

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
               TextView textviewCiudad = (TextView) findViewById(R.id.textViewCiudad);
                textviewCiudad.setText(previsiones.getList().get(0).getName());

                TextView textviewDescripcion = (TextView) findViewById(R.id.textViewDescripcion);
                textviewDescripcion.setText(previsiones.getList().get(0).getWeather().get(0).getDescription());

                TextView textviewTemperatura = (TextView) findViewById(R.id.textViewTemperatura);
                textviewTemperatura.setText(previsiones.getList().get(0).getMain().getTemp().toString());

                TextView textViewHumedad = (TextView) findViewById(R.id.textViewHumedad);
                textViewHumedad.setText(previsiones.getList().get(0).getMain().getHumidity().toString());

                TextView textViewViento = (TextView) findViewById(R.id.textViewViento);
                textViewViento.setText(previsiones.getList().get(0).getWind().getSpeed().toString());

            }else{
                Toast.makeText(getBaseContext(), "Ocurrió un error de Parsing Json", Toast.LENGTH_SHORT).show();
            }
        }

    }

*/
    ////////////////////////////////////////  ELECCION DEL SPINNER   //////////////////////////////////////
/*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String selection = parent.getItemAtPosition(position).toString();

        /////Comprobar la red///////
        try{
            ConnectivityManager connectivityManager =(ConnectivityManager)getSystemService((Context.CONNECTIVITY_SERVICE));

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo != null && networkInfo.isConnected()){
                new JsonTask().execute(new URL("http://api.openweathermap.org/data/2.5/find?q=" + selection +",es&appid=db87faa1ae2eb9f5b56d2d2bd6e11ff2&units=metric&lang=es"));
            }else{
                Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    */

}





