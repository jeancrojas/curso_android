package es.cice.binservicetest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import es.cice.binservicetest.services.MyBindService;

public class MainActivity extends AppCompatActivity {
    private Messenger messenger;
    private Button connectionBtn, sendMessageBtn;
    private MyServiceConnection.ActivityHandler


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        connectionBtn = (Button) findViewById(R.id.btn1);
        sendMessageBtn = (Button) findViewById(R.id.btn2);

        connectionBtn.setEnabled(false);
    }

    public void bindToService ( View v) {
        bindService(new Intent(this, MyBindService.class), new MyServiceConnection(), Context.BIND_AUTO_CREATE);

    }

    public void sendMessage(View v) {
        Random rnd = new Random();
        int msgType = rnd.nextInt(3);
        Message msg = Message.obtain();
        msg.what = msgType+1;
        msg.
        //Log.d(TAG, "Enviando mensaje de tipo "+ msg.what);


        try {
            messenger.send(msg);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            connectionBtn.setEnabled(false);
            sendMessageBtn.setEnabled(true);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            messenger = null;
        }



        public class ActivityHandler extends Handler {

        }
    }
}
