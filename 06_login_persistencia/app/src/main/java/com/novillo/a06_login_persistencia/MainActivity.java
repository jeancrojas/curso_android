package com.novillo.a06_login_persistencia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextContraseña;
    TextView textViewErrorLogin;



    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsuario         = (EditText)findViewById(R.id.editTextUsuario);
        editTextContraseña      = (EditText)findViewById(R.id.editTextContraseña);
        textViewErrorLogin      = (TextView)findViewById(R.id.textViewErrorLogin);
        Button buttonEntrar   = (Button)findViewById(R.id.buttonEntrar);


        //Creamos el archivo clientes en modo privado, si estuviera creado lo abre.
        final SharedPreferences preferences = getSharedPreferences("Clientes", MODE_PRIVATE);

        //Devuelveme el valor de Usuario y si no existe devuelve el 2 parametro que es null
        String usuarioRegistrado = preferences.getString("Usuario", "null");

        if(usuarioRegistrado == "null"){

            buttonEntrar.setOnClickListener(new View.OnClickListener(){

                //por aqui entra si no esta registrado
                @Override
                public void onClick(View view) {
                    String usuario = editTextUsuario.getText().toString();
                    String contraseña = editTextContraseña.getText().toString();

                    if (contraseña.equals(usuario)){
                        //Añadimos al archivo clientes usuario y contraseña
                        //para que la siguiente vez se pueda buscar usuario y si existe entre a Home directamente
                        SharedPreferences.Editor ed = preferences.edit();
                        ed.putString("Usuario", usuario);
                        ed.putString("Contraseña", contraseña);
                        ed.commit();
                        startActivity(new Intent(context, Home.class));
                        finish();
                    }
                    else{
                        textViewErrorLogin.setText("Empleado no registrado");
                    }


                }
            });

        }else{
            startActivity(new Intent(context, Home.class));// Si no es null es que existe y entra a Home directamente
            finish();
        }

        //grabar en memoria externa, primero hemos pedido permiso en manifest

        try{
            File ruta_sd = Environment.getExternalStorageDirectory();

            File f = new File(ruta_sd.getAbsolutePath(), "Prueba.txt");

            OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));

            fout.write("Texte prueba");
            fout.close();
        }
        catch (Exception e){
            Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
        }


    }
}
