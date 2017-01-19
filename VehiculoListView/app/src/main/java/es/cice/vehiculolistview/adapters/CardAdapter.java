package es.cice.vehiculolistview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.cice.vehiculolistview.R;
import es.cice.vehiculolistview.model.Vehiculo;

/**
 * Created by cice on 19/1/17.
 */

public class CardAdapter extends ArrayAdapter<Vehiculo> {

    private Context ctx;
    private List<Vehiculo> data;

    public CardAdapter(Context context, int resource, List<Vehiculo> objects) {
        super(context, resource, objects);
        ctx = context;
        data = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View row = inflater.inflate(R.layout.row_car, null);
        ImageView carIV = (ImageView) row.findViewById(R.id.carThumbIV);
        TextView carTV = (TextView) row.findViewById(R.id.carNameIV);

        carIV.setImageResource(data.get(position).getMiniatura());
        carTV.setText(data.get(position).getFabricante() + " " + data.get(position).getModelo() );
        return row;
    }
}
