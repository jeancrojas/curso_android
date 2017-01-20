package com.novillo.alquilopiso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    //para Analytics
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnalyticsApplication application =(AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mTracker.setScreenName("Actividad principal");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        final WebView webView = (WebView) findViewById(R.id.webView);

        webView.loadUrl("file:///android_asset/portada.html");


        Button buttonComenzar = (Button)findViewById(R.id.button1);

        buttonComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, MapsActivity.class));

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Boton pulsado")
                        .build());
            }
        });

    }
}
