package es.cice.binservicetest.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

import es.cice.binservicetest.R;

public class MyBindService extends Service {

    private Messenger messenger;
    public final static int MSG1 = 1;
    public final static int MSG2 = 2;
    public final static int MSG3 = 3;
    public final static int INIT_CONNECTION = 0;
    private Messenger clientMessage;


    public MyBindService() {
    }

    @Override
    public void onCreate() {


        MyHandler handler = new MyHandler();
        
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyHandler handler = new MyHandler();
        messenger = new Messenger(handler);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return messenger.getBinder();
    }

    public class MyHandler extends Handler {


        private Message message;
        public final static String TAG = "MainActivity";


        public void handleMessage (Message msg) {

            Notification.Builder builder;
            Notification n;

            switch (msg.what) {

                case INIT_CONNECTION:
                    clientMessage

                    break;

                case MSG1:
                    builder = new Notification.Builder(getApplicationContext());
                    builder.setContentText("Mensaje recibido")
                            .setSmallIcon(R.drawable.ic_msg1)
                            .setContentTitle("MSG 1");
                    n = builder.build();
                    ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(1, n);
                    break;

                case MSG2:
                    builder = new Notification.Builder(getApplicationContext());
                    builder.setContentText("Mensaje recibido")
                            .setSmallIcon(R.drawable.ic_msg2)
                            .setContentTitle("MSG 2");
                    n = builder.build();
                    ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(1, n);
                    break;


                case MSG3:
                    builder = new Notification.Builder(getApplicationContext());
                    builder.setContentText("Mensaje recibido")
                            .setSmallIcon(R.drawable.ic_msg3)
                            .setContentTitle("MSG 2");
                    n = builder.build();
                    ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(1, n);
                    break;
            }
        }


    }


}
