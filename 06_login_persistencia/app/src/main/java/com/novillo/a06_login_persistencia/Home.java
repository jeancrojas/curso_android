package com.novillo.a06_login_persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView textViewUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        textViewUsuario = (TextView)findViewById(R.id.textViewUsuario);

        final SharedPreferences preferences = getSharedPreferences("Clientes", MODE_PRIVATE);

        //Devuelveme el valor de Usuario y si no existe devuelve el 2 parametro que es null
        String usuarioRegistrado = preferences.getString("Usuario", "null");

        textViewUsuario.setText(usuarioRegistrado);





    }
}
