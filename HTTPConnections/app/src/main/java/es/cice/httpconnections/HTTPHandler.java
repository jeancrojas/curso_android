package es.cice.httpconnections;

import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by cice on 26/1/17.
 */

public class HTTPHandler  extends Handler {

    private TextView monitor;
    public static final int PUBLISH_DATA = 1;

    public HTTPHandler(TextView monitor) {
        this.monitor = monitor;
    }

    public void handleMessage () {

    }


}
