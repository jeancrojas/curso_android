package es.cice.mycustomeventreceiver.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyCustomAlarmReceiver extends BroadcastReceiver {
    public MyCustomAlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "received MY_CUSTOM_ALARM_RECEIVER", Toast.LENGTH_LONG).show();
    }
}
