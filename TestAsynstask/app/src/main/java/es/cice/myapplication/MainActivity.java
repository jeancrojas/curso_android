package es.cice.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonLanzar, buttonCancelar;
    TextView textViewContador;

    AsyncTaskContador tareaContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tareaContador = new AsyncTaskContador();

        textViewContador = (TextView) findViewById(R.id.textViewContador);
        buttonLanzar = (Button) findViewById(R.id.buttonLanzar);
        buttonCancelar = (Button) findViewById(R.id.buttonCancelar);

        tareaContador.setTextViewContador(textViewContador);


        buttonLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzar();
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });



    }

    private void cancelar() {
        tareaContador.cancel(true);
    }

    private void lanzar() {
        tareaContador.execute(100);

    }

}
