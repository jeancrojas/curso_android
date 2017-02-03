package es.cice.servicetest.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import es.cice.servicetest.R;
import es.cice.servicetest.TestNotificationActivity;

public class TestService extends Service {

    static final String TAG = "TestService";

    public TestService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {



    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Log.d(TAG, "onStartCommand()...");

        for (int i = 0; i < 10 ; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "[Thread : "+Thread.currentThread().getId()+"TestService working...");
        }

        Intent i = new Intent(getApplicationContext(), TestNotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, i , 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder
                .setSmallIcon(R.drawable.ic_test_notification)
                .setContentTitle("testService")
                .setContentText("test Service finished...")
                .setContentIntent(pendingIntent);

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(11111, notification);


        return START_NOT_STICKY;
    }
}
