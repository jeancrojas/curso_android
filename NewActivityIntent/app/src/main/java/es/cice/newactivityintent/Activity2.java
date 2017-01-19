package es.cice.newactivityintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    public static final String EXTRA_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        String value = intent.getStringExtra(EXTRA_KEY);

        TextView tv = (TextView) findViewById(R.id.messageTV);
        tv.setText(value);

    }
}
