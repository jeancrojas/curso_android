package es.cice.dynamicfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import es.cice.dynamicfragments.fragments.QuoteFragment;
import es.cice.dynamicfragments.fragments.TitlesListFragment;

public class MainActivity extends AppCompatActivity implements TitlesListFragment.TitlesListFragmetHostingActivity{

    private QuoteFragment qFragment;
    private TitlesListFragment titlesFragment;
    private FrameLayout titlesContainer, quotesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlesContainer = (FrameLayout) findViewById(R.id.titleContainer);
        quotesContainer = (FrameLayout) findViewById(R.id.quoteContainer);

        qFragment = new QuoteFragment();
        titlesFragment = new TitlesListFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener(){

            @Override
            public void onBackStackChanged() {
                setLayout();
            }
        });
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.titleContainer, titlesFragment);
        ft.addToBackStack("Composición inicial");


        ft.commit();
        //Para que se ejecute lo pendiente
        fm.executePendingTransactions();
    }


    private void setLayout () {
        if ( qFragment.isAdded() ) {
            titlesContainer.setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            quotesContainer.setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 2f));
        } else {
            titlesContainer.setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            quotesContainer.setLayoutParams(new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, 0f));
        }
    }

    @Override
    public void showTitle(int index) {
        if (!qFragment.isAdded()) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft =  fm.beginTransaction();
            ft.add(R.id.quoteContainer, qFragment);
            ft.addToBackStack(null);
            ft.commit();
            fm.executePendingTransactions();
        }

        qFragment.showTitle(index);


    }
}
