package com.novillo.publicidad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Main2Activity extends AppCompatActivity {

    InterstitialAd miInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        miInterstitialAd = new InterstitialAd(this);

        miInterstitialAd.setAdUnitId(getString(R.string.interstitial_demo));

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        miInterstitialAd.loadAd(adRequest);

        miInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }

    private void showInterstitial(){
        if(miInterstitialAd.isLoaded()){
            miInterstitialAd.show();
        }
    }
}
