package es.cice.proyectofinalthemoviedatabase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MostrarPelicula extends AppCompatActivity {

    private static final String TAG = "MostrarPelicula";
    TextView textViewMostrarPeliculaTitulo, textViewMostrarPeliculaValoracion,textViewMostrarPeliculaDescripcion ;
    ProgressDialog progressDialog;
    ImageView imageViewMostrarPeliculaImagen, imageViewMostrarPeliculaFondo;
    FloatingActionButton fab;
    private String imagenURL;
    private String overview;
    private String vote_average;
    private String backdrop_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pelicula);

        textViewMostrarPeliculaTitulo = (TextView) findViewById(R.id.textViewMostrarPeliculaTitulo);
        textViewMostrarPeliculaValoracion = (TextView) findViewById(R.id.textViewMostrarPeliculaValoracion);
        textViewMostrarPeliculaDescripcion = (TextView) findViewById(R.id.textViewMostrarPeliculaDescripcion);
        imageViewMostrarPeliculaImagen = (ImageView) findViewById(R.id.imageViewMostrarPeliculaImagen);
        imageViewMostrarPeliculaFondo = (ImageView) findViewById(R.id.imageViewMostrarPeliculaFondo);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        String original_title = getIntent().getStringExtra("original_title");
        overview = getIntent().getStringExtra("overview");
        String release_date = getIntent().getStringExtra("release_date").substring(0,4);
        //Se almacena en un String para tratarlo en un hilo independiente
        imagenURL= getIntent().getStringExtra("imageURL");
        backdrop_path = getIntent().getStringExtra("backdrop_path");
        vote_average = getIntent().getStringExtra("vote_average");


        progressDialog = ProgressDialog.show(MostrarPelicula.this, original_title, "Obteniendo información...",true );
        textViewMostrarPeliculaTitulo.setText(original_title+" ("+release_date+")");


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MostrarPelicula.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        LoaderImageAsyncTask la=new LoaderImageAsyncTask();
        la.execute(imagenURL, backdrop_path);

    }

    private class LoaderImageAsyncTask extends AsyncTask<String,Void,Bitmap[]> {


        @Override
        protected Bitmap[] doInBackground(String... params) {

            Bitmap[] misImagenes = new Bitmap[params.length];

            try {
                //Obtener el link
                Log.d(TAG, "doInBackground()..."+params[0]);

                //Descomentar si deseas ver el ProgressDialog
                //Thread.sleep(3000);
                URL url = new URL(params[0]);
                misImagenes[0] = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                URL urlBackdropPath = new URL(params[1]);
                misImagenes[1] = BitmapFactory.decodeStream(urlBackdropPath.openConnection().getInputStream());

                return misImagenes;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap[] bitmap) {
            if(bitmap!=null) {
                imageViewMostrarPeliculaImagen.setImageBitmap(bitmap[0]);
                imageViewMostrarPeliculaFondo.setImageBitmap(bitmap[1]);

                textViewMostrarPeliculaDescripcion.setText(Html.fromHtml("<p><b>Sinopsis: </b>"+overview) );
                textViewMostrarPeliculaValoracion.setText(vote_average);
            }
            progressDialog.dismiss();

        }
    }
}
