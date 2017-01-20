package es.cice.carrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import es.cice.carrecyclerview.model.Car;
import es.cice.carrecyclerview.adapters.CarAdapter;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    List<Car> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Car> data = getData();
        CarAdapter adapter = new CarAdapter (this, R.layout.row_car, data);
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


    private List<Car> getData () {
        list = new ArrayList<>();

        list.add(new Car("bla bla bla", "Ford", R.drawable.vehiculo1, R.drawable.vehiculo1_thumb, "307"));
        list.add(new Car("bla bla bla", "Renault", R.drawable.vehiculo2, R.drawable.vehiculo2_thumb, "107"));
        list.add(new Car("bla bla bla", "Peugeot", R.drawable.vehiculo3, R.drawable.vehiculo3_thumb, "307"));
        list.add(new Car("bla bla bla", "BMW", R.drawable.vehiculo4, R.drawable.vehiculo4_thumb, "207"));
        list.add(new Car("bla bla bla", "Ford", R.drawable.vehiculo5, R.drawable.vehiculo5_thumb, "507"));

        return list;
    }
}
