package es.cice.proyectofinalthemoviedatabase;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
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
    ImageView imageViewMostrarPeliculaImagen;
    private String imagenURL;
    private String overview;
    private String vote_average;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pelicula);

        textViewMostrarPeliculaTitulo = (TextView) findViewById(R.id.textViewMostrarPeliculaTitulo);
        textViewMostrarPeliculaValoracion = (TextView) findViewById(R.id.textViewMostrarPeliculaValoracion);
        textViewMostrarPeliculaDescripcion = (TextView) findViewById(R.id.textViewMostrarPeliculaDescripcion);
        imageViewMostrarPeliculaImagen = (ImageView) findViewById(R.id.imageViewMostrarPeliculaImagen);


        String original_title = getIntent().getStringExtra("original_title");
        overview = getIntent().getStringExtra("overview");
        String release_date = getIntent().getStringExtra("release_date").substring(0,4);
        //Se almacena en un String para tratarlo en un hilo independiente
        imagenURL= getIntent().getStringExtra("imageURL");
        vote_average = getIntent().getStringExtra("vote_average");


        progressDialog = ProgressDialog.show(MostrarPelicula.this, original_title, "Obteniendo información...",true );
        textViewMostrarPeliculaTitulo.setText(original_title+" ("+release_date+")");








    }

    @Override
    protected void onStart() {
        super.onStart();

        LoaderImageAsyncTask la=new LoaderImageAsyncTask();
        la.execute(imagenURL);

    }

    private class LoaderImageAsyncTask extends AsyncTask<String,Void,Bitmap> {


        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                //Obtener el link
                Log.d(TAG, "doInBackground()..."+params[0]);

                //Descomentar si deseas ver el ProgressDialog
                //Thread.sleep(3000);
                URL url = new URL(params[0]);
                Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                return image;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap!=null) {
                imageViewMostrarPeliculaImagen.setImageBitmap(bitmap);
                textViewMostrarPeliculaDescripcion.setText(Html.fromHtml("<p><b>Sinopsis: </b>"+overview) );
                textViewMostrarPeliculaValoracion.setText(vote_average);
            }
            progressDialog.dismiss();

        }
    }
}
