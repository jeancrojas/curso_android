package es.cice.ejemplomaps.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import es.cice.ejemplomaps.R;

/**
 * Created by cice on 10/2/17.
 */

public class infoAdapter implements GoogleMap.InfoWindowAdapter {
    static final String TAG = "infoAdapter";
    Activity activity;

    public infoAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        Log.d(TAG, "getInfoWindow()...");
        View view = activity.getLayoutInflater().inflate(R.layout.informacion, null);
        TextView textViewPosicion = (TextView) view.findViewById(R.id.textViewPosicion);
        TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
        ImageView imageViewImage = (ImageView) view.findViewById(R.id.imageViewImage);

        String posicion = marker.getPosition().latitude+ "-"+ marker.getPosition().longitude;
        textViewPosicion.setText(posicion.toString());

        imageViewImage.setImageResource(R.drawable.ic_android);
        textViewTitulo.setText("Descripción del lugar");

        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        Log.d(TAG, "getInfoContents()...");


        return null;

    }
}
