package com.novillo.alquilopiso;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.util.ArrayList;
import java.util.List;

import static com.novillo.alquilopiso.R.drawable.piso;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.InfoWindowAdapter {

    private GoogleMap mMap;
    private Marker marcador;
    private Circle circulo;
    double lat = 0.0;
    double lng = 0.0;
    BDPisos bdPisos;
    Context context = this;
    List<Piso> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        bdPisos = new BDPisos(this, "BDPisos", null, 1);


      /* para crear directorio para fotos en tfno. usado una vez solo
      String path ="/storage/emulated/0/AlquiloPiso/fotos/";
        File dir = new File(path);
        dir.mkdirs();

        //creamos un fichero, sino no copiaria la carpeta
        File f = new File(path, "alquilopiso.log");

        OutputStreamWriter fout = null;

        try {
            fout = new OutputStreamWriter(
                    new FileOutputStream(f));

        }
        catch (FileNotFoundException fnfe) {
            Log.d("tags", "error al crear archivo");
        }
        try {
            fout.write("alquilopiso creado");
            fout.close();
        }
        catch (IOException ioe){
            Log.d("tag", "error al cerrar archivo");
        }*/



    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //para ventanas de marcadores
        mMap.setInfoWindowAdapter(this);

        miUbicacion();
        marcadoresPisos();


        //Para cuando pulsamos ventana del marker
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                View view;
                TextView textViewDireccionCompleta, textViewHabitacionesCompleta, textViewPrecioCompleta, textViewMetrosCompleta, textViewBañosCompleta, textViewTelefonoCompleta;
                ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
                String ruta = "/storage/emulated/0/AlquiloPiso/fotos/"; //"data/assets/imagenes/";


                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(R.layout.informacion_piso, null);

                for (Piso piso : items) {

                    if (piso.getMarker().equals(marker)) {

                        Bitmap bitmap1 = BitmapFactory.decodeFile(ruta + piso.getId() + 1 + ".jpg");
                        Bitmap bitmap2 = BitmapFactory.decodeFile(ruta + piso.getId() + 2 + ".jpg");
                        Bitmap bitmap3 = BitmapFactory.decodeFile(ruta + piso.getId() + 3 + ".jpg");
                        Bitmap bitmap4 = BitmapFactory.decodeFile(ruta + piso.getId() + 4 + ".jpg");
                        Bitmap bitmap5 = BitmapFactory.decodeFile(ruta + piso.getId() + 5 + ".jpg");


                        imageView1 = (ImageView) view.findViewById(R.id.ImageView1);
                        imageView2 = (ImageView) view.findViewById(R.id.ImageView2);
                        imageView3 = (ImageView) view.findViewById(R.id.ImageView3);
                        imageView4 = (ImageView) view.findViewById(R.id.ImageView4);
                        imageView5 = (ImageView) view.findViewById(R.id.ImageView5);

                        textViewDireccionCompleta = (TextView) view.findViewById(R.id.textViewDireccionCompleta);
                        textViewHabitacionesCompleta = (TextView) view.findViewById(R.id.textViewHabitacionesCompleta);
                        textViewPrecioCompleta = (TextView) view.findViewById(R.id.textViewPrecioCompleta);
                        textViewMetrosCompleta = (TextView) view.findViewById(R.id.textViewMetrosCompleta);
                        textViewBañosCompleta = (TextView) view.findViewById(R.id.textViewBañosCompleta);
                        textViewTelefonoCompleta = (TextView) view.findViewById(R.id.textViewTelefonoCompleta);

                        imageView1.setImageBitmap(bitmap1);
                        imageView2.setImageBitmap(bitmap2);
                        imageView3.setImageBitmap(bitmap3);
                        imageView4.setImageBitmap(bitmap4);
                        imageView5.setImageBitmap(bitmap5);

                        textViewDireccionCompleta.setText(piso.getDireccion());
                        textViewHabitacionesCompleta.setText(piso.getHabitaciones());
                        textViewPrecioCompleta.setText(piso.getPrecio());
                        textViewMetrosCompleta.setText(piso.getMetros());
                        textViewBañosCompleta.setText(piso.getBaños());
                        textViewTelefonoCompleta.setText(piso.getTelefono());

                        Intent intent = new Intent(context, InformacionPiso.class);

                        intent.putExtra("direccion", piso.getDireccion());
                        intent.putExtra("habitaciones", piso.getHabitaciones());
                        intent.putExtra("precio", piso.getPrecio());
                        intent.putExtra("img1", piso.getFoto1());


                        startActivity(intent);

                    }

                }


                //startActivity(new Intent(context, InformacionPiso.class));

            }
        });

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


    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public View getInfoWindow(Marker marker) {

        View view;
        TextView textViewDireccion, textViewHabitaciones, textViewPrecio;
        ImageView imageViewPrincipal;
        String ruta = "/storage/emulated/0/AlquiloPiso/fotos/"; //"data/assets/imagenes/";


        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.ventana_marker_texto, null);

        for (Piso piso : items) {

            if (piso.getMarker().equals(marker)) {

                Bitmap bitmap = BitmapFactory.decodeFile(ruta + piso.getId() + "1.jpg");

                imageViewPrincipal = (ImageView) view.findViewById(R.id.imageViewPrincipal);
                textViewDireccion = (TextView) view.findViewById(R.id.textViewDireccion);
                textViewHabitaciones = (TextView) view.findViewById(R.id.textViewHabitaciones);
                textViewPrecio = (TextView) view.findViewById(R.id.textViewPrecio);

                imageViewPrincipal.setImageBitmap(bitmap);
                textViewDireccion.setText(piso.getDireccion());
                textViewHabitaciones.setText(piso.getHabitaciones());
                textViewPrecio.setText(piso.getPrecio());
                return view;
            }

        }
        return view;
    }

////////////////////METODO PARA CREAR MARCADORES DE LOS PISOS/////////////////////////////
    private void marcadoresPisos(){

        List<Piso> pisos = bdPisos.listadoPisos();

        for (Piso piso : pisos){

            LatLng coordenadas = new LatLng(piso.getLat(), piso.getLng());
            String titulo = piso.getDireccion();
            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.piso2);
            Marker marker = mMap.addMarker(new MarkerOptions().position(coordenadas).title(titulo).icon(bitmapDescriptor));
            piso.setMarker(marker);
            items.add(piso);
        }
    }



}
