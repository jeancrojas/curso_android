package com.novillo.correoelectronico;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));

        String subject = getResources().getString(R.string.subject);
        String mail = getResources().getString(R.string.mail);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"fulanito@mail.es"});
        emailIntent.putExtra(Intent.EXTRA_CC, new String[]{"menganito@mail.es"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mail);
        emailIntent.setType("message/rfc822");

        startActivity(Intent.createChooser(emailIntent, "Email "));
    }


}
