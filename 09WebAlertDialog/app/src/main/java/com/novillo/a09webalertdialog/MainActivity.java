package com.novillo.a09webalertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView miVista = (WebView) this.findViewById(R.id.webView);


        //habilita JS
        WebSettings miweb= miVista.getSettings();
        miweb.setJavaScriptEnabled(true);

        miVista.addJavascriptInterface(new WebAppInterface(this), "Android");

        miVista.loadUrl("file:///android_asset/ejemplo.html");

    }
}
