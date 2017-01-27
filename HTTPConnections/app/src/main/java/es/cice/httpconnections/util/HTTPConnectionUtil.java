package es.cice.httpconnections.util;

import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Handler;

import es.cice.httpconnections.HTTPHandler;
import es.cice.httpconnections.R;

import static es.cice.httpconnections.R.id.bytesMonitorTV;

/**
 * Created by cice on 26/1/17.
 */

public class HTTPConnectionUtil {

    //private HTTPHandler mHandler;
    //private static final TextView bytesMonitor;


    public static void obtainResource(final String urlStr, final HTTPHandler mHandler) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    URL url = new URL(urlStr);

                    URLConnection con = url.openConnection();
                    InputStream in = con.getInputStream();
                    int byteLeido;

                    while ((byteLeido = in.read()) != -1) {
                        Message msg = mHandler.obtainMessage (HTTPHandler.PUBLISH_DATA, new Integer(byteLeido));
                        mHandler.sendMessage(msg);
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        //bytesMonitor = (TextView) findViewById(R.id.bytesMonitorTV);


    }

}
