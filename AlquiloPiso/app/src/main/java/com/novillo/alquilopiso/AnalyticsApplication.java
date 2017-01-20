package com.novillo.alquilopiso;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by Jesus on 19/01/2017.
 */

public class AnalyticsApplication extends Application {

    private Tracker mTracker;

    synchronized  public  Tracker getDefaultTracker() {
        if(mTracker == null){
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
