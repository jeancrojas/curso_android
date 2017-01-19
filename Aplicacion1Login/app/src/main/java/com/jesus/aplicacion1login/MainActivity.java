package com.jesus.aplicacion1login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextContraseña;
    TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // es final y no da problema porque lo que es final es la direccion de memoria, no el contenido.
        editTextUsuario = (EditText)findViewById(R.id.editTextUsuario);
        editTextContraseña  = (EditText)findViewById(R.id.editTextContraseña);

        textViewResultado = (TextView) findViewById(R.id.textViewResultado);

        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String usuario = editTextUsuario.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                if (contraseña.equals(usuario + "1")) {
                    textViewResultado.setText("correcto");
                } else {
                    textViewResultado.setText("incorrecto");
                }
            }
        });
    }
}
