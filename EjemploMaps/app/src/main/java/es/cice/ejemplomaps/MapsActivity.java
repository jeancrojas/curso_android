package es.cice.ejemplomaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import es.cice.ejemplomaps.adapters.infoAdapter;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    static final String TAG = "MapsActivity";

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new infoAdapter(this));

        List<LatLng> listMarker = new ArrayList<>();

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        LatLng ticGetafe = new LatLng(40.2938313, -3.7455295);
        Marker m = mMap.addMarker(new MarkerOptions()
                .position(ticGetafe)
                .title("Marker in Sydney")
                .snippet("Centro de Formacion"));

        listMarker.add(ticGetafe);

        CameraPosition cameraPosition = new CameraPosition
                .Builder()
                .target(ticGetafe)
                .zoom(18)
                .bearing(45)
                .tilt(70)
                .build();

        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

        //Boton de + y -
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //CREAR MARKER
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Marker marker = mMap.addMarker(new MarkerOptions().position(latLng)
                        .title("Titulo")
                        .snippet("Linea de comentario"));

                marker.setDraggable(true);
                marker.showInfoWindow();

            }

        });

        //BORRAR MARKER
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //marker.remove();
                return false;
            }
        });

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                Log.d(TAG, "onMarkerDragStart()..."+marker.getPosition());
            }

            @Override
            public void onMarkerDrag(Marker marker) {
                //marker.getPosition();
                mMap.addMarker(new MarkerOptions().position(marker.getPosition()));
                Log.d(TAG, "onMarkerDrag()..."+marker.getPosition());
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                //marker.getPosition();
                Log.d(TAG, "onMarkerDragEnd()..."+marker.getPosition());
            }
        });




        //mMap.getUiSettings().setMyLocationButtonEnabled(true);

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ticGetafe));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ticGetafe, 18));
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.animateCamera(cameraUpdate);
    }

}
