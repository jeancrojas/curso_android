package es.cice.newactivityintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewActivity (View v) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(Activity2.EXTRA_KEY, "Jean Carlos");
        startActivity(intent);
    }

    public void launchImplicitIntent (View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.mit.edu"));
        startActivity(intent);
    }

}
