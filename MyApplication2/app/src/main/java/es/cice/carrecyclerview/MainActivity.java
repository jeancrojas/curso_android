package es.cice.carrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import es.cice.carrecyclerview.model.Car;
import es.cice.carrecyclerview.adapters.CarAdapter;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView carRV = (RecyclerView) findViewById(R.id.carRV);
        carRV.setAdapter (new CarAdapter(this, getData() ) );
        carRV.setLayoutManager(new LinearLayoutManager(this));

    }


    private List<Car> getData () {
        List<Car> list= new ArrayList<>();

        list.add(new Car("bla bla bla", "Ford", R.drawable.vehiculo1, R.drawable.vehiculo1_thumb, "307"));
        list.add(new Car("bla bla bla", "Renault", R.drawable.vehiculo2, R.drawable.vehiculo2_thumb, "107"));
        list.add(new Car("bla bla bla", "Peugeot", R.drawable.vehiculo3, R.drawable.vehiculo3_thumb, "307"));
        list.add(new Car("bla bla bla", "BMW", R.drawable.vehiculo4, R.drawable.vehiculo4_thumb, "207"));
        list.add(new Car("bla bla bla", "Ford", R.drawable.vehiculo5, R.drawable.vehiculo5_thumb, "507"));

        return list;
    }
}
