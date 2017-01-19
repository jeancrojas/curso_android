package es.cice.vehiculolistview;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.cice.vehiculolistview.model.Vehiculo;
import es.cice.vehiculolistview.adapters.CardAdapter;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    List<Vehiculo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Vehiculo> data = getData();
        CardAdapter adapter = new CardAdapter (this, R.layout.row_car, data);
        ListView carLV = (ListView) findViewById(R.id.carLV);
        carLV.setAdapter(adapter);
        carLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l ) {
                Log.d(TAG, "item en " + i + "...");
                //Toast.makeText(MainActivity.this, "Click en item " + i + "...", Toast.LENGTH_LONG).show();

                //Añadido
                Intent intent = new Intent(MainActivity.this, ActivityCoche.class);

                String datos = "Fabricante: "+list.get(i).getFabricante()+"\nModelo: "+ list.get(i).getModelo() + "\nDescripcion: "+list.get(i).getDescripcion();
                intent.putExtra(ActivityCoche.EXTRA_DATOS, v.toString() );
                startActivity(intent);



            }
        });
    }



    private  List<Vehiculo> getData () {
        list = new ArrayList<>();

        list.add(new Vehiculo("bla bla bla", "Ford", R.drawable.vehiculo1, R.drawable.vehiculo1_thumb, "307"));
        list.add(new Vehiculo("bla bla bla", "Renault", R.drawable.vehiculo2, R.drawable.vehiculo2_thumb, "107"));
        list.add(new Vehiculo("bla bla bla", "Peugeot", R.drawable.vehiculo3, R.drawable.vehiculo3_thumb, "307"));
        list.add(new Vehiculo("bla bla bla", "BMW", R.drawable.vehiculo4, R.drawable.vehiculo4_thumb, "207"));
        list.add(new Vehiculo("bla bla bla", "Ford", R.drawable.vehiculo5, R.drawable.vehiculo5_thumb, "507"));

        return list;
    }
}
