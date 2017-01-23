package es.cice.staticfragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.cice.staticfragments.fragments.QuoteFragment;
import es.cice.staticfragments.fragments.TitlesListFragment;

public class MainActivity extends AppCompatActivity implements TitlesListFragment.TitlesListFragmetHostingActivity {

    private QuoteFragment qFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm=getSupportFragmentManager();
        qFragment= (QuoteFragment) fm.findFragmentById(R.id.quoteFragment);
    }

    @Override
    public void showTitle(int index) {
        qFragment.showTitle(index);
    }
}
