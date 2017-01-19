package es.cice.vehiculolistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import es.cice.vehiculolistview.model.Vehiculo;

public class ActivityCoche extends AppCompatActivity {

    public static final String EXTRA_IMAGEN = "keyImagen";
    public static final String EXTRA_DATOS = "keyDatos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche);

        Intent intent = getIntent();
        String value = intent.getStringExtra(EXTRA_KEY);


        TextView cocheDatos = (TextView) findViewById(R.id.cocheDatos);
        cocheDatos.setText("Este es el coche numero: "+ value);

        Vehiculo v = new Vehiculo();


    }
}
