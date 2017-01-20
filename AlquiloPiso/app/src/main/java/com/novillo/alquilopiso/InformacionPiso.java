package com.novillo.alquilopiso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InformacionPiso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion_piso);

        TextView textViewDireccionCompleta, textViewHabitacionesCompleta, textViewPrecioCompleta, textViewMetrosCompleta, textViewBañosCompleta, textViewTelefonoCompleta;
        ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
        String ruta = "/storage/emulated/0/AlquiloPiso/fotos/";

        imageView1 = (ImageView) findViewById(R.id.ImageView1);
        imageView2 = (ImageView) findViewById(R.id.ImageView2);
        imageView3 = (ImageView) findViewById(R.id.ImageView3);
        imageView4 = (ImageView) findViewById(R.id.ImageView4);
        imageView5 = (ImageView) findViewById(R.id.ImageView5);

        Bitmap bitmap1 = BitmapFactory.decodeFile(ruta + piso.getId() + 1 + ".jpg");
        Bitmap bitmap2 = BitmapFactory.decodeFile(ruta + piso.getId() + 2 + ".jpg");
        Bitmap bitmap3 = BitmapFactory.decodeFile(ruta + piso.getId() + 3 + ".jpg");
        Bitmap bitmap4 = BitmapFactory.decodeFile(ruta + piso.getId() + 4 + ".jpg");
        Bitmap bitmap5 = BitmapFactory.decodeFile(ruta + piso.getId() + 5 + ".jpg");

        textViewDireccionCompleta = (TextView) findViewById(R.id.textViewDireccionCompleta);
        textViewHabitacionesCompleta = (TextView) findViewById(R.id.textViewHabitacionesCompleta);
        textViewPrecioCompleta = (TextView) findViewById(R.id.textViewPrecioCompleta);
        textViewMetrosCompleta = (TextView) findViewById(R.id.textViewMetrosCompleta);
        textViewBañosCompleta = (TextView) findViewById(R.id.textViewBañosCompleta);
        textViewTelefonoCompleta = (TextView) findViewById(R.id.textViewTelefonoCompleta);

        textViewDireccionCompleta.setText(getIntent().getStringExtra("direccion"));
        textViewHabitacionesCompleta.setText(getIntent().getStringExtra("habitaciones"));
        textViewPrecioCompleta.setText(getIntent().getStringExtra("precio"));

        imageView1.
    }
}
