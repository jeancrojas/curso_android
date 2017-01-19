package com.novillo.calculadora;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button botonCambiarColor = (Button) findViewById(R.id.buttonCambiarColor);


        botonCambiarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(R.color.azul == #00537d) {
                    R.color.azul = ea4d39;
                }

                startActivity(new Intent(context, MainActivity.class));

            }


        });
    }
}
