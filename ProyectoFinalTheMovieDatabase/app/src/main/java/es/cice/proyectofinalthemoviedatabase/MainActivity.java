package es.cice.proyectofinalthemoviedatabase;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.cice.proyectofinalthemoviedatabase.adapter.ListaPeliculas;
import es.cice.proyectofinalthemoviedatabase.model.Pelicula;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*
    https://elbauldelprogramador.com/adapter-personalizado-en-android/
    https://elbauldelprogramador.com/adapter-personalizado-en-android/
    https://developers.themoviedb.org/3/getting-started/images
    https://api.themoviedb.org/3/movie/popular?api_key=e4190e0e5981362e0722c17cfd44da57
    https://play.google.com/store/apps/details?id=com.codiwans.cinesa
     */


    static final String TAG = "MainActivity";

    TextView textViewSubtituloPopular, textViewSubtituloMejorValoradas, textViewSubtituloProximamente, textViewSubtituloEnCarteleraHoy;
    ListView listViewLista;
    Gson gson;
    List<Pelicula> pelicula;
    ListaPeliculas listaPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();
        pelicula = new ArrayList<>();

        textViewSubtituloPopular = (TextView) findViewById(R.id.textViewSubtituloPopular);
        textViewSubtituloMejorValoradas = (TextView) findViewById(R.id.textViewSubtituloMejorValoradas);
        textViewSubtituloProximamente = (TextView) findViewById(R.id.textViewSubtituloProximamente);
        textViewSubtituloEnCarteleraHoy = (TextView) findViewById(R.id.textViewSubtituloEnCarteleraHoy);

        textViewSubtituloPopular.setOnClickListener(this);
        textViewSubtituloMejorValoradas.setOnClickListener(this);
        textViewSubtituloProximamente.setOnClickListener(this);
        textViewSubtituloEnCarteleraHoy.setOnClickListener(this);

        listViewLista = (ListView) findViewById(R.id.listViewLista);

        slowWorkerThread.start();
        listaPeliculas = new ListaPeliculas(this, pelicula);
        listViewLista.setAdapter(listaPeliculas);

    }

    @Override
    public void onClick(View v) {

        if ( v ==  textViewSubtituloPopular ) {
            //Snackbar.make(v, "Estas en Popular", Snackbar.LENGTH_SHORT).show();
        }

        if ( v ==  textViewSubtituloMejorValoradas ) {
            //Snackbar.make(v, "Estas en Popular", Snackbar.LENGTH_SHORT).show();
        }

        if ( v ==  textViewSubtituloProximamente ) {
            //Snackbar.make(v, "Estas en Popular", Snackbar.LENGTH_SHORT).show();
        }

        if ( v ==  textViewSubtituloEnCarteleraHoy ) {
            //Snackbar.make(v, "Estas en Popular", Snackbar.LENGTH_SHORT).show();
        }

    }

    Thread slowWorkerThread = new Thread() {

        @Override
        public void run() {
            super.run();
            try {
                URL url =
                        new URL("https://api.themoviedb.org/3/movie/popular?api_key=e4190e0e5981362e0722c17cfd44da57");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuffer data = new StringBuffer();
                String line = "";

                while ((line = bufferedReader.readLine()) != null ){
                    data.append(line);
                }

                JSONObject jsonObject = new JSONObject(data.toString());
                JSONArray results = jsonObject.getJSONArray("results");

                for (int i=0; i < results.length();i++) {
                    JSONObject jsonMovie = results.getJSONObject(i);
                    int id = Integer.parseInt( jsonMovie.getString("id") );
                    String original_title = jsonMovie.getString("original_title");

                    URL urlImage = new URL(Pelicula.BASE_URL_IMAGE+jsonMovie.getString("poster_path"));
                    Bitmap image = BitmapFactory.decodeStream(urlImage.openConnection().getInputStream());

                    String release_date = jsonMovie.getString("release_date");
                    double vote_average = Double.parseDouble(jsonMovie.getString("vote_average"));

                    pelicula.add(new Pelicula(id, image, release_date,original_title,vote_average));
                }

                /*
                for (Pelicula p : pelicula) {
                    Log.d(TAG, "slowWorkerThread... "+p.toString());
                }
                */




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };
}
