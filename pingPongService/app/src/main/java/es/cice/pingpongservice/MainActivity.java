package es.cice.pingpongservice;


import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.cice.pingpongservice.services.PingPongService;


public class MainActivity extends AppCompatActivity {
    private TextView monitor;
    private int id;
    private Messenger serviceMessager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        monitor = (TextView) findViewById(R.id.monitor);
    }



    public class PingPongHandler extends Handler {



    }


    public class PingPongServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceMessager = new Messenger(iBinder);
            Message msg = Message.obtain();
            msg.what = PingPongService.REQUEST_ID;
            Messenger myMessenger = 
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
