package es.cice.httpconnections;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import es.cice.httpconnections.util.HTTPConnectionUtil;

public class MainActivity extends AppCompatActivity {

    private HTTPHandler mHandler;
    private TextView bytesMonitor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bytesMonitor = (TextView) findViewById(R.id.bytesMonitorTV);
        mHandler = new HTTPHandler(bytesMonitor);

    }

    public void startDownload (View v) {
        String url = "http://www.mit.edu/";
        HTTPConnectionUtil.obtainResource(url, mHandler);

    }
}
