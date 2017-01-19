package com.novillo.analyticsejemplo;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by cice on 2/1/17.
 */

public class AnalyticsApplication extends Application {

    private Tracker mTracker;


    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);

            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
