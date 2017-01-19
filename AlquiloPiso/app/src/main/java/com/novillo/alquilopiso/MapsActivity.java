package com.novillo.alquilopiso;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.InfoWindowAdapter {

    private GoogleMap mMap;
    private Marker marcador;
    private Circle circulo;
    double lat = 0.0;
    double lng = 0.0;
    BDPisos bdPisos;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        bdPisos = new BDPisos(this, "BDPisos", null, 1);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //para ventanas de marcadores
        mMap.setInfoWindowAdapter(this);
        miUbicacion();
        marcadoresPisos(bdPisos.listadoPisos());
        //informacionVentanaMarker(bdPisos.listadoPisos());
    }


    /////////////// AGREGAMOS MARCADOR DE NUESTRA UBICACION CON UN CIRCULO///////////////

    private void agregarMarcador(double lat, double lng) {
        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 16);

        if (marcador != null) marcador.remove();

        marcador = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("Posicion Actual"));
        mMap.animateCamera(miUbicacion);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        if(circulo != null)circulo.remove();

        CircleOptions circleOptions = new CircleOptions()
                .center(coordenadas)
                .radius(250)
                .strokeWidth(2)
                .strokeColor(Color.parseColor("#0D47A1"))
                .strokeWidth(4)
                .fillColor(Color.argb(32, 33, 150, 243));

        circulo = mMap.addCircle(circleOptions);

    }




//////////////////// MOSTRAR VENTANA DE INFORMACION DE CADA MARKER/////////////////

   /*  private void informacionVentanaMarker (List<Piso> items){

        items = bdPisos.listadoPisos();

        //ventana informacion de los marker de cada piso
       mMap.setInfoWindowAdapter((GoogleMap.InfoWindowAdapter) this);

        //saltar desde la ventana a actividad con informacion del piso
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

            }
        });

    }*/

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view;
        List<Piso> items;
        TextView textViewDireccion, textViewHabitaciones, textViewPrecio;
        ImageView imageViewPrincipal;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.ventana_marker_texto, null);



        items = bdPisos.listadoPisos();
        for(Piso piso : items){

            imageViewPrincipal = (ImageView)view.findViewById(R.id.imageViewPrincipal);
            textViewDireccion   = (TextView)view.findViewById(R.id.textViewDireccion);
            textViewHabitaciones= (TextView)view.findViewById(R.id.textViewHabitaciones);
            textViewPrecio      = (TextView)view.findViewById(R.id.textViewPrecio);

            textViewDireccion.setText(piso.getDireccion());
            textViewHabitaciones.setText(piso.getHabitaciones());
            textViewPrecio.setText(piso.getPrecio());
            return view;
        }

        return view;
    }



////////////////////METODO PARA CREAR MARCADORES DE LOS PISOS/////////////////////////////
    private void marcadoresPisos(List<Piso> items){

        items = bdPisos.listadoPisos();
        for (Piso piso : items){

            LatLng coordenadas = new LatLng(piso.getLat(), piso.getLng());
            String titulo = piso.getDireccion();
            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.piso2);
            mMap.addMarker(new MarkerOptions().position(coordenadas).title(titulo).icon(bitmapDescriptor));

        }
    }




    ///////////////////////////////// MÉTODO PARA ACTUALIZAR UBICACION CUANDO NOS MOVEMOS///////////////////////////
    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregarMarcador(lat, lng);
        }else{
            Toast.makeText(context, "Debe activar el GPS para utilizar la app", Toast.LENGTH_LONG).show();
            startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
        }

    }


    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            actualizarUbicacion(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };


    private void miUbicacion() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,30,locListener);
    }


}
