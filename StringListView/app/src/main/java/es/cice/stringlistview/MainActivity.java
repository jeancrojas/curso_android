package es.cice.stringlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import es.cice.stringlistview.adapters.CardAdapter;
import es.cice.stringlistview.model.Vehiculo;

public class MainActivity extends AppCompatActivity {

    private String[] names = {
            "Jean Carlos",
            "Angel",
            "Javier",
            "Rosa"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Vehiculo> data = getData();
        CardAdapter adapter = new CardAdapter (this, R.layout.row_car, null);

        //Todo lo posterior
        //ListView namesLV = (ListView) findViewById(R.id.namesListView);
        //namesLV.setAdapter(new NamesAdapter(this, R.layout.row_layout,names));
    }

    /*
    public class NamesAdapter extends ArrayAdapter<String> {

        private Context context;

        @Override
        public int getCount() {
            return names.length;
        }

        public NamesAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.row_layout, null);
            TextView nameTV = (TextView) row.findViewById(R.id.nameTV);
            nameTV.setText(names[position]);
            return row;
        }
    }
    */

}
