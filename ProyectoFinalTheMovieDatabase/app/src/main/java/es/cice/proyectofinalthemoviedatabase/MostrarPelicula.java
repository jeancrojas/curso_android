package es.cice.proyectofinalthemoviedatabase;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MostrarPelicula extends AppCompatActivity {

    TextView textViewMostrarPeliculaTitulo, textViewMostrarPeliculaValoracion,textViewMostrarPeliculaDescripcion ;
    ImageView imageViewMostrarPeliculaImagen;
    private static final String TAG = "MostrarPelicula";
    private String imagenURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pelicula);

        textViewMostrarPeliculaTitulo = (TextView) findViewById(R.id.textViewMostrarPeliculaTitulo);
        textViewMostrarPeliculaValoracion = (TextView) findViewById(R.id.textViewMostrarPeliculaValoracion);
        textViewMostrarPeliculaDescripcion = (TextView) findViewById(R.id.textViewMostrarPeliculaDescripcion);

        imageViewMostrarPeliculaImagen = (ImageView) findViewById(R.id.imageViewMostrarPeliculaImagen);

        textViewMostrarPeliculaTitulo.setText(getIntent().getStringExtra("original_title"));
        textViewMostrarPeliculaValoracion.setText(getIntent().getStringExtra("vote_average"));

        //Generando la imagen
         imagenURL= getIntent().getStringExtra("imageURL");




        textViewMostrarPeliculaDescripcion.setText("Sinopsis: "+getIntent().getStringExtra("overview")+"\nFecha de publicación: "+getIntent().getStringExtra("release_date"));


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
                Log.d(TAG, "onCreate()..."+params[0]);

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
            if(bitmap!=null)
                imageViewMostrarPeliculaImagen.setImageBitmap(bitmap);
        }
    }
}
