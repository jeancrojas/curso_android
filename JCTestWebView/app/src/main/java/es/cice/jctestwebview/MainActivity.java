package es.cice.jctestwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webViewWEB = (WebView) findViewById(R.id.webViewWEB);

        //Se puede tambien poner la ruta de un archivo
        // file://android_asset/ejemplo.html
        // este archivo se debe de crear en res >> assets (Vista proyecto)
        // app >> src >> main
        //webViewWEB.loadUrl("http://www.cice.es/");
        webViewWEB.loadUrl("file:///android_asset/miWeb.html");


        WebSettings webSettings = webViewWEB.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webViewWEB.addJavascriptInterface(new WebAppInterface(this), "Android");

        /*
        Por defecto, en el caso de navegar por alguna de lo enlaces de la página cargada con el
        WebView, estos se verán en el navegador web del dispositivo.
        Para evitar esto hay que sobrescribir el WebViewClient
         */
        webViewWEB.setWebViewClient(new WebViewClient());


    }
}
