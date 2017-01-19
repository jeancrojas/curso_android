package com.novillo.a08cargarweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView miVista = (WebView) this.findViewById(R.id.webView);

        miVista.loadUrl("http://marca.es");
    }
}
