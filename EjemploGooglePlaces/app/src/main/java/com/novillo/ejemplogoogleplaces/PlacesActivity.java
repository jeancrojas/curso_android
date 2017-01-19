package com.novillo.ejemplogoogleplaces;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import static android.view.View.*;

public class PlacesActivity extends AppCompatActivity {

    private static final int REQUEST_PLACE_PICKER = 1;
    private static  final int GOOGLE_API_CLIENT_ID = 1;
    private static final String LOG_TAG = "";
    Activity activity = this;
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        Button buttonPlacePiker = (Button) findViewById(R.id.buttonPlace);

        buttonPlacePiker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
                    LatLng bernabeu = new LatLng(40.45306, -3.68835);
                    LatLng bernabeu2 = new LatLng(40.46, -3.67);
                    intentBuilder.setLatLngBounds(new LatLngBounds(bernabeu, bernabeu2));
                    Intent intent = intentBuilder.build(activity);
                    startActivityForResult(intent, REQUEST_PLACE_PICKER);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        mGoogleApiClient = new GoogleApiClient.Builder(PlacesActivity.this)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, GOOGLE_API_CLIENT_ID, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    }
                })
                .build();
        
        Button buttonCurrentPlace = (Button) findViewById(R.id.buttonCurrentPlace);
        
        buttonCurrentPlace.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mGoogleApiClient.isConnected()){
                    callPlaceDetectionApi();
                }
            }
        });
    }

//////////////////// LUGARES CERCANOS A NUESTRA POSICION/////////////////////
    private void callPlaceDetectionApi() throws  SecurityException {

        PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);

        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
            @Override
            public void onResult( PlaceLikelihoodBuffer likelyPlaces) {
                for(PlaceLikelihood placeLikelihood : likelyPlaces){
                    Log.i(LOG_TAG, String.format("Place '%s' with"+ "likelihood:",placeLikelihood.getPlace().getName()));
                }
                likelyPlaces.release();
            }
        });
    }
}
