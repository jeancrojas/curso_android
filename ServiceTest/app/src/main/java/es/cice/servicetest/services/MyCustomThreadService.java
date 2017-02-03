package es.cice.servicetest.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import es.cice.servicetest.R;
import es.cice.servicetest.TestNotificationActivity;


public class MyCustomThreadService extends Service {

    static final String TAG = "MyCustomThreadService";
    static final int CUSTOM_WHAT = 1;
    private static final String HANDLER_THREAD_NAME = "MyCustomThread";
    private MyCustomHandler mHandler;

    public MyCustomThreadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HandlerThread mThread = new HandlerThread(HANDLER_THREAD_NAME);
        mThread.start();
        mHandler = new MyCustomHandler( mThread.getLooper() );


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Message msg =mHandler.obtainMessage(CUSTOM_WHAT);
        Log.d(TAG, "[Thread: "+Thread.currentThread().getId()+"] onStartCommand() is working...");
        mHandler.sendMessage(msg);
        return START_NOT_STICKY;
    }


    public class MyCustomHandler extends Handler {

        public MyCustomHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case CUSTOM_WHAT:
                    Log.d(TAG, "onStartCommand()...");

                    for (int i = 0; i < 10 ; i++){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, "[Thread: "+Thread.currentThread().getId()+"] MyCustomThreadService is working...");
                    }

                    Intent i = new Intent(getApplicationContext(), TestNotificationActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, i , 0);
                    Notification.Builder builder = new Notification.Builder(getApplicationContext());
                    builder
                            .setSmallIcon(R.drawable.ic_test_notification)
                            .setContentTitle("testService")
                            .setContentText("test Service finished...")
                            .setContentIntent(pendingIntent);

                    Notification notification = builder.build();
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(11111, notification);
                    break;
            }
        }
    }
}
