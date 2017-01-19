package com.example.jesus.a02login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
        Button buttonEmpleado   = (Button)findViewById(R.id.buttonEmpleado);
        Button buttonCliente    = (Button)findViewById(R.id.buttonCliente);




        buttonEmpleado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String usuario      = editTextUsuario.getText().toString();
                String contraseña   = editTextContraseña.getText().toString();

                if (contraseña.equals(usuario + "1")){
                    startActivity(new Intent(context, Main2Activity.class));
                    finish();
                }
                else{
                    textViewErrorLogin.setText("Empleado no registrado");
                }
            }
        });

        buttonCliente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(context, RecyclerViewVehiculos.class));

            }
        });


    }


}





























