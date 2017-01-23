package es.cice.staticfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuoteActivity extends AppCompatActivity {

    public static final String QUOTE_INDEX="index";
    private String[] quotes;
    private String[] titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        quotes=getResources().getStringArray(R.array.citas);
        titles=getResources().getStringArray(R.array.titles);
    }
}
