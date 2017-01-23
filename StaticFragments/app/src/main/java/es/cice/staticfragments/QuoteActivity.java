package es.cice.staticfragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.cice.staticfragments.fragments.QuoteFragment;

public class QuoteActivity extends AppCompatActivity {

    public static final String QUOTE_INDEX="index";
    private QuoteFragment gFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        gFragment = (QuoteFragment) getSupportFragmentManager().findFragmentById(R.id.quoteFragment2);

        Intent intent = getIntent();
        int index = intent.getIntExtra(QUOTE_INDEX, -1);
        gFragment.showTitle(index);

    }


}
