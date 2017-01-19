package com.novillo.descargarimageninternet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Button botonMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonMostrar = (Button)findViewById(R.id.buttonDescargar);

        botonMostrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText editText;
                editText = (EditText) findViewById(R.id.editText1);
                new DescargarImagen((ImageView)findViewById(R.id.imageView)).execute("http://somosinvictos.com/wp-content/uploads/2016/05/Copa-Europa-750x288.jpg");
                editText.setText("http://somosinvictos.com/wp-content/uploads/2016/05/Copa-Europa-750x288.jpg");

            }
        });

    }

    private class DescargarImagen extends AsyncTask<String, Void, Bitmap> {

        ImageView bmImage;

        public DescargarImagen(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0]; Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage()); e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
