package es.cice.thecookiemonstersgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView simulationClock, numCookies1, numCookies2;
    AsyncTaskContador tareaContador;
    Button btnStartOver, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simulationClock = (TextView) findViewById(R.id.simulationClock);
        numCookies1 = (TextView) findViewById(R.id.numCookies1);
        numCookies2 = (TextView) findViewById(R.id.numCookies2);

        tareaContador = new AsyncTaskContador();
        tareaContador.setSimulationClock(simulationClock);

        btnStartOver = (Button) findViewById(R.id.btnStartOver);
        btnStartOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzar();
            }
        });


        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });

    }

    private void lanzar () {
        tareaContador.execute(12);
    }

    private void cancelar () {
        tareaContador.cancel(true);
    }
}
