package es.cice.proyectofinalthemoviedatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    TextView anterior = null;


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

        anterior = textViewSubtituloPopular;

        onClick(textViewSubtituloPopular);

    }

    @Override
    public void onClick(View v) {
        //View Tratado con anterioridad


        if ( v ==  textViewSubtituloPopular && textViewSubtituloPopular.getCurrentTextColor() != Integer.parseInt("-256") ) {
            Snackbar.make(v, "Popular", Snackbar.LENGTH_SHORT).show();

            estiloTextView(textViewSubtituloPopular);


            final HiloPeliculas hiloPopular = new HiloPeliculas(Pelicula.POPULAR);
            hiloPopular.start();
            try {
                hiloPopular.join();
                listaPeliculas = new ListaPeliculas(this, hiloPopular.getPelicula());
                listViewLista.setAdapter(listaPeliculas);
                listViewLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Log.d(TAG,"posicion: "+position);

                        Log.d(TAG,"Información de la Pelicula: \n"+hiloPopular.getPelicula().get(position).toString() );
                        Intent intent = new Intent(MainActivity.this ,MostrarPelicula.class);

                        intent.putExtra("release_date",hiloPopular.getPelicula().get(position).getRelease_date() );
                        intent.putExtra("original_title", hiloPopular.getPelicula().get(position).getTitle());
                        intent.putExtra("vote_average",hiloPopular.getPelicula().get(position).getVote_average() );
                        intent.putExtra("overview",hiloPopular.getPelicula().get(position).getOverview() );
                        intent.putExtra("imageURL",hiloPopular.getPelicula().get(position).getUrlImage());

                        startActivity(intent);

                    }
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        if ( v ==  textViewSubtituloMejorValoradas && textViewSubtituloMejorValoradas.getCurrentTextColor() != Integer.parseInt("-256") ) {
            Log.d(TAG, "El color es Mejor Valoradas: "+textViewSubtituloMejorValoradas.getCurrentTextColor() );
            Snackbar.make(v, "Mejor Valoradas", Snackbar.LENGTH_SHORT).show();

            estiloTextView(textViewSubtituloMejorValoradas);


            HiloPeliculas hiloMejorValoradas = new HiloPeliculas(Pelicula.MEJOR_VALORADAS);
            hiloMejorValoradas.start();
            try {
                hiloMejorValoradas.join();
                listaPeliculas = new ListaPeliculas(this, hiloMejorValoradas.getPelicula());
                listViewLista.setAdapter(listaPeliculas);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if ( v ==  textViewSubtituloProximamente && textViewSubtituloProximamente.getCurrentTextColor() != Integer.parseInt("-256") ) {
            Snackbar.make(v, "Proximamente", Snackbar.LENGTH_SHORT).show();

            estiloTextView(textViewSubtituloProximamente);

            HiloPeliculas hiloProximamente = new HiloPeliculas(Pelicula.PROXIMAMENTE);
            hiloProximamente.start();
            try {
                hiloProximamente.join();
                listaPeliculas = new ListaPeliculas(this, hiloProximamente.getPelicula());
                listViewLista.setAdapter(listaPeliculas);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if ( v ==  textViewSubtituloEnCarteleraHoy && textViewSubtituloEnCarteleraHoy.getCurrentTextColor() != Integer.parseInt("-256")) {
            Snackbar.make(v, "Cartelera Hoy", Snackbar.LENGTH_SHORT).show();

            estiloTextView(textViewSubtituloEnCarteleraHoy);

            HiloPeliculas hiloEnCarteleraHoy = new HiloPeliculas(Pelicula.EN_CARTELERA_HOY);
            hiloEnCarteleraHoy.start();
            try {
                hiloEnCarteleraHoy.join();
                listaPeliculas = new ListaPeliculas(this, hiloEnCarteleraHoy.getPelicula());
                listViewLista.setAdapter(listaPeliculas);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void estiloTextView (TextView actual){
        actual.setTextColor(Color.YELLOW);
        actual.setBackground(getResources().getDrawable(R.drawable.back));


        if ( actual != anterior ) {
            anterior.setTextColor(Color.WHITE);
            anterior.setBackground(getResources().getDrawable(R.drawable.border_white));
            anterior = actual;
        }


    }

    /*
    Thread slowWorkerThread = new Thread() {



        @Override
        public void run() {
            super.run();
            try {
                //url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=e4190e0e5981362e0722c17cfd44da57&language=es-ES");
                //        new URL("https://api.themoviedb.org/3/movie/popular?api_key=e4190e0e5981362e0722c17cfd44da57");

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


                for (Pelicula p : pelicula) {
                    Log.d(TAG, "slowWorkerThread... "+p.toString());
                }





            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };
    */
}
